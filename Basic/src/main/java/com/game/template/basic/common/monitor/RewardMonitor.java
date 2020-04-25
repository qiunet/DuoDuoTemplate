package com.game.template.basic.common.monitor;

import com.game.template.basic.backpack.listener.GainRewardEventData;
import com.game.template.basic.common.enums.OperationType;
import org.qiunet.utils.monitor.DefaultMonitor;
import org.qiunet.utils.monitor.IMonitor;
import org.qiunet.utils.monitor.IMonitorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/***
 * 处理奖励获取的监控报警.
 *
 * @author qiunet
 * 2020-04-17 07:36
 **/
public class RewardMonitor implements GainRewardEventData.GainRewardDataListener {
	private Logger logger = LoggerFactory.getLogger("monitor");
	private IMonitor<Long, OperationType> rewardMonitor = new DefaultMonitor<>(
		OperationType::getCheckCount, this::handlerTrigger, 60, TimeUnit.MICROSECONDS
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
