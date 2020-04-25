package com.game.template.basic.player;

import org.qiunet.data.support.CacheDataSupport;

import com.game.template.basic.player.entity.PlayerBo;
import com.game.template.basic.player.entity.PlayerDo;

public enum PlayerService {
	instance;
	private static CacheDataSupport<Long, PlayerDo, PlayerBo> dataSupport = new CacheDataSupport<>(PlayerDo.class, PlayerBo::new);
	/***
	* 获得一个 PlayerBo 对象
	* @param playerId 获取对象的主键
	* @return PlayerBo 对象
	*/
	public PlayerBo getPlayerBo(Long playerId) {
		return dataSupport.getBo(playerId);
	}
}
