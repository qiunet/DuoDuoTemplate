package com.game.server.test.server;

import org.qiunet.flash.handler.netty.client.param.IClientConfig;
import org.qiunet.flash.handler.netty.client.param.WebSocketClientParams;
import org.qiunet.test.server.IServer;

/***
 *
 * @author qiunet
 * 2020-04-25 17:20
 **/
public enum  ServerType implements IServer {
	/**websocket 服*/
	WS_ONLINE(WebSocketClientParams.custom().setAddress("localhost", 8888).setUriIPath("/ws").build()),
	;

	private IClientConfig config;

	ServerType(IClientConfig config) {
		this.config = config;
	}

	@Override
	public String getName() {
		return name();
	}

	@Override
	public IClientConfig getClientConfig() {
		return config;
	}
}
