package com.game.server.basic.equip.log;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.log.BasePlayerLogEvent;
import com.game.server.basic.common.log.LogType;

/***
 *
 *
 * @author qiunet
 * 2020-05-22 15:00
 ***/
public class EquipAddLogEvent extends BasePlayerLogEvent {
	private int equipId;
	private int equipCfgId;
	private OperationType operationType;

	public EquipAddLogEvent(PlayerActor player, int equipId, int equipCfgId, OperationType operationType) {
		super(LogType.EQUIP_ADD, player);
		this.equipId = equipId;
		this.equipCfgId = equipCfgId;
		this.operationType = operationType;
	}

	@Override
	public String logMessage() {
		return buildMessage()
			.add(equipId)
			.add(equipCfgId)
			.add(operationType)
			.toString();
	}
}
