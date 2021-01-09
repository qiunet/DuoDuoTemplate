package com.game.server.basic.common.data.reward;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.equip.EquipService;
import org.qiunet.function.reward.BaseReward;
import org.qiunet.function.reward.RewardConfig;
import org.qiunet.function.reward.RewardContext;
import org.qiunet.function.reward.RewardResult;

/***
 * 装备奖励.
 * 可以自定义字段.
 *
 * @Author qiunet
 * @Date 2021/1/3 20:49
 **/
public class EquipReward extends BaseReward<PlayerActor> {

	public EquipReward(int cfgId, long value) {
		super(cfgId, value);
	}

	public EquipReward(RewardConfig rewardConfig) {
		super(rewardConfig);
	}

	@Override
	public RewardResult doVerify(RewardContext<PlayerActor> context) {
		// 背包限制
		return RewardResult.SUCCESS;
	}

	@Override
	public void grant(RewardContext<PlayerActor> context) {
		EquipService.instance.addToPack(context, cfgId, (int)value);
	}

	@Override
	public BaseReward<PlayerActor> copy(int multi) {
		return new EquipReward(cfgId, value);
	}
}
