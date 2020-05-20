package com.game.server.basic.common.log;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.DataResourceType;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.enums.ResOperationType;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 10:35
 ***/
public class CommonDataResourceLogEvent extends BasePlayerLogEvent {

	private OperationType operationType;
	private DataResourceType dataType;
	private ResOperationType type;
	private long currNum;
	private long num;

	public CommonDataResourceLogEvent(PlayerActor player, OperationType operationType, DataResourceType dataType, ResOperationType type, long currNum, long num) {
		super(LogType.COMMON_DATA_RESOURCE, player);
		this.operationType = operationType;
		this.dataType = dataType;
		this.type = type;
		this.currNum = currNum;
		this.num = num;
	}

	@Override
	public String logMessage() {
		return buildMessage()
			.add(dataType)
			.add(type)
			.add(operationType.getDesc())
			.add(num)
			.add(currNum)
			.toString();
	}
}
