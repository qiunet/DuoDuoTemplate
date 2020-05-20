package com.game.server.basic.common.log;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.enums.ResOperationType;

/***
 *
 * @author qiunet
 * 2020-04-25 10:05
 **/
public class M2LogEvent extends BasePlayerLogEvent {
	private OperationType operationType;
	private ResOperationType type;
	private long currNum;
	private long num;

	public M2LogEvent(PlayerActor player, OperationType operationType, ResOperationType type, long num, long currNum) {
		super(LogType.M2, player);

		this.operationType = operationType;
		this.currNum = currNum;
		this.type = type;
		this.num = num;
	}

	@Override
	public String logMessage() {
		return buildMessage()
			.add(operationType.getDesc())
			.add(type)
			.add(num)
			.add(currNum)
			.toString();
	}
}
