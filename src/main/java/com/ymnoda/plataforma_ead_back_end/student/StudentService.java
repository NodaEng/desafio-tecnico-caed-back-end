package com.ymnoda.plataforma_ead_back_end.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    List<Student> findAll() {
        return this.studentRepository.findAll();
    }

}
