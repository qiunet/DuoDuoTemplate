package com.game.template.basic.common.log;

import com.game.template.basic.common.actor.PlayerActor;
import org.qiunet.event.log.log.BaseLogEvent;
import org.qiunet.event.log.log.LogMessageBuilder;

/***
 *
 * @author qiunet
 * 2020-04-17 08:17
 **/
public abstract class BasePlayerLogEvent extends BaseLogEvent {
	protected PlayerActor player;

	public BasePlayerLogEvent(LogType logType, PlayerActor player) {
		super(logType);
		this.player = player;
	}

	protected LogMessageBuilder buildMessage() {
		LogMessageBuilder sj = new LogMessageBuilder("|");

		sj.add(createTime)
		.add(player.getOpenId())
		.add(player.getPlayerId())
		.add(player.getPlayerBo().getDo().getName())
		.add(player.getPlayerBo().getDo().getLevel())
		.add(player.getPlayerBo().getDo().getExp());
		return sj;
	}

	@Override
	public void send() {
		super.send();
	}
}
