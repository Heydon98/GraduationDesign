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
public class PersonalInfo {
    private String stuId;
    private String stuName;
    private String college;
    private String major;
    private String classYear;
    private String clazz;
    private String wechat;
    private String qq;
    private String tel;
    private String email;
}
