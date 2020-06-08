package com.tmf.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @Author tangmf
 * @Date 2020/6/8 11:36
 * @Description
 */
@Data
public class Product implements Serializable {
	private Long productId;
	private String productName;
	private String productDesc;

}
