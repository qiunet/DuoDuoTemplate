package com.game.template.creator;

import org.qiunet.project.init.creator.ProjectInitCreator;
import org.qiunet.utils.system.SystemPropertyUtil;

import java.nio.file.Paths;

/***
 *
 *
 * qiunet
 * 2019-08-14 18:05
 ***/
public class Creator {

	public static void main(String[] args) {

		ProjectInitCreator.create("xml", Paths.get(SystemPropertyUtil.getUserDir(), "Basic").toFile());
	}
}
