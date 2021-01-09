package com.game.server.basic.gm;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.contants.GameStatus;
import org.qiunet.flash.handler.context.status.IGameStatus;
import org.qiunet.function.gm.GmCommand;
import org.qiunet.function.gm.GmParamDesc;

/***
 * 增加玩家经验的gm命令
 *
 * @author qiunet
 * 2021-01-09 17:37
 */
public class GmAddPlayerLvCommand {

	@GmCommand(type = GmCommandType.ADD_PLAYER_LV, commandName = "增加人物等级")
	public IGameStatus addPlayerLv(PlayerActor player, @GmParamDesc("增加等级") int addLv) {
		return GameStatus.SUCCESS;
	}
}
