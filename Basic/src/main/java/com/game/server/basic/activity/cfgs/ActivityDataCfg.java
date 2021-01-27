package com.game.server.basic.activity.cfgs;

import com.game.server.basic.activity.time.ITimeStrategyHandler;
import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.cfg.annotation.Cfg;
import org.qiunet.cfg.base.IAfterLoad;
import org.qiunet.cfg.base.ISimpleMapCfg;
import org.qiunet.function.condition.Conditions;

/***
 * 活动表的配置
 *
 * @author qiunet
 * 2021-01-27 11:33
 */
@Cfg("config/activity/activity_data.xd")
public class ActivityDataCfg implements ISimpleMapCfg<Integer>, IAfterLoad {
	private int id;
	private String name;
	TimeStrategy timeStrategy;
	private String timeStrategyValue;
	long preShowSeconds;
	long openSeconds;
	long endShowSeconds;
	/**
	 * 玩家参与条件
	 */
	private Conditions<PlayerActor> joinConditions;
	/**
	 * 活动开启条件
	 */
	private Conditions<Void> openConditions;

	private ITimeStrategyHandler timeStrategyHandler;

	public ITimeStrategyHandler getTimeStrategyHandler() {
		return timeStrategyHandler;
	}

	public String getName() {
		return name;
	}

	public Conditions<PlayerActor> getJoinConditions() {
		return joinConditions;
	}

	public Conditions<Void> getOpenConditions() {
		return openConditions;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void afterLoad() {
		this.timeStrategyHandler = timeStrategy.convertToHandler(this, timeStrategyValue);
	}
}
