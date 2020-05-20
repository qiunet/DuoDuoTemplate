package com.game.server.basic.common.convert;

import com.game.server.basic.common.data.RewardData;
import org.qiunet.cfg.convert.BaseObjConvert;
import org.qiunet.cfg.listener.CfgLoadCompleteEventData;

import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * @author qiunet
 * 2020-04-25 11:33
 **/
public class RewardDataConvert extends BaseObjConvert<RewardData>
	implements CfgLoadCompleteEventData.CfgLoadCompleteListener {

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

	@Override
	public void loadComplete(CfgLoadCompleteEventData data) {
		while (! list.isEmpty()) {
			list.poll()._checkResourceWorthAndValid();
		}
	}
}
