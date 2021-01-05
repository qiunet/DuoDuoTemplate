package com.game.server.basic.common.data.consume;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.DataResourceType;
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

	@Override
	protected ConsumeResult doVerify(ConsumeContext<PlayerActor> context) {
		DataResourceType dataResourceType = DataResourceType.parse(cfgId);
		boolean pass = dataResourceType.getResourceNum(context.getObj()) >= value;
		return pass ? ConsumeResult.SUCCESS : ConsumeResult.FAIL;
	}

	@Override
	protected void doConsume(ConsumeContext<PlayerActor> context) {
		DataResourceType dataResourceType = DataResourceType.parse(cfgId);
		dataResourceType.deductResource(context.getObj(), context.getOperationType(), value);
	}

	@Override
	public BaseConsume<PlayerActor> copy() {
		return new CurrencyConsume(cfgId, value);
	}
}
