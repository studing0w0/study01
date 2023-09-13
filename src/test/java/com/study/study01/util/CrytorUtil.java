package com.study.study01.util;

import com.study.study01.config.SecurityConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 암호화 관련 util class
 */
//@RequiredArgsConstructor
public class CrytorUtil {
    private ApplicationContext ctx = null;
    private PasswordEncoder encoder = null;
    private AesBytesEncryptor encryptor = null;

    public CrytorUtil(){
        ctx = new AnnotationConfigApplicationContext(SecurityConfig.class);
        encoder = ctx.getBean(PasswordEncoder.class);
        encryptor =ctx.getBean(AesBytesEncryptor.class);
    }

    // 단방향 암호화 시 사용 SHA256
    public String encodeSHA256(String origin)  {
        return encoder.encode(origin).replace("{sha256}", "");
    }

    /*
        양방향 암호화하여 db에 저장할 때 사용
        origin : 암호화해야할 구문
     */
    public String encodeAesByte(String origin){
        return Base64.getEncoder().encodeToString(encryptor.encrypt(origin.getBytes(StandardCharsets.UTF_8)));
    }


    // db에 저장된 양방향 암호화된 정보를 복호화 시 사용
    public String decodeAesByte(String enc) {
        return new String(encryptor.decrypt(Base64.getDecoder().decode(enc)));
    }

}
