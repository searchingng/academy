package com.searching.academy.entity;

import com.searching.academy.entity.audit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Lesson extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "teacher_id")
    private Long teacherId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private User teacher;

}
