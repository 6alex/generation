package com.idp.web.table.entity;
import java.io.Serializable;
import java.util.List;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 自动建表实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-04 wencun
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	wencun
 * PG
 *	wencun
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class GTable extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**字段名称*/
	private String name;
	/**数据类型编码*/
	private String code;
	/**默认值*/
	private String defaultValue;
	/**是否为空  1空，0不为空*/
	private String isNull;
	/**注释*/
	private String comment;
	/**分组id*/
	private String groupId;
	/**排序*/
	private Integer sort;
	
	/**字段名称开始*/
	private String nameStart;
	/**字段名称结束*/
	private String nameEnd;
	/**数据类型编码开始*/
	private String codeStart;
	/**数据类型编码结束*/
	private String codeEnd;
	/**子类型集合*/
	private List<GTable> children;
	
	/**
	 *方法: 取得String
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  字段名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置String
	 *@param: String  字段名称
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  数据类型编码
	 */
	public String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置String
	 *@param: String  数据类型编码
	 */
	public void setCode(String code){
		this.code = code;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  默认值
	 */
	public String getDefaultValue(){
		return this.defaultValue;
	}

	/**
	 *方法: 设置String
	 *@param: String  默认值
	 */
	public void setDefaultValue(String defaultValue){
		this.defaultValue = defaultValue;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  是否为空  1空，0不为空
	 */
	public String getIsNull(){
		return this.isNull;
	}

	/**
	 *方法: 设置String
	 *@param: String  是否为空  1空，0不为空
	 */
	public void setIsNull(String isNull){
		this.isNull = isNull;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  注释
	 */
	public String getComment(){
		return this.comment;
	}

	/**
	 *方法: 设置String
	 *@param: String  注释
	 */
	public void setComment(String comment){
		this.comment = comment;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  分组id
	 */
	public String getGroupId(){
		return this.groupId;
	}

	/**
	 *方法: 设置String
	 *@param: String  分组id
	 */
	public void setGroupId(String groupId){
		this.groupId = groupId;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  排序
	 */
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  排序
	 */
	public void setSort(Integer sort){
		this.sort = sort;
	}
	
	
	/**
	 *方法: 取得String
	 *@return: String  字段名称开始
	 */
	public String getNameStart(){
		return this.nameStart;
	}

	/**
	 *方法: 设置String
	 *@param: String  字段名称开始
	 */
	public void setNameStart(String nameStart){
		this.nameStart = nameStart;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  字段名称结束
	 */
	public String getNameEnd(){
		return this.nameEnd;
	}

	/**
	 *方法: 设置String
	 *@param: String  字段名称结束
	 */
	public void setNameEnd(String nameEnd){
		this.nameEnd = nameEnd;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  数据类型编码开始
	 */
	public String getCodeStart(){
		return this.codeStart;
	}

	/**
	 *方法: 设置String
	 *@param: String  数据类型编码开始
	 */
	public void setCodeStart(String codeStart){
		this.codeStart = codeStart;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  数据类型编码结束
	 */
	public String getCodeEnd(){
		return this.codeEnd;
	}

	/**
	 *方法: 设置String
	 *@param: String  数据类型编码结束
	 */
	public void setCodeEnd(String codeEnd){
		this.codeEnd = codeEnd;
	}

	public List<GTable> getChildren() {
		return children;
	}

	public void setChildren(List<GTable> children) {
		this.children = children;
	}
	
	
	
}
