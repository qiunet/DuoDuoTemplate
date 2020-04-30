package com.game.template.basic.common.response;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.contants.GameStatus;
import com.game.template.basic.common.contants.ProtocolId;
import com.game.template.basic.common.proto.common.CommonProto;

/***
 *
 * @author qiunet
 * 2020-04-30 08:04
 **/
public class Message {
	/**
	 * 给客户端响应一个错误.
	 * 比如: 背包满了  钱不够了等.
	 * @param player
	 * @param status
	 */
	public static void error(PlayerActor player, GameStatus status) {
		CommonProto.ErrorResponse response = CommonProto.ErrorResponse.newBuilder().setRet(status.getStatus()).setMsg(status.getDesc()).build();
		player.sendPacket(ProtocolId.System.PROTOCOL_ERROR, response);
	}
}
