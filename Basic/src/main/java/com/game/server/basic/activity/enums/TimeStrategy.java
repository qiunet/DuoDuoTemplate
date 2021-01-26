package com.game.server.basic.activity.enums;

/***
 * 时间策略
 *
 * @author qiunet
 * 2021-01-25 16:10
 */
public enum TimeStrategy {
	/**
	 * 绝对时间
	 */
	ABSOLUTE,
	/**
	 * 定时器
	 */
	CRON,
	/**
	 * 开服天数
	 */
	OPEN_SERVER_DAY,
}
