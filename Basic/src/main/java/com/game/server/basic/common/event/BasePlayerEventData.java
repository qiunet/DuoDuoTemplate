package com.game.server.basic.common.event;

import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.listener.event.IEventData;

/***
 *
 *
 * @author qiunet
 * 2020-09-25 16:52
 */
public abstract class BasePlayerEventData implements IEventData {

	private PlayerActor playerActor;

	public PlayerActor getPlayerActor() {
		return playerActor;
	}

	public void setPlayerActor(PlayerActor playerActor) {
		this.playerActor = playerActor;
	}
}
