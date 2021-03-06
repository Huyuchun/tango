package com.geeklib.tango.config;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.XmlElement;

import com.google.common.base.CaseFormat;

public class CustomMethodNameRule extends PluginAdapter  {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		
		String name = introspectedTable.getFullyQualifiedTableNameAtRuntime();
		name = StringUtils.substringAfter(name, "_");
		name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
		name = "update" + name + "ById";
		method.setName(name);
		introspectedTable.setUpdateByPrimaryKeyStatementId(name);
		return super.clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable);
	}
	
	
	@Override
	public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		
		String name = introspectedTable.getFullyQualifiedTableNameAtRuntime();
		name = StringUtils.substringAfter(name, "_");
		name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
		name = "list" + name;
		method.setName(name);
		introspectedTable.setSelectAllStatementId(name);
		return super.clientSelectAllMethodGenerated(method, interfaze, introspectedTable);
	}
	
	
	@Override
	public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		
		String name = introspectedTable.getFullyQualifiedTableNameAtRuntime();
		name = StringUtils.substringAfter(name, "_");
		name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
		name = "save" + name;
		method.setName(name);
		introspectedTable.setInsertStatementId(name);
		return super.clientInsertMethodGenerated(method, interfaze, introspectedTable);
	}
	
	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		
		String name = introspectedTable.getFullyQualifiedTableNameAtRuntime();
		name = StringUtils.substringAfter(name, "_");
		name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
		name = "get" + name + "ById";
		method.setName(name);
		introspectedTable.setSelectByPrimaryKeyStatementId(name);
		return super.clientSelectByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
	}
	
	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		
		String name = introspectedTable.getFullyQualifiedTableNameAtRuntime();
		name = StringUtils.substringAfter(name, "_");
		name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
		name = "remove" + name + "ById";
		method.setName(name);
		introspectedTable.setDeleteByPrimaryKeyStatementId(name);
		return super.clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
	}
	
}