package com.ymnoda.plataforma_ead_back_end.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    List<Course> findAll() {
        return this.courseRepository.findAll();
    }
    
}
