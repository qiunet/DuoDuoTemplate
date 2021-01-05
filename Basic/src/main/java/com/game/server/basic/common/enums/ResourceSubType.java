package com.game.server.basic.common.enums;

import com.game.server.basic.common.data.consume.CurrencyConsume;
import com.game.server.basic.common.data.consume.EquipConsume;
import com.game.server.basic.common.data.consume.ItemConsume;
import com.game.server.basic.common.data.reward.CurrencyReward;
import com.game.server.basic.common.data.reward.EquipReward;
import com.game.server.basic.common.data.reward.ExpReward;
import com.game.server.basic.common.data.reward.ItemReward;
import org.qiunet.function.base.IResourceSubType;
import org.qiunet.function.consume.BaseConsume;
import org.qiunet.function.consume.ConsumeConfig;
import org.qiunet.function.reward.BaseReward;
import org.qiunet.function.reward.RewardConfig;
import org.qiunet.utils.exceptions.CustomException;

/***
 *
 * @Author qiunet
 * @Date 2020/12/31 21:50
 **/
public enum ResourceSubType implements IResourceSubType {
	/**
	 * 货币
 	 */
	DATA_CURRENCY(CurrencyReward.class, CurrencyConsume.class),
	/**
	 * 人物经验
	 */
	DATA_EXP (ExpReward.class, null),
	/**
	 * 普通道具
	 */
	ITEM_NORMAL (ItemReward.class, ItemConsume.class),
	/**
	 * 普通装备
	 */
	EQUIP_NORMAL(EquipReward.class, EquipConsume.class),
	;
	/**
	 * 相关类型奖励的class
	 */
	private final Class<? extends BaseReward> rewardClz;
	/**
	 * 相关类型消耗的class
	 */
	private final Class<? extends BaseConsume> consumeClz;

	ResourceSubType(Class<? extends BaseReward> rewardClz, Class<? extends BaseConsume> consumeClz) {
		this.rewardClz = rewardClz;
		this.consumeClz = consumeClz;
	}

	@Override
	public <T extends BaseConsume> T createConsume(ConsumeConfig consumeConfig) {
		if (consumeClz == null) {
			throw new CustomException("Not support ");
		}
		return null;
	}

	@Override
	public <T extends BaseReward> T createRewardItem(RewardConfig rewardConfig) {
		return null;
	}
}
