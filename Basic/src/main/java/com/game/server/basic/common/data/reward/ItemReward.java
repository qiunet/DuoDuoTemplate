package com.game.server.basic.common.data.reward;

import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.function.reward.BaseReward;
import org.qiunet.function.reward.RewardConfig;
import org.qiunet.function.reward.RewardContext;
import org.qiunet.function.reward.RewardResult;

/***
 * 物品奖励
 *
 * @Author qiunet
 * @Date 2021/1/1 20:43
 **/
public class ItemReward extends BaseReward<PlayerActor> {

	public ItemReward(int cfgId, long value) {
		super(cfgId, value);
	}

	public ItemReward(RewardConfig rewardConfig) {
		super(rewardConfig);
	}

	@Override
	public RewardResult doVerify(RewardContext<PlayerActor> context) {
		return null;
	}

	@Override
	public void grant(RewardContext<PlayerActor> context) {

	}

	@Override
	public BaseReward<PlayerActor> copy(int multi) {
		return null;
	}
}
