package com.ymnoda.plataforma_ead_back_end.enrollment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    ResponseEntity<List<Enrollment>> findAll() {
        return new ResponseEntity<>(this.enrollmentRepository.findAll(), HttpStatus.OK);
    }

    ResponseEntity<Enrollment> findEnrollmentById(Long id) {
        Optional<Enrollment> enrollment = this.enrollmentRepository.findById(id);
        if (enrollment.isPresent()){   
            return new ResponseEntity<>(enrollment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    ResponseEntity<List<Enrollment>> findByStudentClassAndCourse(Long studentClassId, Long courseId) {
        return new ResponseEntity<>(this.enrollmentRepository.findByStudentClassAndCourse(studentClassId, courseId),
                HttpStatus.OK);
    }

    ResponseEntity<Enrollment> save(Long enrollmentId, Enrollment enrollment) {
        Optional<Enrollment> enrollmentData = this.enrollmentRepository.findById(enrollmentId);

        System.out.println(enrollmentId);
        if (enrollmentData.isPresent()) {
            Enrollment _enrollment = enrollmentData.get();
            _enrollment.setTotalGrade(enrollment.getTotalGrade());
            return new ResponseEntity<>(this.enrollmentRepository.save(_enrollment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
