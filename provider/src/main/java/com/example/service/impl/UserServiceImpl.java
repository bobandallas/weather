package com.example.service.impl;


import com.example.pojo.dto.UserResponseDTO;
import com.example.pojo.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO getAll(){
        List<User> temp = (List<User>) userRepository.findAll();
        UserResponseDTO res = new UserResponseDTO();
        res.setData(temp.stream()
                        .map((e) -> new UserResponseDTO.UserDTO(e))
                        .collect(Collectors.toList()));

        return res;
    }
    @Override
    public String insertOne(UserResponseDTO.UserDTO user){
        User temp = new User();
        temp.setDob(user.getDob());
        temp.setFirstName(user.getFirstName());
        temp.setLastName(user.getLastName());
        temp.setMiddleName(user.getMiddleName());
        System.out.println(temp);
        userRepository.saveAndFlush(temp);
        return "success";
    };
}
