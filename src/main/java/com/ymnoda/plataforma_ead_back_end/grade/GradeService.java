package com.ymnoda.plataforma_ead_back_end.grade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    List<Grade> getByStudentClassAndCourse(Long studentClassId, Long courseId) {
        return this.gradeRepository.findByStudentClassAndCourse(studentClassId, courseId);
    }

    ResponseEntity<Grade> save(Long gradeId, Grade grade) {
        Optional<Grade> gradeData = this.gradeRepository.findById(gradeId);

        if (gradeData.isPresent()) {
            Grade _grade = gradeData.get();
            _grade.setResult(grade.getResult());
            return new ResponseEntity<>(this.gradeRepository.save(_grade), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
