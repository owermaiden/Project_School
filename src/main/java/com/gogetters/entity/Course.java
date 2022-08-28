package com.gogetters.entity;

import com.gogetters.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course extends BaseEntity{

    private String name;
    private int minScore;
    private List<WeekDays> courseDay;

    public Course(int id, String name, int minScore, List<WeekDays> courseDay) {
        super(id);
        this.name = name;
        this.minScore = minScore;
        this.courseDay = courseDay;
    }
}
