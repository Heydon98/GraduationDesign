package com.heydon.ezheli.util;

import org.junit.jupiter.api.Test;

public class JwtUtilTest {

    @Test
    public void createTokenTest() {
        System.out.println(JwtUtil.createToken("2016329600163"));
    }
}
