package com.wt.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wt.entity.Result;
import com.wt.util.ResultUtil;

/**
 * 
 * @author hohoTT
 *
 */

@ControllerAdvice
public class ExectionHandle {
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception exception){
		return ResultUtil.error(100, exception.getMessage());
	}

}
