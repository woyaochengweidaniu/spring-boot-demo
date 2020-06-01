package com.lcm.mybatisplus.hander;


import com.lcm.mybatisplus.exception.BaseException;
import com.lcm.mybatisplus.main.ApiRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 统一异常处理
 * </p>
 *
 * @description: 统一异常处理
 * @version: V1.0
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {
	private static final String DEFAULT_ERROR_VIEW = "error";

	/**
	 * 统一  异常处理
	 *
	 * @param exception BaseException
	 * @return 统一返回 json 格式
	 */
	@ExceptionHandler(value = BaseException.class)
	@ResponseBody
	public ApiRes jsonErrorHandler(BaseException exception) {
		log.error("【BaseException】:{}", exception.getMessage());
		return ApiRes.ofException(exception);
	}


}
