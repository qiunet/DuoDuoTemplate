package com.game.server.basic.common.enums;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.contants.CfgConstant;
import com.game.server.basic.common.log.CommonDataResourceLogEvent;
import com.game.server.basic.common.log.M1LogEvent;
import com.game.server.basic.common.log.M2LogEvent;
import com.google.common.base.Preconditions;
import org.qiunet.utils.exceptions.EnumParseException;

/***
 * 数据类型资源的枚举
 * @author qiunet
 * 2020-04-25 09:58
 **/
public enum  DataResourceType {
	/**普通金币**/
	M1(CfgConstant.M1_RESOURCE_ID) {
		@Override
		public void addResource(PlayerActor player, OperationType operationType, int num) {
			Preconditions.checkArgument(num > 0);
			player.getPlayerBo().getDo().setM1(getResourceNum(player) + num);
			new M1LogEvent(player, operationType, ResOperationType.ADD, num, getResourceNum(player)).send();
		}

		@Override
		public void deductResource(PlayerActor player, OperationType operationType, int num) {
			Preconditions.checkArgument(num > 0);
			Preconditions.checkArgument(getResourceNum(player) > num);

			player.getPlayerBo().getDo().setM1(getResourceNum(player) - num);
			new M1LogEvent(player, operationType, ResOperationType.DEDUCT, num, getResourceNum(player)).send();
		}

		@Override
		public long getResourceNum(PlayerActor player) {
			return player.getPlayerBo().getDo().getM1();
		}
	},

	/**人民币代币**/
	M2(CfgConstant.M2_RESOURCE_ID) {
		@Override
		public void addResource(PlayerActor player, OperationType operationType, int num) {
			Preconditions.checkArgument(num > 0);
			player.getPlayerBo().getDo().setM2(getResourceNum(player) + num);
			new M2LogEvent(player, operationType, ResOperationType.ADD, num, getResourceNum(player)).send();
		}

		@Override
		public void deductResource(PlayerActor player, OperationType operationType, int num) {
			Preconditions.checkArgument(num > 0);
			Preconditions.checkArgument(getResourceNum(player) > num);

			player.getPlayerBo().getDo().setM2(getResourceNum(player) - num);
			new M2LogEvent(player, operationType, ResOperationType.DEDUCT, num, getResourceNum(player)).send();
		}

		@Override
		public long getResourceNum(PlayerActor player) {
			return player.getPlayerBo().getDo().getM2();
		}
	},

	/**人民币代币**/
	EXP(3) {
		@Override
		public void addResource(PlayerActor player, OperationType operationType, int num) {
			Preconditions.checkArgument(num > 0);
			player.getPlayerBo().getDo().setExp(getResourceNum(player) + num);

			new CommonDataResourceLogEvent(player, operationType, this, ResOperationType.ADD, num, player.getPlayerBo().getDo().getExp()).send();
		}

		@Override
		public void deductResource(PlayerActor player, OperationType operationType, int num) {
			// do nothing
			// 不会减经验
		}

		@Override
		public long getResourceNum(PlayerActor player) {
			return player.getPlayerBo().getDo().getExp();
		}
	},
	;

	private int resourceId;
	DataResourceType(int resourceId) {
		this.resourceId = resourceId;
	}

	private static final DataResourceType [] values = values();

	public static DataResourceType parse(int resourceId) {
		for (DataResourceType value : values) {
			if (value.resourceId == resourceId) {
				return value;
			}
		}
		throw new EnumParseException(resourceId);
	}

	public int getResourceId() {
		return resourceId;
	}

	/**
	 * 增加资源
	 * @param num
	 */
	public abstract void addResource(PlayerActor player, OperationType operationType, int num);

	/**
	 * 扣减资源
	 * @param num
	 */
	public abstract void deductResource(PlayerActor player, OperationType operationType, int num);

	/**
	 * 获得资源数
	 * @return
	 */
	public abstract long getResourceNum(PlayerActor player);
}
