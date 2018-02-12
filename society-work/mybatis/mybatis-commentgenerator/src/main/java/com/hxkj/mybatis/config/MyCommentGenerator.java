package com.hxkj.mybatis.config;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

public class MyCommentGenerator extends DefaultCommentGenerator {

	/**
	 * 属性的注释
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// 添加字段注释
		StringBuffer sb = new StringBuffer();
		field.addJavaDocLine("/**");
		if (introspectedColumn.getRemarks() != null)
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
		sb.append(" * 表字段 : ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append('.');
		sb.append(introspectedColumn.getActualColumnName());
		field.addJavaDocLine(sb.toString());
		field.addJavaDocLine(" */");
	}

	/**
	 * getter 方法的注释
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
	}

	/**
	 * setter方法的注释
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
	}

	/**
	 * dao 层接口的注释
	 */
	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		
	}

	/**
	 * mapper的方法的注释
	 */
	@Override
	public void addComment(XmlElement xmlElement) {
		//xmlElement.addElement(new TextElement("")); //$NON-NLS-1$
        //xmlElement.addElement(new TextElement("<!-- " + xmlElement.getName() + " -->")); //$NON-NLS-1$
	}

	
}
