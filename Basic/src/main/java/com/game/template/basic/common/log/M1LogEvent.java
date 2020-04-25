package com.game.template.basic.common.log;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.enums.OperationType;
import com.game.template.basic.common.enums.ResOperationType;

/***
 *
 * @author qiunet
 * 2020-04-25 10:05
 **/
public class M1LogEvent extends BasePlayerLogEvent {
	private OperationType operationType;
	private ResOperationType type;
	private long currNum;
	private long num;
	public M1LogEvent(PlayerActor player, OperationType operationType, ResOperationType type, int num, long currNum) {
		super(LogType.M1, player);

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
