package com.game.template.basic.common.data;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.deduct.IConditionDeduct;
import com.game.template.basic.common.deduct.IDeduct;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;

/***
 *
 * @author qiunet
 * 2020-04-28 07:51
 **/
public class ConditionDeduct implements IConditionDeduct<ConditionDeduct> {

	private List<IDeduct> deducts = Lists.newArrayListWithCapacity(2);

	private boolean finished;

	private ConditionDeduct() {
	}

	public static ConditionDeduct create(){
		return new ConditionDeduct();
	}

	public static ConditionDeduct create(IDeduct deduct){
		return create().addDeduct(deduct);
	}

	@Override
	public ConditionDeduct addDeduct(IDeduct deduct) {
		Preconditions.checkNotNull(deduct);

		deducts.add(deduct);
		return this;
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public void executor(PlayerActor player) throws Exception {
		for (IDeduct deduct : deducts) {
			deduct.deduct(player);
		}
		this.finished = true;
	}

	@Override
	public List<IDeduct> getAllDeduct() {
		return deducts;
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
	public void mergeDeduct(ConditionDeduct conditionDeduct) {
		Preconditions.checkState(! conditionDeduct.finished);
		Preconditions.checkState(! finished);

		this.deducts.addAll(conditionDeduct.deducts);
	}
}
