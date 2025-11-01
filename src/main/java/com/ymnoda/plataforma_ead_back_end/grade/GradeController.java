package com.ymnoda.plataforma_ead_back_end.grade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "http://localhost:4200")
public class GradeController {
    
    @Autowired
    private GradeService gradeService;

    @GetMapping("/{studentClassId}/{courseId}")
    List<Grade> getEnrollmentByStudentClassAndCourse(@PathVariable Long studentClassId, @PathVariable Long courseId) {
        return this.gradeService.getByStudentClassAndCourse(studentClassId, courseId);
    } 

    @PostMapping("/{gradeId}")
    ResponseEntity<Grade> updateGrade(@PathVariable Long gradeId, @RequestBody Grade grade) {
        return gradeService.save(gradeId, grade);
    }
}
