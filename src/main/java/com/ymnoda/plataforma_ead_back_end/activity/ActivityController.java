package com.ymnoda.plataforma_ead_back_end.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/")
    List<Activity> findAll() {
        return this.activityService.findAll();
    }

    @GetMapping("/byCourse/{courseId}")
    List<Activity> findByCourse(@PathVariable Long courseId) {
        return this.activityService.findByCourse(courseId);
    }

}
