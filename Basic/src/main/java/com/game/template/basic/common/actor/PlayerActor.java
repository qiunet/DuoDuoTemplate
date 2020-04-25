package com.game.template.basic.common.actor;

import com.game.template.basic.common.enums.CDType;
import com.game.template.basic.common.session.GameSession;
import com.game.template.basic.player.entity.PlayerBo;
import com.google.protobuf.GeneratedMessageV3;
import org.qiunet.flash.handler.common.player.AbstractPlayerActor;
import org.qiunet.flash.handler.context.response.push.DefaultProtobufMessage;
import org.qiunet.utils.timer.cd.CdTimer;

import java.util.concurrent.TimeUnit;

/***
 *
 * @author qiunet
 * 2020-04-15 21:01
 **/
public class PlayerActor extends AbstractPlayerActor<GameSession, PlayerActor> {
	private CdTimer cdTimer = new CdTimer();
	private PlayerBo playerBo;

	public PlayerActor(GameSession session) {
		super(session);
	}

	public void auth(PlayerBo playerBo) {
//		 有了playerBo 说明已经是有权限了 也可以是ID等
		this.playerBo = playerBo;
	}


	public CdTimer getCdTimer(){
		return cdTimer;
	}

	public void recordCd(CDType cdType, long period, TimeUnit unit) {
		cdTimer.recordCd(cdType, period, unit);
	}

	public void recordCd(CDType cdType) {
		cdTimer.recordCd(cdType);
	}

	public boolean isCdTimeOut(CDType cdType) {
		return cdTimer.isTimeout(cdType);
	}

	public void sendPacket(int protocolId, GeneratedMessageV3 message) {
		this.send(new DefaultProtobufMessage(protocolId, message));
	}

	public PlayerBo getPlayerBo() {
		return playerBo;
	}

	@Override
	protected String getIdent() {
		return "PlayerActor["+getPlayerId()+"]";
	}

	@Override
	public long getPlayerId() {
		if (playerBo == null) {
			// 没有鉴权.时候bo为null
			return 0;
		}
		return playerBo.getDo().getPlayerId();
	}

	@Override
	public String getOpenId() {
		return null;
	}
}
