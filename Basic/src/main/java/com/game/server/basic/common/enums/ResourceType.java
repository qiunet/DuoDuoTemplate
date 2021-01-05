package com.game.server.basic.common.enums;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.cfg.resource.IResourceCfg;
import com.game.server.basic.common.cfg.resource.ResourceDataCfg;
import com.game.server.basic.common.cfg.resource.ResourceEquipCfg;
import com.game.server.basic.common.cfg.resource.ResourceItemCfg;
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
	DATA(0),
	/**
	 * 物品
	 */
	ITEM(1),
	/**
	 * 装备
	 */
	EQUIP(2) ,
	;
	private final int type;

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

	private static final ResourceType [] values = values();

	public static IResourceCfg getCfgById(int resourceId) {
		Preconditions.checkArgument(resourceId > 0);

		if (resourceId < 1000) {
			return dataCfgWrapper.getCfgById(resourceId);
		}else if (resourceId < 1000000) {
			return itemCfgWrapper.getCfgById(resourceId);
		}else {
			return equipCfgWrapper.getCfgById(resourceId);
		}
	}
	public static ResourceType parse(int type) {
		if (type >= 0 && type < values.length) {
			return values[type];
		}
		throw new EnumParseException(type);
	}
}
