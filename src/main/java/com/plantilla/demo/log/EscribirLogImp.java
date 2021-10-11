package com.plantilla.demo.log;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EscribirLogImp implements EscribirLog{

    public void escribir(Class<?> clase, Nivel nivel, String mensaje){
        Logger logger = null;

        switch (nivel){
            case DEBUG:
                logger = Logger.getLogger(EscribirLogImp.class.getName());
                break;
            case INFORMATIVO:
                logger = Logger.getLogger(EscribirLogImp.class.getName());
                break;
            case TIEMPOS:
                logger = Logger.getLogger(EscribirLogImp.class.getName());
            default:
                logger = Logger.getLogger(EscribirLogImp.class.getName());
                break;
        }

        String className = clase.getSimpleName();
        StackTraceElement element = Thread.currentThread().getStackTrace()[3];
        String linea = "" + element.getLineNumber();
        String metodo = element.getMethodName();
        ThreadContext.put("linea", linea);
        ThreadContext.put("metodo", metodo);
        ThreadContext.put("clase", className);

        switch (nivel){
            case DEBUG:
                logger.info(mensaje);
                break;
            case INFORMATIVO:
                logger.info(mensaje);
                break;
            case TIEMPOS:
                logger.info(mensaje);
            case ERROR:
                logger.info(mensaje);
                break;
        }
    }
}
