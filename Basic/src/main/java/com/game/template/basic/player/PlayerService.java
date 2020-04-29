package com.game.template.basic.player;

import com.game.template.basic.id.enums.GlobalIdType;
import com.game.template.basic.login.entity.LoginBo;
import com.game.template.basic.player.entity.PlayerBo;
import com.game.template.basic.player.entity.PlayerDo;
import org.qiunet.data.support.CacheDataSupport;

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

	/**
	 * 注册一个新的玩家
	 * @param loginBo
	 * @return
	 */
	public PlayerBo register(LoginBo loginBo) {
		long playerId = GlobalIdType.PLAYER.generatorId();
		loginBo.getDo().setPlayerId(playerId);
		loginBo.update();

		PlayerDo playerDo = new PlayerDo(playerId);
		playerDo.setOpenId(loginBo.getDo().getOpenId());
		playerDo.setLevel(1);
		return playerDo.insert();
	}
}
