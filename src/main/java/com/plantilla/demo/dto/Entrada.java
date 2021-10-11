package com.plantilla.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Entrada {
    private String name;
    private Date date;
}
