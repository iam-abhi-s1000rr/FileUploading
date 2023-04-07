package com.fileupload.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fileupload.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")


public class UserController {
    @Autowired
    private ObjectMapper objectMapper;
private Logger logger= LoggerFactory.getLogger(UserController.class);
    @PostMapping("/adduser")
    ResponseEntity<?>addUserInformation(
            /*@RequestBody User user*/
            @RequestParam("file") MultipartFile file,
            @RequestParam("userData") String userData) {

        this.logger.info("user added !");
        logger.info("user:{}",userData);

        logger.info("File information:{}",file.getOriginalFilename());

        //convering json to object with object mapper
        User user=null;
        try {
            user=objectMapper.readValue(userData, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("done");
    }
}
