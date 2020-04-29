package com.game.template.basic.common.data;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.cfg.resource.IResourceCfg;
import com.game.template.basic.common.cfg.resource.ResourceManager;
import com.game.template.basic.common.deduct.IConditionDeduct;
import com.game.template.basic.common.deduct.IDeduct;
import com.game.template.basic.common.enums.OperationType;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;

/***
 *
 * @author qiunet
 * 2020-04-16 08:31
 **/
public class ConditionData extends ResourceData<ConditionData> implements IConditionDeduct<ConditionData> {
	private ConditionDeduct conditionDeduct = ConditionDeduct.create(this::deductFromPack);

	public ConditionData(){}

	public ConditionData(ConditionData conditionData) {
		this.merge(conditionData);
	}

	/**
	 * 解析
	 * 格式: resourceIdx数量;...
	 * @param string
	 * @return
	 */
	public static ConditionData parse(String string) {
		ConditionData conditionData = new ConditionData();
		conditionData.parse0(string);
		return conditionData;
	}



	/**
	 * 资源是否足够.
	 * @param player
	 * @return
	 */
	public boolean haveEnoughResource(PlayerActor player, OperationType type) {
		Preconditions.checkState(operationType == null);
		//TODO 业务自己判断
		super.operationType = type;
		super.player = player;
		return true;
	}

	/**
	 * 执行 conditionData的扣除逻辑
	 * @param player
	 */
	private void deductFromPack(PlayerActor player) {
		Preconditions.checkNotNull(operationType, "ConditionData need call haveEnoughResource method!");

		for (Map.Entry<Integer, Integer> entry : getResources().entrySet()) {
			IResourceCfg resourceCfg = ResourceManager.getInstance().getResourceCfg(entry.getKey());
			resourceCfg.type().deductFromPack(player, entry.getKey(), entry.getValue(), operationType);
		}
	}

	@Override
	public ConditionData addDeduct(IDeduct deduct) {
		 conditionDeduct.addDeduct(deduct);
		 return this;
	}

	@Override
	public List<IDeduct> getAllDeduct() {
		return conditionDeduct.getAllDeduct();
	}

	@Override
	public boolean isFinished() {
		return conditionDeduct.isFinished();
	}

	@Override
	public void executor(PlayerActor player) throws Exception {
		conditionDeduct.executor(player);
	}

	@Override
	public RewardData newRewardData() {
		return new RewardData(this);
	}

	@Override
	public RewardData newRewardData(RewardData data) {
		return new RewardData(this, data);
	}

	@Override
	public void mergeDeduct(ConditionData conditionDeduct) {
		this.conditionDeduct.mergeDeduct(conditionDeduct.conditionDeduct);
	}
}
