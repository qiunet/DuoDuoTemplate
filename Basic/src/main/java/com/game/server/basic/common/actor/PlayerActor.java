package com.game.server.basic.common.actor;

import com.game.server.basic.common.enums.CDType;
import com.game.server.basic.common.event.BasePlayerEventData;
import com.game.server.basic.commondata.CommonDataService;
import com.game.server.basic.commondata.enums.CommonDataObj;
import com.game.server.basic.commondata.enums.CommonDataType;
import com.game.server.basic.player.entity.PlayerBo;
import org.qiunet.flash.handler.common.player.AbstractUserActor;
import org.qiunet.flash.handler.common.player.event.AuthEventData;
import org.qiunet.flash.handler.context.request.data.pb.IpbResponseData;
import org.qiunet.flash.handler.context.session.DSession;
import org.qiunet.listener.event.EventManager;
import org.qiunet.utils.timer.cd.CdTimer;

import java.util.concurrent.TimeUnit;

/***
 *
 * @author qiunet
 * 2020-04-15 21:01
 **/
public class PlayerActor extends AbstractUserActor<PlayerActor> {
	private CdTimer<CDType> cdTimer = new CdTimer<>();
	private PlayerBo playerBo;
	private long playerId;

	public PlayerActor(DSession session) {
		super(session);
	}

	@Override
	public boolean isCrossStatus() {
		return false;
	}

	public void setPlayerBo(PlayerBo playerBo) {
//		 有了playerBo 说明已经是有权限了 也可以是ID等
		this.playerBo = playerBo;
		this.auth(playerBo.getDo().getPlayerId());
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

	public void sendPacket(IpbResponseData message) {
		this.send(message.buildResponseMessage());
	}

	public PlayerBo getPlayerBo() {
		return playerBo;
	}

	public long getPlayerId(){
		return getId();
	}

	@Override
	public String getIdent() {
		return "PlayerActor["+getId()+"]";
	}

	@Override
	public long getId() {
		return playerId;
	}

	@Override
	public void auth(long id) {
		this.playerId = id;
		EventManager.fireEventHandler(new AuthEventData<>(this));
	}

	public String getOpenId() {
		return playerBo.getDo().getOpenId();
	}

	public <T extends CommonDataObj> T getCommonDataObj(CommonDataType type) {
		return CommonDataService.instance.getCommonObj(this, type);
	}

	/**
	 * 触发一个player事件.
	 * @param eventData
	 */
	public void submitEvent(BasePlayerEventData eventData) {
		eventData.setPlayerActor(this);
		eventData.fireEventHandler();
	}
}
