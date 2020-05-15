package com.game.template.basic.commondata.setting;

import com.game.template.basic.commondata.enums._CDataType;

import java.util.function.Supplier;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:55
 ***/
public abstract class CommonDataSetting<T extends CommonDataSetting> {
	private Supplier<String> defaultVal;

	private _CDataType cDataType;

	private boolean dailyClean;


	 CommonDataSetting(_CDataType cDataType, Supplier<String> defaultVal) {
		this.cDataType = cDataType;
		this.defaultVal = defaultVal;
	}


	public static JsonCommonDataSetting useJson(){
	 	return new JsonCommonDataSetting();
	}

	public static IntCommonDataSetting useInt(){
	 	return new IntCommonDataSetting();
	}

	public static LongCommonDataSetting useLong(){
	 	return new LongCommonDataSetting();
	}

	public static StringCommonDataSetting useString(){
	 	return new StringCommonDataSetting();
	}

	public T setDailyClean(boolean dailyClean) {
		this.dailyClean = dailyClean;
		return (T) this;
	}

	public T setDefaultVal(Supplier<String> defaultVal) {
		this.defaultVal = defaultVal;
		return (T)this;
	}
}
