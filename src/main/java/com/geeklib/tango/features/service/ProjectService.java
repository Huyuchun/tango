package com.geeklib.tango.features.service;

import java.util.List;

import com.geeklib.tango.features.entity.Project;

public interface ProjectService {

	List<Project> listProject();
	
	/**
	 * 根据ID查询项目
	 * @param id 项目ID
	 * @return 项目
	 */
	Project getProjectById(long id);
}
