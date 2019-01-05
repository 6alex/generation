package com.idp.web.shop.entity;
import java.io.Serializable;
import java.util.Date;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 云圣商铺实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2019-01-04 wen
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
public class YShop extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
    private String            id;
	/**创建人员*/
	private String createUser;
	/**创建时间*/
	private Date createDate;
	/**修改人员*/
	private String updateUser;
	/**修改日期*/
	private Date updateDate;
	/**门店名*/
	private String name;
	/**门店详细地址*/
	private String address;
	/**经度*/
	private Double longitude;
	/**纬度*/
	private Double latitude;
	/**门店描叙*/
	private String description;
	
	
	/**
	 *方法: 取得Long
	 *@return: Long  id
	 */
    public String getId() {
		return this.id;
	}

	/**
	 *方法: 设置Long
	 *@param: Long  id
	 */
    public void setId(String id) {
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  创建人员
	 */
	public String getCreateUser(){
		return this.createUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  创建人员
	 */
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  创建时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  修改人员
	 */
	public String getUpdateUser(){
		return this.updateUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  修改人员
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
	 *方法: 取得String
	 *@return: String  门店名
	 */
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置String
	 *@param: String  门店名
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  门店详细地址
	 */
	public String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置String
	 *@param: String  门店详细地址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	 *方法: 取得Double
	 *@return: Double  经度
	 */
	public Double getLongitude(){
		return this.longitude;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  经度
	 */
	public void setLongitude(Double longitude){
		this.longitude = longitude;
	}
	
	/**
	 *方法: 取得Double
	 *@return: Double  纬度
	 */
	public Double getLatitude(){
		return this.latitude;
	}

	/**
	 *方法: 设置Double
	 *@param: Double  纬度
	 */
	public void setLatitude(Double latitude){
		this.latitude = latitude;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  门店描叙
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置String
	 *@param: String  门店描叙
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	
}
