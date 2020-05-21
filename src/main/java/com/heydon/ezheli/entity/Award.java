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
public class Award {
    private int awardId;
    private String awardType;
    private String awardName;
    private String startTime;
    private String introduce;
    private int limitNum;
    private int stateId;
    private String awardState;
}
