package com.game.template.basic.common.contants;

import org.qiunet.flash.handler.context.status.IGameStatus;

/***
 * {@link ProtocolId}模块ID * 100000 + 功能自增 * 1000 + status 自增
 * 类似响应id的规则
 * @author qiunet
 * 2020-04-30 08:05
 **/
public enum  GameStatus implements IGameStatus {
	LOGIN_AUTH_ERROR(1001000, "登录鉴权失败"),

	PLAYER_STATUS_EXAMPLE(1101000, "玩家的某个状态示例"),

	;
	private int status;
	private String desc;

	GameStatus(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getDesc() {
		return desc;
	}
}
