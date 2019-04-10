package com.kitri.jdbc;

import java.util.Date;

public class FoodDto {
	//��������
	private String foodId;				//����id
	private String foodName; 		//�����̸�
	private int categoryId;				//ī�װ�id
	private String categoryName;	//ī�װ��̸�
	private int price;						//����
	private int point;					//����Ʈ
	private String description;		//����
	private String imageAddress;	//�̹����ּ�
	
	//������
	private String managerId;		//����ѸŴ���
	private Date createDate;		//�����
	private char enable;				//Ȱ��ȭ����
		
	public FoodDto() {
	}
	public FoodDto(String foodId, String foodName, int categoryId, String categoryName, int price,
			String imageAddress) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.price = price;
		this.imageAddress = imageAddress;
	}

	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public char getEnable() {
		return enable;
	}
	public void setEnable(char enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "FoodDto [foodId=" + foodId + ", foodName=" + foodName + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", price=" + price + ", point=" + point + ", description=" + description
				+ ", imageAddress=" + imageAddress + ", managerId=" + managerId + ", createDate=" + createDate
				+ ", enable=" + enable + "]";
	}
}
