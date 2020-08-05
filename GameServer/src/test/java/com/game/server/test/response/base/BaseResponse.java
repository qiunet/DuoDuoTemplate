package com.game.server.test.response.base;

import com.game.server.test.robot.Robot;
import com.google.protobuf.GeneratedMessageV3;
import org.qiunet.test.response.ProtobufResponse;

/***
 *
 * @author qiunet
 * 2020-04-25 18:48
 **/
public abstract class BaseResponse<Resp extends GeneratedMessageV3> extends ProtobufResponse<Resp, Robot> {

}
