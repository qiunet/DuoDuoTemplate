package com.game.server.basic.common.contants;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
import org.qiunet.flash.handler.context.status.IGameStatus;

/***
 * {@link ProtocolId}模块ID * 100000 + 功能自增 * 1000 + status 自增
 * 类似响应id的规则
 * @author qiunet
 * 2020-04-30 08:05
 **/
public enum  GameStatus implements IGameStatus, EnumReadable {
	LOGIN_AUTH_ERROR(1001000, "登录鉴权失败"),

	CURRENCY_LACK(1101001, "货币{}不足"),
	ITEM_LACK(2001001, "物品{}不足"),

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

	@Override
	public int value() {
		return status;
	}
}
