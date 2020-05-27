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
public class Apply {
    private String stuAwardId;
    private String stuId;
    private String stuName;
    private String college;
    private String clazz;
    private String reason;
    private String checkResult;
    private String isAltered;
}
