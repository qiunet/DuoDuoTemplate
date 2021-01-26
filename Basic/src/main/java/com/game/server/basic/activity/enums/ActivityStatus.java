package com.game.server.basic.activity.enums;

import org.qiunet.utils.exceptions.EnumParseException;

/***
 * 活动状态
 *
 * @author qiunet
 * 2021-01-25 11:48
 */
public enum ActivityStatus {
	/**
	 *  等待开启
	 */
	WAIT_OPEN(0),
	/**
	 * 开启状态
	 */
	OPEN(1),
	/**
	 * 结束
	 */
	END(2),
	/**
	 * 关闭活动
	 */
	CLOSE(3),

	;
	private int status;

	ActivityStatus(int status) {
		this.status = status;
	}
	private static final ActivityStatus [] values = values();
	public int getStatus() {
		return status;
	}

	public static ActivityStatus parse(int status) {
		if (status >= values.length || status < 0) {
			throw new EnumParseException(status);
		}
		return values[status];
	}
}
