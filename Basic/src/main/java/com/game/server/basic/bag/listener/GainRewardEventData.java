package com.game.server.basic.bag.listener;

import com.game.server.basic.common.data.RewardData;
import com.game.server.basic.common.data.result.IRewardResult;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.event.BasePlayerEventData;

import java.util.List;

/***
 * 获得RewardData 奖励的事件 以及事件数据
 *
 * @author qiunet
 * 2020-04-17 07:59
 **/
public class GainRewardEventData extends BasePlayerEventData {
	private List<IRewardResult> resultList;
	private RewardData rewardData;
	private OperationType type;

	public static GainRewardEventData valueOf(List<IRewardResult> resultList, RewardData rewardData, OperationType type) {
		GainRewardEventData eventData = new GainRewardEventData();
		eventData.resultList = resultList;
		eventData.rewardData = rewardData;
		eventData.type = type;
		return eventData;
	}

	public RewardData getRewardData() {
		return rewardData;
	}

	public OperationType getType() {
		return type;
	}
}
