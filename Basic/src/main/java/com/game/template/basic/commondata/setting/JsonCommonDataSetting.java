package com.game.template.basic.commondata.setting;

import com.game.template.basic.commondata.enums.CommonDataObj;
import com.game.template.basic.commondata.enums._CDataType;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:57
 ***/
public final class JsonCommonDataSetting extends CommonDataSetting<JsonCommonDataSetting> {

	private Class<? extends CommonDataObj> clazz;

	 JsonCommonDataSetting() {
		super(_CDataType.JSON, ()->"{}");
	}
}
