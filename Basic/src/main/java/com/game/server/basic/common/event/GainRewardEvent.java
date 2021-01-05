package com.game.server.basic.common.event;

import com.game.server.basic.common.enums.OperationType;

/***
 * 获得奖励事件
 * 仅仅获得奖励本身
 *
 * @author qiunet
 * 2021-01-05 20:43
 */
public class GainRewardEvent extends BasePlayerEventData {
	private OperationType type;

	public static GainRewardEvent valueOf(OperationType type) {
		GainRewardEvent event = new GainRewardEvent();
		event.type = type;
		return event;
	}

	public OperationType getType() {
		return type;
	}
}
