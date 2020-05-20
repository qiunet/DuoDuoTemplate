package com.game.server.basic.id.global;

import com.game.server.basic.id.global.entity.ServerInfoBo;
import com.game.server.basic.id.global.entity.ServerInfoDo;
import org.qiunet.data.support.CacheDataSupport;

public enum ServerInfoService {
	instance;
	private static CacheDataSupport<String, ServerInfoDo, ServerInfoBo> dataSupport = new CacheDataSupport<>(ServerInfoDo.class, ServerInfoBo::new);
	/***
	* 获得一个 ServerInfoBo 对象
	* @param type 获取对象的主键
	* @return ServerInfoBo 对象
	*/
	public ServerInfoBo getServerInfoBo(String type) {
		return dataSupport.getBo(type);
	}
}
