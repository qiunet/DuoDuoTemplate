package com.game.template.basic.commondata;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.commondata.entity.CommonDataBo;
import com.game.template.basic.commondata.entity.CommonDataDo;
import com.game.template.basic.commondata.enums.CommonDataObj;
import com.game.template.basic.commondata.enums.CommonDataType;
import com.game.template.basic.commondata.enums._CDataType;
import com.google.common.base.Preconditions;
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
	* @param player 获取对象的主键
	* @param type 获取对象的次主键
	* @return CommonDataBo bo对象
	**/
	private CommonDataBo getCommonDataBo(PlayerActor player, CommonDataType type) {
		CommonDataBo commonDataBo = getCommonDataBoMap(player.getPlayerId()).get(type.getType());
		if (commonDataBo == null) {
			String initVal = type.getSetting().getDefaultVal().get(player);
			if (! type.getSetting().getcDataType().regexMatch(initVal)) {
				throw new RuntimeException("initVal "+initVal+" not match type "+type.getSetting().getcDataType()+"!");
			}

			CommonDataDo commonDataDo = new CommonDataDo();
			commonDataDo.setCType(type.getSetting().getcDataType().name());
			commonDataDo.setUpdateTime(DateUtil.currSeconds());
			commonDataDo.setPlayerId(player.getPlayerId());
			commonDataDo.setType(type.getType());
			commonDataDo.setValue(initVal);

			commonDataBo = commonDataDo.insert();
		}

		if (type.isDailyClean()
		&& ! DateUtil.isSameDay(DateUtil.currentTimeMillis(), 1000 * commonDataBo.getDo().getUpdateTime())) {
			commonDataBo.getDo().setValue(type.getInitVal(player));
			commonDataBo.deserialize();
			commonDataBo.update();
		}
		return commonDataBo;
	}
	private Object getCommonData(PlayerActor player, CommonDataType type) {
		return getCommonDataBo(player, type).getObject();
	}

	public long getLongVal(PlayerActor player, CommonDataType type) {
		Preconditions.checkArgument(type.getSetting().getcDataType() == _CDataType.LONG, "Type %s is long", type);
		return (long) getCommonData(player, type);

	}

	public int getIntVal(PlayerActor player, CommonDataType type) {
		Preconditions.checkArgument(type.getSetting().getcDataType() == _CDataType.INT, "Type %s is int", type);
		return (int) getCommonData(player, type);
	}

	public String getStrVal(PlayerActor player, CommonDataType type) {
		Preconditions.checkArgument(type.getSetting().getcDataType() == _CDataType.STRING, "Type %s is String", type);
		return (String) getCommonData(player, type);
	}

	public <T extends CommonDataObj> T getCommonObj(PlayerActor player, CommonDataType type) {
		Preconditions.checkArgument(type.getSetting().getcDataType() == _CDataType.LONG, "Type %s is CommonDataObj", type);
		return (T) getCommonData(player, type);
	}

	public void setLongVal(PlayerActor player, CommonDataType type, long val) {
		Preconditions.checkArgument(type.getSetting().getcDataType() == _CDataType.LONG, "Type %s is long", type);
		CommonDataBo commonDataBo = getCommonDataBo(player, type);
		commonDataBo.setVal(val);
		commonDataBo.update();
	}

	public void setIntVal(PlayerActor player, CommonDataType type, int val) {
		Preconditions.checkArgument(type.getSetting().getcDataType() == _CDataType.INT, "Type %s is int", type);
		CommonDataBo commonDataBo = getCommonDataBo(player, type);
		commonDataBo.setVal(val);
		commonDataBo.update();
	}

	public void setStringVal(PlayerActor player, CommonDataType type, String val) {
		Preconditions.checkArgument(type.getSetting().getcDataType() == _CDataType.STRING, "Type %s is String", type);
		CommonDataBo commonDataBo = getCommonDataBo(player, type);
		commonDataBo.setVal(val);
		commonDataBo.update();
	}
}
