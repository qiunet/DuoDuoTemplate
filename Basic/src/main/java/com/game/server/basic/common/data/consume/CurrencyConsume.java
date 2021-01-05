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
public class CurrencyConsume extends BaseConsume<PlayerActor> {

	public CurrencyConsume(ConsumeConfig consumeConfig) {
		super(consumeConfig);
	}

	public CurrencyConsume(int cfgId, long value) {
		super(cfgId, value);
	}

	public CurrencyConsume(int cfgId, long value, boolean banReplace) {
		super(cfgId, value, banReplace);
	}

	public static CurrencyConsume valueOf(int cfgId, long value, boolean banReplace) {
		return new CurrencyConsume(cfgId, value, banReplace);
	}
	public static CurrencyConsume valueOf(int cfgId, long value) {
		return new CurrencyConsume(cfgId, value);
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
		return CurrencyConsume.valueOf(cfgId, value);
	}
}
