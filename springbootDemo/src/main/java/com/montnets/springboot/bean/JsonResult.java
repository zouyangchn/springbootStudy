package com.montnets.springboot.bean;

import lombok.Data;

@Data
public class JsonResult {

	private boolean IsSuccessful;
	private String ResultCode;
	private String ResultDesc;

}
