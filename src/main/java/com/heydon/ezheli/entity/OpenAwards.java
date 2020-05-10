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
public class OpenAwards {

    private int awardId;
    private String awardName;
    private String introduce;
    private int limitNum;
    private String teacName;
    private long isApplied;
    private String type;
}
