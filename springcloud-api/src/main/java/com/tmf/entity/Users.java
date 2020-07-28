package com.tmf.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @Author tmf
 * @Date 2020/7/28 22:23
 * @Description
 */
@Data
public class Users implements Serializable {
    private String name;
    private int age;
    private String sex;
}
