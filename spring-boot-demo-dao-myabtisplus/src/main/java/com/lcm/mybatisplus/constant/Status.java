package com.lcm.mybatisplus.constant;

import lombok.Getter;

/**
 * <p>
 * 状态码封装
 * </p>
 *
 * @description: 状态码封装
 * @author: yangkai.shen
 * @date: Created in 2018/10/2 9:02 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 */
@Getter
public enum Status {
	/**
	 * 操作成功
	 */
	OK(200, "操作成功"),

	LOGIN_OUT(200,"已经登出"),

	/**
	 * 操作失败
	 */
	FAILED(400, "操作失败"),

	/**
	 * 登陆失败
	 */
	UN_LOGIN(401,"登录失败"),

	UPLOAD_EMPTY(400,"文件为空"),

	UPLOAD_FAILD(400,"文件上传失败"),

	/**
	 * 未知异常
	 */
	UNKNOWN_ERROR(500, "服务器出错啦"),

	/**
	 * 查询出多个结果 错误
	 */
	MULTIPLE_RESULT(500,"结果有多个，无法给出正确结果");
	/**
	 * 状态码
	 */
	private Integer code;
	/**
	 * 内容
	 */
	private String message;

	Status(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
