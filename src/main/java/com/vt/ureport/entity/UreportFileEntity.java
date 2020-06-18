package com.vt.ureport.entity;

import lombok.Data;

import java.util.Date;

/**
 * Ureport文件 实体类
 */
@Data
public class UreportFileEntity {
	
	private Long id;
	private String name;
	private byte[] content;
	private Date createTime;
	private Date updateTime;
	
}
