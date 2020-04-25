package com.game.template.basic.common.contants;

/***
 * 协议id
 *
 * 请求id       = 模块ID * 1000 + 1 起自增
 * 响应ID       = 模块ID * 请求ID * 10000 起自增
 * 无请求的响应ID = 模块ID * 1000 * 10000 起自增
 *
 * @author qiunet
 * 2020-04-25 15:16
 **/
public class ProtocolId {
	/***
	 * 系统自留
	 */
	public interface System {
		/** 404 */
		int HANDLER_NOT_FIND = 404;
		/** 500 **/
		int SERVER_EXCEPTION = 500;
	}

	/**
	 * 登录的请求响应.
	 * 模块: 1
	 */
	public interface Login {
		/**请求登录*/
		int REQ_LOGIN = 1001;
		/***响应登录*/
		int RESP_LOGIN = 10010000;
	}

	/***
	 * 玩家的请求响应
	 * 模块ID: 2
	 */
	public interface Player {

	}


	/**
	 * 背包的请求响应
	 * 模块ID: 3
	 */
	public interface Pack {

	}

	/**
	 * 任务的请求响应
	 * 模块ID: 4
	 */
	public interface Task {

	}

	/**
	 * 商城的请求响应
	 * 模块ID: 5
	 */
	public interface Shop {

	}
}
