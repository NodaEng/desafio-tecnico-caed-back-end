package com.ymnoda.plataforma_ead_back_end.studentClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentClass")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentClassController {

    @Autowired
    StudentClassService studentClassService;

    @GetMapping("/")
    List<StudentClass> findAll() {
        return this.studentClassService.findAll();
    }
    
}
