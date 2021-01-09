package com.game.server.basic.common.data.reward;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.DataResourceType;
import com.google.common.base.Preconditions;
import org.qiunet.function.consume.ConsumeResult;
import org.qiunet.function.reward.*;

/***
 * 货币奖励
 *
 * @Author qiunet
 * @Date 2021/1/3 20:44
 **/
public class CurrencyReward extends BaseReward<PlayerActor> implements IRealReward {
	public CurrencyReward(int cfgId, long value) {
		super(cfgId, value);
	}

	public CurrencyReward(RewardConfig rewardConfig) {
		super(rewardConfig);
	}

	@Override
	public RewardResult doVerify(RewardContext<PlayerActor> context) {
		// 直接放入. 没有问题
		return RewardResult.SUCCESS;
	}

	@Override
	public void grant(RewardContext<PlayerActor> context) {
	}

	@Override
	public BaseReward<PlayerActor> copy(int multi) {
		Preconditions.checkArgument(multi * value > 0);
		return new CurrencyReward(cfgId, multi * value);
	}
}
