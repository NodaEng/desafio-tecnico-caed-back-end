package com.ymnoda.plataforma_ead_back_end.grade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("""
        SELECT g
        FROM Grade g 
        WHERE g.student.studentClass.id = :studentClassId 
        AND g.activity.course.id = :courseId
        GROUP BY student, g.id
        ORDER BY student.fullName, activity.id
        """)
    List<Grade> findByStudentClassAndCourse(Long studentClassId, Long courseId);


}
