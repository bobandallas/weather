package com.example.controller;


import com.example.pojo.dto.UserRequestDTO;
import com.example.pojo.dto.UserResponseDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

//    @Value("${server.port}")
//    private int randomServerPort;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<UserResponseDTO> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addOne(@RequestBody UserRequestDTO userRequestDTO){
        try {
            String result = userService.insertOne(userRequestDTO.getProvider());
            if(result == "success"){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

//    @GetMapping("/port")
//    public ResponseEntity<?> queryWeatherByCity() {
//        return new ResponseEntity<>("weather service + " + randomServerPort, HttpStatus.OK);
//    }

}
