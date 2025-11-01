package com.ymnoda.plataforma_ead_back_end.studentClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentClassService {
    
    @Autowired
    StudentClassRepository studentClassRepository;

    List<StudentClass> findAll() {
        return this.studentClassRepository.findAll();
    }

}
