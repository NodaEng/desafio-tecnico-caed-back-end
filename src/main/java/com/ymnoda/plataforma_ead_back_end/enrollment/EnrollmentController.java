package com.ymnoda.plataforma_ead_back_end.enrollment;

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
@RequestMapping("/enrollment")
@CrossOrigin(origins = "http://localhost:4200")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/")
    ResponseEntity<List<Enrollment>> findAll() {
        return this.enrollmentService.findAll();
    }

    @GetMapping("/{studentClassId}/{courseId}")
    ResponseEntity<List<Enrollment>> findEnrollmentByStudentClassAndCourse(@PathVariable Long studentClassId, @PathVariable Long courseId) {
        return this.enrollmentService.findByStudentClassAndCourse(studentClassId, courseId);
    } 

    @PostMapping("/{enrollmentId}")
    ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long enrollmentId, @RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollmentId, enrollment);
    }

}
