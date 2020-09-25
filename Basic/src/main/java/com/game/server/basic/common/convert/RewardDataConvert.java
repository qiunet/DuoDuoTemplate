package com.game.server.basic.common.convert;

import com.game.server.basic.common.data.RewardData;
import org.qiunet.cfg.convert.BaseObjConvert;
import org.qiunet.cfg.listener.CfgLoadCompleteEventData;
import org.qiunet.listener.event.EventListener;

import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * @author qiunet
 * 2020-04-25 11:33
 **/
public class RewardDataConvert extends BaseObjConvert<RewardData> {

	private static final Queue<RewardData> list = new LinkedList<>();

	@Override
	protected RewardData fromString0(String str) {
		RewardData rewardData = RewardData.parse(str);
		list.add(rewardData);
		return rewardData;
	}

	@Override
	public boolean canConvert(Class type) {
		return type == RewardData.class;
	}

	@EventListener
	public void loadComplete(CfgLoadCompleteEventData data) {
		while (! list.isEmpty()) {
			list.poll()._checkResourceWorthAndValid();
		}
	}
}
