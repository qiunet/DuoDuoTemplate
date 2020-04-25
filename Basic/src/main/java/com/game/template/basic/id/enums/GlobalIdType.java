package com.game.template.basic.id.enums;

import com.game.template.basic.common.ex.InvalidEnumException;
import com.game.template.basic.id.global.GlobalIdBuilderService;

/***
 *
 * @author qiunet
 * 2020-04-17 08:21
 **/
public enum  GlobalIdType {
	/** 玩家ID */
	PLAYER(1),
	;
	private int type;
	GlobalIdType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public int generatorId(){
		return GlobalIdBuilderService.instance.getGlobalIdBuilderBo(getType());
	}

	private static final GlobalIdType [] values = values();

	public static GlobalIdType parse(int val) {
		if (val < 0 || val >= values.length) {
			throw new InvalidEnumException("GlobalIdType val: " + val);
		}
		return values[val];
	}
}
