package com.example.search.service;

import com.example.search.domain.dto.ProviderDTO;
import com.example.search.domain.dto.ResponseDTO;
import com.example.search.domain.dto.UniversityStudentDTO;
import com.example.search.domain.dto.UniversityTeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class SearchServiceImp implements SearchService{

    private final RestTemplate restTemplate;

    private static final ExecutorService pool = Executors.newCachedThreadPool();
//    @Value("${url.university}")
//    private String universityUrl;
//
//    @Value("${user.provider}")

    @Value("${url.gatewayUrl}")
    private String gatewayUrl;


    @Autowired
    public SearchServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseDTO searchFunction() {

        List<CompletableFuture<?>> list = new ArrayList<>();
        ResponseDTO res = new ResponseDTO();


        CompletableFuture<?> cf = CompletableFuture.supplyAsync(() -> {
            ProviderDTO providerDTO = null;
            try {
                providerDTO = restTemplate.getForObject(gatewayUrl + "user", ProviderDTO.class);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
//            return providerDTO;
            res.setProvider(providerDTO);
            return null;
        }, pool).orTimeout(1000, TimeUnit.SECONDS);
        list.add(cf);

        CompletableFuture<?> cf1 = CompletableFuture.supplyAsync(() -> {
            UniversityTeacherDTO universityTeacherDTO = null;
            try {
                universityTeacherDTO = restTemplate.getForObject(gatewayUrl + "university/teacher", UniversityTeacherDTO.class);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            res.setTeacher(universityTeacherDTO);
            return null;
        }, pool).orTimeout(1000, TimeUnit.SECONDS);
        list.add(cf1);


        CompletableFuture<?> cf2 = CompletableFuture.supplyAsync(() -> {
            UniversityStudentDTO universityStudentDTO = null;
            try {
                universityStudentDTO = restTemplate.getForObject(gatewayUrl + "university/student", UniversityStudentDTO.class);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            res.setStudent(universityStudentDTO);
            return null;
        }, pool).orTimeout(1000, TimeUnit.SECONDS);
        list.add(cf2);

        CompletableFuture<?> tasks = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]))
                .thenApply(Void -> list.stream().map(task -> task.join()));

        tasks.join();
        while(!tasks.isDone()){

        }
        return res;

//        providerDTO = restTemplate.getForObject(gatewayUrl + "user", ProviderDTO.class);
//        UniversityTeacherDTO universityTeacherDTO = restTemplate.getForObject(gatewayUrl + "university/teacher", UniversityTeacherDTO.class);
//        UniversityStudentDTO universityStudentDTO = restTemplate.getForObject(gatewayUrl + "university/student", UniversityStudentDTO.class);
//        return new ResponseDTO(providerDTO, universityStudentDTO, universityTeacherDTO);
    }
}
