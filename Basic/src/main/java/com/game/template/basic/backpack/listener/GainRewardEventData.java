package com.game.template.basic.backpack.listener;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.data.RewardData;
import com.game.template.basic.common.data.result.IRewardResult;
import com.game.template.basic.common.enums.OperationType;
import org.qiunet.utils.listener.EventListener;
import org.qiunet.utils.listener.IEventData;

import java.util.List;

/***
 * 获得RewardData 奖励的事件 以及事件数据
 *
 * @author qiunet
 * 2020-04-17 07:59
 **/
@EventListener(GainRewardEventData.GainRewardDataListener.class)
public class GainRewardEventData implements IEventData {
	private List<IRewardResult> resultList;
	private PlayerActor playerActor;
	private RewardData rewardData;
	private OperationType type;

	public GainRewardEventData(PlayerActor playerActor, List<IRewardResult> resultList, RewardData rewardData, OperationType type) {
		this.playerActor = playerActor;
		this.rewardData = rewardData;
		this.type = type;
	}

	public PlayerActor getPlayerActor() {
		return playerActor;
	}

	public RewardData getRewardData() {
		return rewardData;
	}

	public OperationType getType() {
		return type;
	}

	public interface GainRewardDataListener {

		void onGainRewardData(GainRewardEventData data);
	}
}
