package com.game.server.basic.common.contants;

import org.qiunet.flash.handler.common.id.IProtocolId;

/***
 * 协议id
 *
 * 0 - 999 为系统自留
 *
 * 请求id       = 模块ID * 100 + 1 起自增
 * 响应ID       = 模块ID * 100 + 请求ID * 1000 起自增
 * 无请求的响应ID = 模块ID * 100 * 1000 起自增
 *
 * 例如: 模块ID: 10
 * 请求ID范围: 1001 - 1099
 * 响应ID范围: 1001000 - 1099999
 * 无请求响应ID: 1000000 - 1000999
 * @author qiunet
 * 2020-04-25 15:16
 **/
public class ProtocolId implements IProtocolId {

	/**
	 * 登录的请求响应.
	 * 模块: 10
	 */
	public interface Login {
		/**
		 * 1 上行协议有错误. 具体读取ErrorResponse 的desc
		 **/
		int PROTOCOL_ERROR = 1000000;

		/**请求登录*/
		int REQ_LOGIN = 1001;
		/***响应登录*/
		int RESP_LOGIN = 10010000;
	}

	/***
	 * 玩家的请求响应
	 * 模块ID: 11
	 */
	public interface Player {

	}


	/**
	 * 背包的请求响应
	 * 模块ID: 12
	 */
	public interface Pack {

	}

	/**
	 * 任务的请求响应
	 * 模块ID: 13
	 */
	public interface Task {

	}

	/**
	 * 商城的请求响应
	 * 模块ID: 14
	 */
	public interface Shop {

	}
}
