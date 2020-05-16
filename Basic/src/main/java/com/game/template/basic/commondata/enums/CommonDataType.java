package com.game.template.basic.commondata.enums;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.commondata.setting.CommonDataSetting;
import com.google.common.base.Preconditions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 12:37
 ***/
public enum  CommonDataType {
	RECHARGE_INFO(1, "累计充值数据", CommonDataSetting.intBuilder().build()),

	;
	private int type;
	private String desc;
	private CommonDataSetting setting;

	CommonDataType(int type, String desc, CommonDataSetting setting) {
		Preconditions.checkNotNull(setting);

		this.type = type;
		this.desc = desc;
		this.setting = setting;
	}

	public int getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	public CommonDataSetting getSetting() {
		return setting;
	}

	private static final CommonDataType [] values = values();
	private static final Map<Integer, CommonDataType> types;
	static {
		types = Stream.of(values).collect(
			Collectors.toMap(CommonDataType::getType, Function.identity())
		);
	}

	public static CommonDataType parse(int type) {
		CommonDataType type0 = types.get(type);
		Preconditions.checkNotNull(type0, "Type %s is null", type);
		return type0;
	}

	public boolean isDailyClean() {
		return setting.isDailyClean();
	}

	public String getInitVal(PlayerActor player){
		return setting.getDefaultVal().get(player);
	}
}
