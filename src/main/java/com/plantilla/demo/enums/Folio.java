package com.plantilla.demo.enums;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Folio {

    public String getFolio(){
        LocalDateTime localDateTime = LocalDateTime.now();
        Pattern p = Pattern.compile("[-:T.]");
        Matcher m = p.matcher(localDateTime.toString());
        String remplazo = null;

        if(m.find()){
            remplazo = m.replaceAll("");
        }

        return "000".concat("-").concat(remplazo.substring(0, 16)).concat("00");
    }
}
