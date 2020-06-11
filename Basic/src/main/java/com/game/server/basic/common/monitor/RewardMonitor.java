package com.game.server.basic.common.monitor;

import com.game.server.basic.bag.listener.GainRewardEventData;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.logger.GameLogger;
import org.qiunet.utils.monitor.DefaultMonitor;
import org.qiunet.utils.monitor.IMonitor;
import org.qiunet.utils.monitor.IMonitorData;
import org.slf4j.Logger;

/***
 * 处理奖励获取的监控报警.
 *
 * @author qiunet
 * 2020-04-17 07:36
 **/
public class RewardMonitor implements GainRewardEventData.GainRewardDataListener {
	private Logger logger = GameLogger.GAME_MONITOR.getLogger();
	private IMonitor<Long, OperationType> rewardMonitor = new DefaultMonitor<>(
		OperationType::getCheckCount, this::handlerTrigger, OperationType::getCheckTimeMillis
	);

	/***
	 * 处理报警数据. 可以封号 打印日志等等
	 *
	 * @param data
	 * @return
	 */
	private boolean handlerTrigger(IMonitorData<Long, OperationType> data) {
		logger.error("RewardMonitor playerId {} operationType {} triggerNum {}", data.getType(), data.getSubType(), data.triggerNum());
		return true;
	}

	@Override
	public void onGainRewardData(GainRewardEventData data) {
		rewardMonitor.add(data.getPlayerActor().getPlayerId(), data.getType());
	}
}
