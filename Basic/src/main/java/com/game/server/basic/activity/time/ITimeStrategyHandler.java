package com.game.server.basic.activity.time;

import com.game.server.basic.activity.cfgs.TimeStrategy;

/***
 * 时间策略处理
 * 活动流程:
 * 预热 -> 开始 -> 活动时间 -> 结束  -> 关闭
 *
 * @author qiunet
 * 2021-01-25 16:27
 */
public interface ITimeStrategyHandler {
	/**
	 * 时间策略枚举
	 * @return
	 */
	TimeStrategy getTimeStrategy();

	/**
	 * 前置预热时间秒
	 * @return
	 */
	long getPreShowSeconds();

	/**
	 * 活动开启时间秒数
	 * @return
	 */
	long getOpenSeconds();

	/**
	 * 活动结束到关闭的时间秒数
	 * @return
	 */
	long getEndShowSeconds();

	/**
	 * 间隔时间
	 * @return
	 */
	long getIntervalSeconds();

	/**
	 * 活动开启次数
	 * @return
	 */
	int getOpenTimes();

}
