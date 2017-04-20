package com.wt.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wt.Exception.GirlException;
import com.wt.entity.Result;
import com.wt.util.ResultUtil;

/**
 * 
 * @author hohoTT
 *
 */

@ControllerAdvice
public class ExectionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExectionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception exception) {
		if (exception instanceof GirlException) {
			GirlException girlException = (GirlException) exception;
			return ResultUtil.error(girlException.getCode(), girlException.getMessage());
		} else {
			logger.info("系统异常 {}", exception);
			return ResultUtil.error(-1, exception.getMessage());
		}
	}

}
