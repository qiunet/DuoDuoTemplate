package com.game.server.basic.activity.time;

import com.game.server.basic.activity.cfgs.BaseTimeStrategyHandler;

import java.util.Date;

/***
 *
 *
 * @author qiunet
 * 2021-01-27 10:50
 */
public class AbsoluteTimeStrategyHandler extends BaseTimeStrategyHandler {
	/**
	 * 开启的时间
	 */
	private Date value;
	/**
	 * 再次开启间隔时间
	 */
	private int intervalSeconds;
	/**
	 * 可以开启的次数
	 */
	private int openTimes;

	public long getStartDt() {
		return value.getTime();
	}

	@Override
	public long getIntervalSeconds() {
		return intervalSeconds;
	}

	@Override
	public int getOpenTimes() {
		return openTimes;
	}
}
