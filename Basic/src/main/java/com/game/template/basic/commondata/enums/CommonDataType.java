package com.game.template.basic.commondata.enums;

import com.google.common.base.Preconditions;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 12:37
 ***/
public enum  CommonDataType {
	RECHARGE_INFO(1, "累计充值数据", () -> "0"),
	;
	private int type;
	private String desc;
	private boolean dailyClean;
	private Supplier<String> initVal;
	/**如果是json类型. 给出json序列化的类*/
	private Class<? extends CommonDataObj> aClass;

	CommonDataType(int type, String desc, Class<? extends CommonDataObj> aClass, Supplier<String> initVal, boolean dailyClean) {
		this.type = type;
		this.desc = desc;
		this.aClass = aClass;
		this.initVal = initVal;
		this.dailyClean = dailyClean;
	}

	CommonDataType(int type, String desc, Class<? extends CommonDataObj> aClass, Supplier<String> initVal) {
		this(type, desc, aClass, initVal, false);
	}

	CommonDataType(int type, String desc, Supplier<String> initVal, boolean dailyClean) {
		this(type, desc, null, initVal, dailyClean);
	}

	CommonDataType(int type, String desc, Supplier<String> initVal) {
		this(type, desc, null, initVal, false);
	}

	public Class<? extends CommonDataObj> getaClass() {
		return aClass;
	}

	public int getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	public String getInitVal() {
		return initVal.get();
	}

	public boolean isDailyClean() {
		return dailyClean;
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


}
