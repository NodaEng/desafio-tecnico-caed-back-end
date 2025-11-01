package com.ymnoda.plataforma_ead_back_end.activity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    
    @Query("""
        SELECT a
        FROM Activity a
        WHERE a.course.id = :courseId
        ORDER BY a.id
            """)
    List<Activity> findByCourse(Long courseId);

}
