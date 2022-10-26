package com.example.email2.api;

import com.example.email2.email.EmailService;
import com.example.email2.entities.Student;
import com.example.email2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    EmailService emailService;

    @Autowired
    StudentService studentService;

    @PostMapping("/notification")
    public ResponseEntity sendToEmail(@RequestBody NotificatioDTO payload){
        try{
            Student studentFromDB= studentService.findById(payload.getId());
            if(studentFromDB==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student not found");
            else
            emailService.sendTo(studentFromDB.getEmail(), payload.getTitle(), payload.getText());
            return ResponseEntity.status(HttpStatus.OK).body("Top");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
