package com.ymnoda.plataforma_ead_back_end.enrollment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("""
        SELECT e 
        FROM Enrollment e 
        WHERE e.student.studentClass.id = :studentClassId 
        AND e.course.id = :courseId
        """)
    List<Enrollment> findByStudentClassAndCourse(Long studentClassId, Long courseId);

}
