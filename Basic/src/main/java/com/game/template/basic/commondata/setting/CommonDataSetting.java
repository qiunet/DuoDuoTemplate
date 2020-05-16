package com.game.template.basic.commondata.setting;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.commondata.enums.CommonDataObj;
import com.game.template.basic.commondata.enums._CDataType;
import org.qiunet.utils.common.functional.DSupplier1;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:55
 ***/
public final class CommonDataSetting {

	Class<? extends CommonDataObj> clazz;
	DSupplier1<PlayerActor, String> defaultVal;
	_CDataType cDataType;
	boolean dailyClean;

	CommonDataSetting(DSupplier1<PlayerActor, String> defaultVal, _CDataType cDataType, boolean dailyClean) {
		this.defaultVal = defaultVal;
		this.cDataType = cDataType;
		this.dailyClean = dailyClean;
	}

	public static JsonCommonDataSettingBuilder jsonBuilder(Class<? extends CommonDataObj> clazz){
	 	return new JsonCommonDataSettingBuilder(clazz);
	}

	public static IntCommonDataSettingBuilder intBuilder(){
	 	return new IntCommonDataSettingBuilder();
	}

	public static LongCommonDataSettingBuilder longBuilder(){
	 	return new LongCommonDataSettingBuilder();
	}

	public static StringCommonDataSettingBuilder strBuilder(){
	 	return new StringCommonDataSettingBuilder();
	}

	public Class<? extends CommonDataObj> getClazz() {
		return clazz;
	}

	public DSupplier1<PlayerActor, String> getDefaultVal() {
		return defaultVal;
	}

	public _CDataType getcDataType() {
		return cDataType;
	}

	public boolean isDailyClean() {
		return dailyClean;
	}
}
