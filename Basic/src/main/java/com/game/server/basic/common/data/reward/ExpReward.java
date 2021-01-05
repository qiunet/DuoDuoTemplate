package com.game.server.basic.common.data.reward;

import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.function.reward.BaseReward;
import org.qiunet.function.reward.RewardConfig;
import org.qiunet.function.reward.RewardContext;
import org.qiunet.function.reward.RewardResult;

/***
 * 人物经验经历
 *
 * @Author qiunet
 * @Date 2021/1/3 20:39
 **/
public class ExpReward extends BaseReward<PlayerActor> {

	public ExpReward(int cfgId, long value) {
		super(cfgId, value);
	}

	public ExpReward(RewardConfig rewardConfig) {
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
