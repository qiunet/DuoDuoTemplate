package com.game.server.basic.common.data.reward;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.player.PlayerService;
import org.qiunet.function.reward.*;

/***
 * 人物经验经历
 *
 * @Author qiunet
 * @Date 2021/1/3 20:39
 **/
public class ExpReward extends BaseReward<PlayerActor> implements IRealReward {

	public ExpReward(int cfgId, long value) {
		super(cfgId, value);
	}

	public ExpReward(RewardConfig rewardConfig) {
		super(rewardConfig);
	}

	@Override
	public RewardResult doVerify(RewardContext<PlayerActor> context) {
		return RewardResult.SUCCESS;
	}

	@Override
	public void grant(RewardContext<PlayerActor> context) {
		PlayerService.instance.addPlayerExp(context.getPlayer(), context, value);
	}

	@Override
	public BaseReward<PlayerActor> copy(int multi) {
		return new ExpReward(cfgId, value);
	}
}
