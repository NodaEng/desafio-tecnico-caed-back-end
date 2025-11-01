package com.ymnoda.plataforma_ead_back_end.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    List<Activity> findAll() {
        return this.activityRepository.findAll();
    }

    List<Activity> findByCourse(Long courseId) {
        return this.activityRepository.findByCourse(courseId);
    }

}
