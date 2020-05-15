package com.game.template.basic.commondata;

import com.game.template.basic.commondata.entity.CommonDataBo;
import com.game.template.basic.commondata.entity.CommonDataDo;
import com.game.template.basic.commondata.enums.CommonDataObj;
import com.game.template.basic.commondata.enums.CommonDataType;
import com.game.template.basic.commondata.enums._CDataType;
import org.qiunet.data.support.CacheDataListSupport;
import org.qiunet.utils.date.DateUtil;

import java.util.Map;

public enum CommonDataService {
	instance;
	private static CacheDataListSupport<Long, Integer, CommonDataDo, CommonDataBo> dataSupport = new CacheDataListSupport<>(CommonDataDo.class, CommonDataBo::new);

	/***
	 * 获得一个 playerId -> CommonDataBo Map对象
	 * @param playerId 获取对象的主键
	 * @return CommonDataBo map对象
	 **/
	private Map<Integer, CommonDataBo> getCommonDataBoMap(Long playerId) {
		return dataSupport.getBoMap(playerId);
	}
	/***
	* 获得一个 type -> CommonDataBo  的bo对象
	* @param playerId 获取对象的主键
	* @param type 获取对象的次主键
	* @return CommonDataBo bo对象
	**/
	private CommonDataBo getCommonDataBo(Long playerId, CommonDataType type, _CDataType cDataType) {
		CommonDataBo commonDataBo = getCommonDataBoMap(playerId).get(type.getType());
		if (commonDataBo == null) {
			String initVal = type.getInitVal();
			if (! cDataType.regexMatch(initVal)) {
				throw new RuntimeException("initVal "+initVal+" not match type "+cDataType+"!");
			}

			CommonDataDo commonDataDo = new CommonDataDo();
			commonDataDo.setUpdateTime(DateUtil.currSeconds());
			commonDataDo.setType(type.getType());
			commonDataDo.setPlayerId(playerId);
			commonDataDo.setValue(initVal);

			commonDataBo = commonDataDo.insert();
		}
		return commonDataBo;
	}
	private Object getCommonData(Long playerId, CommonDataType type, _CDataType cDataType) {
		return getCommonDataBo(playerId, type, cDataType).getObject(cDataType);
	}

	public long getLongVal(long playerId, CommonDataType type) {
		return (long) getCommonData(playerId, type, _CDataType.LONG);
	}

	public int getIntVal(long playerId, CommonDataType type) {
		return (int) getCommonData(playerId, type, _CDataType.INT);
	}

	public String getStrVal(long playerId, CommonDataType type) {
		return (String) getCommonData(playerId, type, _CDataType.STRING);
	}

	public <T extends CommonDataObj> T getCommonObj(long playerId, CommonDataType type) {
		return (T) getCommonData(playerId,type, _CDataType.JSON);
	}

	public void setLongVal(long playerId, CommonDataType type, long val) {
		CommonDataBo commonDataBo = getCommonDataBo(playerId, type, _CDataType.LONG);
		commonDataBo.setVal(val);
		commonDataBo.update();
	}

	public void setIntVal(long playerId, CommonDataType type, int val) {
		CommonDataBo commonDataBo = getCommonDataBo(playerId, type, _CDataType.INT);
		commonDataBo.setVal(val);
		commonDataBo.update();
	}


	public void setStringVal(long playerId, CommonDataType type, String val) {
		CommonDataBo commonDataBo = getCommonDataBo(playerId, type, _CDataType.STRING);
		commonDataBo.setVal(val);
		commonDataBo.update();
	}
}
