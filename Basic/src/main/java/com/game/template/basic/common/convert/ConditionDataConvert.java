package com.game.template.basic.common.convert;

import com.game.template.basic.common.data.ConditionData;
import com.game.template.basic.common.data.RewardData;
import org.qiunet.cfg.convert.BaseObjConvert;
import org.qiunet.cfg.listener.CfgLoadCompleteEventData;

import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * @author qiunet
 * 2020-04-25 11:33
 **/
public class ConditionDataConvert extends BaseObjConvert<ConditionData>
	implements CfgLoadCompleteEventData.CfgLoadCompleteListener {

	private static final Queue<ConditionData> list = new LinkedList<>();

	@Override
	protected ConditionData fromString0(String str) {
		ConditionData conditionData = ConditionData.parse(str);
		list.add(conditionData);
		return conditionData;
	}

	@Override
	public boolean canConvert(Class type) {
		return type == ConditionData.class;
	}

	@Override
	public void loadComplete(CfgLoadCompleteEventData data) {
		while (! list.isEmpty()) {
			list.poll()._checkResourceWorthAndValid();
		}
	}
}
