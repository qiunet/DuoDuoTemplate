package com.game.server.basic.common.data.reward;

import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.function.reward.BaseReward;
import org.qiunet.function.reward.RewardConfig;
import org.qiunet.function.reward.RewardContext;
import org.qiunet.function.reward.RewardResult;

/***
 * 货币奖励
 *
 * @Author qiunet
 * @Date 2021/1/3 20:44
 **/
public class CurrencyReward extends BaseReward<PlayerActor> {
	public CurrencyReward(int cfgId, long value) {
		super(cfgId, value);
	}

	public CurrencyReward(RewardConfig rewardConfig) {
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
