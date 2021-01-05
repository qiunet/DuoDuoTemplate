package com.game.server.basic.common.data.consume;

import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.function.consume.BaseConsume;
import org.qiunet.function.consume.ConsumeConfig;
import org.qiunet.function.consume.ConsumeContext;
import org.qiunet.function.consume.ConsumeResult;

/***
 *
 * @Author qiunet
 * @Date 2021/1/3 21:08
 **/
public class EquipConsume extends BaseConsume<PlayerActor> {

	public EquipConsume(ConsumeConfig consumeConfig) {
		super(consumeConfig);
	}

	public EquipConsume(int cfgId, long value) {
		super(cfgId, value);
	}

	public EquipConsume(int cfgId, long value, boolean banReplace) {
		super(cfgId, value, banReplace);
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
		return null;
	}
}
