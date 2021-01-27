package com.game.server.basic.activity.time;

import com.game.server.basic.activity.cfgs.BaseTimeStrategyHandler;

/***
 *
 *
 * @author qiunet
 * 2021-01-27 11:09
 */
public class CronTimeStrategyHandler extends BaseTimeStrategyHandler {
	private String value;


	@Override
	public long getIntervalSeconds() {
		return 0;
	}

	@Override
	public int getOpenTimes() {
		return 0;
	}
}
