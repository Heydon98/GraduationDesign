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
public class ApplyingAwards {

    private int awardId;
    private String awardName;
    private String introduce;
    private int limitNum;
    private String endApplyTime;
    private long isApplied;
    private String type;
}
