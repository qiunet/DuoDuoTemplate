package com.game.server.basic.id.enums;

import com.game.server.basic.common.ex.InvalidEnumException;
import com.game.server.basic.id.person.IdBuilderService;

/***
 * 管理id自增的一个类
 *
 * @author qiunet
 * 2020-04-15 21:18
 **/
public enum IDType {
	/**
	 * 不限定类型.
	 */
	ANY(0),
	/***
	 * 装备
	 */
	EQUIP(1),
	;

	private int type;
	IDType(int type) {
		this.type = type;
	}

	public int generatorId(long playerId){
		return IdBuilderService.instance.getIdBuilderBo(playerId, getType());
	}

	public int getType() {
		return type;
	}

	private static final IDType [] values = values();

	public static IDType parse(int val) {
		if (val < 0 || val >= values.length) {
			throw new InvalidEnumException("IDType val: " + val);
		}
		return values[val];
	}
}
