package com.quickserve.auth.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class OtpGenerator {
   private static final SecureRandom random =  new SecureRandom();

   public String generateOpt(){
       int opt = 100000 + random.nextInt(900000);
       return String.valueOf(opt);
   }
}
