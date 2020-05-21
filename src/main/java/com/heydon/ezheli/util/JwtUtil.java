package com.heydon.ezheli.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *Java Web Token工具类
 */
public class JwtUtil {

    /**
     * 过期时间15分钟
     */
    private static final long EXPIRE_TIME = 15 * 60 * 1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "0c3875464ef041228063e49ba741c0b1";

    /**
     * 生成token，15min过期
     * @param username
     * @return 加密的token
     */
    public static String createToken(String username, int collegeId, String realName) {

        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头部信息
        Map<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username生成签名
        return JWT.create()
                .withHeader(header)
                .withClaim("username", username)
                .withClaim("collegeId", collegeId)
                .withClaim("realName", realName)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 验证token
     * @param token
     * @return token是否正确
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 获取token中包含的用户名
     * @param token
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e){
            return null;
        }
    }

    /**
     * 获取token中包含的学院ID
     * @param token
     * @return token中包含的学院ID
     */
    public static int getCollegeId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("collegeId").asInt();
        } catch (JWTDecodeException e){
            return -1;
        }
    }

    public static String getRealName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("realName").asString();
        } catch (JWTDecodeException e){
            return null;
        }
    }
}
