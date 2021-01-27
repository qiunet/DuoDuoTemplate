package com.game.server.basic.activity.cfgs;

import com.game.server.basic.activity.time.ITimeStrategyHandler;

/***
 * 时间处理基类
 *
 * @author qiunet
 * 2021-01-25 16:28
 */
public abstract class BaseTimeStrategyHandler implements ITimeStrategyHandler {

	/**
	 * 预热时间. 可以查看. 但是没有开始
	 */
	protected long preShowSeconds;
	/**
	 *  活动时间.
	 */
	protected long openSeconds;
	/**
	 * 结束时间 - 然后关闭.
	 */
	protected long endShowSeconds;
	/**
	 * 时间策略
	 */
	protected TimeStrategy timeStrategy;

	void init(ActivityDataCfg cfg) {
		this.preShowSeconds = cfg.preShowSeconds;
		this.openSeconds = cfg.openSeconds;
		this.endShowSeconds = cfg.endShowSeconds;
		this.timeStrategy = cfg.timeStrategy;
	}

	@Override
	public TimeStrategy getTimeStrategy() {
		return timeStrategy;
	}

	@Override
	public long getEndShowSeconds() {
		return endShowSeconds;
	}

	@Override
	public long getOpenSeconds() {
		return openSeconds;
	}

	@Override
	public long getPreShowSeconds() {
		return preShowSeconds;
	}
}
