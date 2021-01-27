package com.game.server.basic.activity.time;

import com.game.server.basic.activity.cfgs.BaseTimeStrategyHandler;

/***
 *
 *
 * @author qiunet
 * 2021-01-27 11:10
 */
public class OpenServerDayTimeStrategyHandler extends BaseTimeStrategyHandler {
	/**
	 * 再次开启间隔时间
	 */
	private int intervalSeconds;
	/**
	 * 可以开启的次数
	 */
	private int openTimes;
	/**
	 * openDay
	 */
	private int value;

	/**
	 * 开服多少天后
	 * @return
	 */
	public int getAfterOpenDay(){
		return value;
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
