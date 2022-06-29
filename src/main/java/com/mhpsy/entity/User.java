package com.mhpsy.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class User {
    private int id;
    private String name;
    private int age;
}
