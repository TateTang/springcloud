package com.tmf.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @Author tangmf
 * @Date 2020/6/29 16:09
 * @Description
 */
@Data
public class User implements Serializable {
	private String name;
	private int age;
	private String sex;
}
