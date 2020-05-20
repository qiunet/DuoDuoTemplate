package com.game.server.basic.common.contants;

/***
 * 协议id
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
public class ProtocolId {
	/***
	 * 系统自留 一般为下行id
	 * 模块 ID: 0 - 9
	 */
	public interface System {
		/**1 上行协议有错误. 具体读取ErrorResponse 的desc**/
		int PROTOCOL_ERROR = 1;
		/** 404 */
		int HANDLER_NOT_FIND = 404;
		/** 500 **/
		int SERVER_EXCEPTION = 500;
	}

	/**
	 * 登录的请求响应.
	 * 模块: 10
	 */
	public interface Login {
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
