package com.game.server.basic.item.log;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.enums.ResOperationType;
import com.game.server.basic.common.log.BasePlayerLogEvent;
import com.game.server.basic.common.log.LogType;

/***
 *
 *
 * @author qiunet
 * 2020-05-14 18:03
 ***/
public class ItemLogEvent extends BasePlayerLogEvent {
	private int itemId;
	private int num;
	private int currCount;
	private OperationType operationType;
	private ResOperationType resOperationType;

	public ItemLogEvent(PlayerActor player, int itemId, int num, int currCount, OperationType operationType, ResOperationType resOperationType) {
		super(LogType.ITEM, player);
		this.itemId = itemId;
		this.num = num;
		this.currCount = currCount;
		this.operationType = operationType;
		this.resOperationType = resOperationType;
	}

	@Override
	public String logMessage() {
		return buildMessage()
			.add(itemId)
			.add(num)
			.add(currCount)
			.add(resOperationType.name())
			.add(operationType.getDesc())
			.toString();
	}
}
