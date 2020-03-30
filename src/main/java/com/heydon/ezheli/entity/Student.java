package com.heydon.ezheli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student {

    /*private String stuId;
    private String password;
    private String name;
    private String gender;
    private String college;
    private int grade;
    private String major;
    private String clazz;*/

    private String stuId;
    private String password;
    private String name;
    private String sex;
    private int collegeId;
    private int gradeId;
    private int majorId;
    private int classId;

}
