package com.game.server.basic.common.enums;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.cfg.resource.IResourceCfg;
import com.game.server.basic.common.cfg.resource.ResourceDataCfg;
import com.game.server.basic.common.cfg.resource.ResourceEquipCfg;
import com.game.server.basic.common.cfg.resource.ResourceItemCfg;
import com.game.server.basic.common.data.result.IRewardResult;
import com.game.server.basic.equip.EquipService;
import com.game.server.basic.item.ItemService;
import com.google.common.base.Preconditions;
import org.qiunet.cfg.annotation.CfgWrapperAutoWired;
import org.qiunet.cfg.wrapper.ISimpleMapCfgWrapper;
import org.qiunet.utils.exceptions.EnumParseException;

import java.util.List;

/***
 * 资源类型
 * @author qiunet
 * 2020-04-25 09:50
 **/
public enum ResourceType {
	/**
	 * 数据
	 * 钱 经验 等等
	 */
	DATA(0) {
		@Override
		public IResourceCfg getResourceCfg(int resourceId) {
			return dataCfgWrapper.getCfgById(resourceId);
		}

		@Override
		public List<IRewardResult> addToPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
			DataResourceType.parse(resourceId).addResource(player, operationType, num);
			return null;
		}

		@Override
		public void deductFromPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
			DataResourceType.parse(resourceId).deductResource(player, operationType, num);
		}
	},
	/**
	 * 物品
	 */
	ITEM(1) {
		@Override
		public IResourceCfg getResourceCfg(int resourceId) {
			return itemCfgWrapper.getCfgById(resourceId);
		}

		@Override
		public List<IRewardResult> addToPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
			return ItemService.instance.addToPack(player, resourceId, num, operationType);
		}

		@Override
		public void deductFromPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
			ItemService.instance.deductFromPack(player, resourceId, num, operationType);
		}
	},
	/**
	 * 装备
	 */
	EQUIP(2) {
		@Override
		public IResourceCfg getResourceCfg(int resourceId) {
			return equipCfgWrapper.getCfgById(resourceId);
		}

		@Override
		public List<IRewardResult> addToPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
			return EquipService.instance.addToPack(player, resourceId, num, operationType);
		}

		@Override
		public void deductFromPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
			EquipService.instance.deductFromPack(player, resourceId, num, operationType);
		}
	},
	;
	private int type;

	ResourceType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	@CfgWrapperAutoWired
	private static ISimpleMapCfgWrapper<Integer, ResourceDataCfg> dataCfgWrapper;
	@CfgWrapperAutoWired
	private static ISimpleMapCfgWrapper<Integer, ResourceItemCfg> itemCfgWrapper;
	@CfgWrapperAutoWired
	private static ISimpleMapCfgWrapper<Integer, ResourceEquipCfg> equipCfgWrapper;

	public abstract IResourceCfg getResourceCfg(int resourceId);

	private static final ResourceType [] values = values();

	public static ResourceType parseByResourceId(int resourceId) {
		Preconditions.checkArgument(resourceId > 0);

		if (resourceId < 1000) {
			return DATA;
		}else if (resourceId < 1000000) {
			return ITEM;
		}else {
			return EQUIP;
		}
	}
	public static ResourceType parse(int type) {
		if (type >= 0 && type < values.length) {
			return values[type];
		}
		throw new EnumParseException(type);
	}

	public abstract List<IRewardResult> addToPack(PlayerActor player, int resourceId, int num, OperationType operationType);

	public abstract void deductFromPack(PlayerActor player, int resourceId, int num, OperationType operationType);
}
