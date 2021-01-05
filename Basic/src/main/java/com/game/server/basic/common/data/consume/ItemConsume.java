package com.game.server.basic.common.data.consume;

import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.function.consume.BaseConsume;
import org.qiunet.function.consume.ConsumeConfig;
import org.qiunet.function.consume.ConsumeContext;
import org.qiunet.function.consume.ConsumeResult;

/***
 *
 * @Author qiunet
 * @Date 2021/1/1 08:43
 **/
public class ItemConsume extends BaseConsume<PlayerActor> {

	public ItemConsume(ConsumeConfig consumeConfig) {
		super(consumeConfig);
	}

	public ItemConsume(int cfgId, long value) {
		super(cfgId, value);
	}

	public static ItemConsume valueOf(int cfgId, long value) {
		return new ItemConsume(cfgId, value);
	}

	@Override
	protected ConsumeResult doVerify(ConsumeContext<PlayerActor> context) {
		return null;
	}

	@Override
	protected void doConsume(ConsumeContext<PlayerActor> context) {

	}

	@Override
	public BaseConsume<PlayerActor> copy() {
		return ItemConsume.valueOf(cfgId, value);
	}
}
