package com.game.server.basic.common.data.reward;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.item.ItemService;
import org.qiunet.function.reward.*;

/***
 * 物品奖励
 *
 * @Author qiunet
 * @Date 2021/1/1 20:43
 **/
public class ItemReward extends BaseReward<PlayerActor> implements IRealReward {

	public ItemReward(int cfgId, long value) {
		super(cfgId, value);
	}

	public ItemReward(RewardConfig rewardConfig) {
		super(rewardConfig);
	}

	@Override
	public RewardResult doVerify(RewardContext<PlayerActor> context) {
		return RewardResult.SUCCESS;
	}

	@Override
	public void grant(RewardContext<PlayerActor> context) {
		ItemService.instance.addToPack(context.getPlayer(), cfgId, (int)value, context.getOperationType());
	}

	@Override
	public BaseReward<PlayerActor> copy(int multi) {
		return null;
	}
}
