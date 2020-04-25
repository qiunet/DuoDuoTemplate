package com.game.template.basic.common.ex;

/***
 * 无效枚举的异常
 * @author qiunet
 * 2020-04-15 21:21
 **/
public class InvalidEnumException extends RuntimeException {
	public InvalidEnumException() {
	}

	public InvalidEnumException(String message) {
		super(message);
	}

	public InvalidEnumException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEnumException(Throwable cause) {
		super(cause);
	}

	public InvalidEnumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
