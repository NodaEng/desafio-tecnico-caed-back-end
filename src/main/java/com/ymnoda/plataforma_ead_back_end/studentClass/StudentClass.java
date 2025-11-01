package com.ymnoda.plataforma_ead_back_end.studentClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String code;

    // @OneToMany(mappedBy = "studentClass", fetch = FetchType.LAZY)
    // List<Student> students;
    
}
