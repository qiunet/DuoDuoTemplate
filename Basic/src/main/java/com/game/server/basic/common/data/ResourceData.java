package com.game.server.basic.common.data;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.contants.CfgConstant;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.logger.GameLogger;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.qiunet.utils.string.StringUtil;

import java.util.Collections;
import java.util.Map;
import java.util.StringJoiner;

/***
 *
 * @author qiunet
 * 2020-04-15 21:16
 **/
abstract class ResourceData<Data extends ResourceData> {

	protected Map<Integer, Integer> resources = Maps.newHashMap();
	/**
	 * 是否只读. cfg的都是只读
	 */
	protected boolean readOnly;

	/**
	 * 是否已经走完判断流程
	 * 走完流程 不为null
	 */
	protected PlayerActor player;
	protected OperationType operationType;

	/**
	 * 返回resources
	 * @return
	 */
	public Map<Integer, Integer> getResources() {
		return resources;
	}
	/***
	 * 是否空
	 * @return
	 */
	public boolean isEmpty(){
		return resources.isEmpty();
	}
	/**
	 * 获得某个物品的数量
	 * @param resourceId
	 * @return
	 */
	public Integer getNum(int resourceId) {
		return resources.getOrDefault(resourceId, 0);
	}

	public void addResource(int resourceId, int num) {
		Preconditions.checkState(operationType == null, "It it all checked , Can not add again!");
		Preconditions.checkArgument(num > 0, "num %s must grant than 0", num);
		Preconditions.checkState(! readOnly, "It is a readOnly data");

		this.resources.merge(resourceId, num, Integer::sum);
	}

	public void merge(Data data) {
		Preconditions.checkState(operationType == null, "It it all checked , Can not add again!");
		Preconditions.checkState(! readOnly, "It is a readOnly data");

		Map<Integer, Integer> resources = data.resources;
		resources.forEach((key, val) -> this.resources.merge(key, val, Integer::sum));
	}

	public int getM1(){
		return this.resources.getOrDefault(CfgConstant.M1_RESOURCE_ID, 0);
	}

	public int getM2(){
		return this.resources.getOrDefault(CfgConstant.M2_RESOURCE_ID, 0);
	}

	/**
	 * 检查物品价值和有效性
	 * 因为配置加载过程中,原始数据并没有加载成功.
	 * 所以需要在所有配置加载完后. 再进行检查.
	 */
	public void _checkResourceWorthAndValid(){
		//TODO 配置加载后. 检查物品的价值. 如果过高. 需要抛出异常.
		GameLogger.COMM_LOGGER.info("=======called==========");
	}

	void parse0(String string) {
		if (StringUtil.isEmpty(string)) return;

		String[] strings = StringUtil.split(string, ";");
		for (String str : strings) {
			if (StringUtil.isEmpty(str)) continue;

			Integer[] ints = StringUtil.conversion(str, "x", Integer.class);
			this.addResource(ints[0], ints[1]);
		}
		this.resources = Collections.unmodifiableMap(this.resources);
		this.readOnly = true;
	}

	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner(";");
		for (Map.Entry<Integer, Integer> entry : this.resources.entrySet()) {
			stringJoiner.add(entry.getKey() + "x"+ entry.getValue());
		}
		return stringJoiner.toString();
	}
}
