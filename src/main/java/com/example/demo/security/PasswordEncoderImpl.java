package com.example.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        try {
            //MD5加密
            return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
