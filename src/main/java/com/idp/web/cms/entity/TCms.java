package com.idp.web.cms.entity;
import java.io.Serializable;
import java.util.Date;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 通用cms实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-07 wen
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	wen
 * PG
 *	wen
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class TCms extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**内容ID*/
	private String id;
	/**cms标题*/
	private String title;
	/**内容*/
	private String content;
	/**作者*/
	private String author;
	/**图片集合*/
	private String imgs;
	/**链接*/
	private String links;
	/**附件*/
	private String attachment;
	/**排序*/
	private Integer sort;
	/**栏目ID*/
	private String columnId;
	/**创建人*/
	private String createUser;
	/**创建日期*/
	private Date createDate;
	/**修改人*/
	private String updateUser;
	/**修改日期*/
	private Date updateDate;
	
	/**创建日期开始*/
	private Date createDateStart;
	/**创建日期结束*/
	private Date createDateEnd;
	/**修改日期开始*/
	private Date updateDateStart;
	/**修改日期结束*/
	private Date updateDateEnd;
	
	/**
	 *方法: 取得String
	 *@return: String  内容ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  内容ID
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  cms标题
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置String
	 *@param: String  cms标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  内容
	 */
	public String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置String
	 *@param: String  内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  作者
	 */
	public String getAuthor(){
		return this.author;
	}

	/**
	 *方法: 设置String
	 *@param: String  作者
	 */
	public void setAuthor(String author){
		this.author = author;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  图片集合
	 */
	public String getImgs(){
		return this.imgs;
	}

	/**
	 *方法: 设置String
	 *@param: String  图片集合
	 */
	public void setImgs(String imgs){
		this.imgs = imgs;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  链接
	 */
	public String getLinks(){
		return this.links;
	}

	/**
	 *方法: 设置String
	 *@param: String  链接
	 */
	public void setLinks(String links){
		this.links = links;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  附件
	 */
	public String getAttachment(){
		return this.attachment;
	}

	/**
	 *方法: 设置String
	 *@param: String  附件
	 */
	public void setAttachment(String attachment){
		this.attachment = attachment;
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
	 *@return: String  栏目ID
	 */
	public String getColumnId(){
		return this.columnId;
	}

	/**
	 *方法: 设置String
	 *@param: String  栏目ID
	 */
	public void setColumnId(String columnId){
		this.columnId = columnId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  创建人
	 */
	public String getCreateUser(){
		return this.createUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  创建人
	 */
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  创建日期
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  修改人
	 */
	public String getUpdateUser(){
		return this.updateUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  修改人
	 */
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  修改日期
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  修改日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	
	
	/**
	 *方法: 取得Date
	 *@return: Date  创建日期开始
	 */
	public Date getCreateDateStart(){
		return this.createDateStart;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  创建日期开始
	 */
	public void setCreateDateStart(Date createDateStart){
		this.createDateStart = createDateStart;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  创建日期结束
	 */
	public Date getCreateDateEnd(){
		return this.createDateEnd;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  创建日期结束
	 */
	public void setCreateDateEnd(Date createDateEnd){
		this.createDateEnd = createDateEnd;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  修改日期开始
	 */
	public Date getUpdateDateStart(){
		return this.updateDateStart;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  修改日期开始
	 */
	public void setUpdateDateStart(Date updateDateStart){
		this.updateDateStart = updateDateStart;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  修改日期结束
	 */
	public Date getUpdateDateEnd(){
		return this.updateDateEnd;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  修改日期结束
	 */
	public void setUpdateDateEnd(Date updateDateEnd){
		this.updateDateEnd = updateDateEnd;
	}
	
}
