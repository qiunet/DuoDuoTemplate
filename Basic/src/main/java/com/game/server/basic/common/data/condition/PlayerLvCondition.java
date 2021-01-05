package com.game.server.basic.common.data.condition;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.data.condition.base.BaseCondition;
import com.game.server.basic.common.enums.ConditionType;
import org.qiunet.function.condition.ConditionConfig;
import org.qiunet.function.condition.ConditionResult;

/***
 * 人物等级最低要求
 *
 * @author qiunet
 * 2021-01-05 18:31
 */
public class PlayerLvCondition extends BaseCondition {
	private int level;

	@Override
	public ConditionType getType() {
		return ConditionType.PLAYER_MIN_LV;
	}

	@Override
	public ConditionResult verify(PlayerActor playerActor) {
		boolean pass = playerActor.getPlayerBo().getDo().getLevel() >= level;
		return pass ? ConditionResult.SUCCESS : ConditionResult.FAIL;
	}

	@Override
	public void init(ConditionConfig config) {
		this.level = Integer.parseInt(config.getValue());
	}
}
