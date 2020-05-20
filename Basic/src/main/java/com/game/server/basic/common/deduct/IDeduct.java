package com.game.server.basic.common.deduct;

import com.game.server.basic.common.actor.PlayerActor;

/***
 * 扣除代码接口
 * @author qiunet
 * 2020-04-28 07:45
 **/
public interface IDeduct {
	/**
	 *
	 * @throws Exception
	 */
	void deduct(PlayerActor player) throws Exception;
}
