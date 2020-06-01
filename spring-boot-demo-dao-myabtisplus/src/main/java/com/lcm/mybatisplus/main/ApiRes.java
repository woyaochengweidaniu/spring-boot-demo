package com.lcm.mybatisplus.main;


import com.lcm.mybatisplus.constant.Status;
import com.lcm.mybatisplus.exception.BaseException;
import lombok.Data;

/**
 * <p>
 * 通用的 API 接口封装
 * </p>
 *
 *
 * @description: 通用的 API 接口封装
 */
@Data
public class ApiRes {
	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 返回内容
	 */
	private String msg;

	/**
	 * 返回数据
	 */
	private Object data;

	/**
	 * 无参构造函数
	 */
	private ApiRes() {

	}

	/**
	 * 全参构造函数
	 *
	 * @param code    状态码
	 * @param message 返回内容
	 * @param data    返回数据
	 */
	private ApiRes(Integer code, String message, Object data) {
		this.code = code;
		this.msg = message;
		this.data = data;
	}

	/**
	 * 构造一个自定义的API返回
	 *
	 * @param code    状态码
	 * @param message 返回内容
	 * @param data    返回数据
	 * @return ApiResponse
	 */
	public static ApiRes of(Integer code, String message, Object data) {
		return new ApiRes(code, message, data);
	}

	/**
	 * 构造一个成功且带数据的API返回
	 *
	 * @param data 返回数据
	 * @return ApiResponse
	 */
	public static ApiRes ofSuccess(Object data) {
		return ofStatus(Status.OK, data);
	}

	/**
	 * 构造一个成功且自定义消息的API返回
	 *
	 * @param message 返回内容
	 * @return ApiResponse
	 */
	public static ApiRes ofMessage(String message) {
		return of(Status.OK.getCode(), message, null);
	}

	/**
	 * 构造一个有状态的API返回
	 *
	 * @param status 状态 {@link Status}
	 * @return ApiResponse
	 */
	public static ApiRes ofStatus(Status status) {
		return ofStatus(status, null);
	}


	/**
	 * 构造一个有状态且带数据的API返回
	 *
	 * @param status 状态 {@link Status}
	 * @param data   返回数据
	 * @return ApiResponse
	 */
	public static ApiRes ofStatus(Status status, Object data) {
		return of(status.getCode(), status.getMessage(), data);
	}

	public static ApiRes ofStatus(boolean b) {
		if (b){
			return ofStatus(Status.OK);
		}else {
			return ofStatus(Status.FAILED);
		}

	}

	/**
	 * 构造一个异常且带数据的API返回
	 *
	 * @param t    异常
	 * @param data 返回数据
	 * @param <T>  {@link BaseException} 的子类
	 * @return ApiResponse
	 */
	public static <T extends BaseException> ApiRes ofException(T t, Object data) {
		return of(t.getCode(), t.getMessage(), data);
	}

	/**
	 * 构造一个异常且带数据的API返回
	 *
	 * @param t   异常
	 * @param <T> {@link BaseException} 的子类
	 * @return ApiResponse
	 */
	public static <T extends BaseException> ApiRes ofException(T t) {
		return ofException(t, null);
	}
}
