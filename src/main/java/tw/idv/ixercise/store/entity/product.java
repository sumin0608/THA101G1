package tw.idv.ixercise.store.entity;

import java.io.Serializable;

public class product implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productNo;
	private String productName;
	private String picture;
	private Integer price;
	private Integer amount;
	private String comment;
	
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public product(Integer id, String productNo, String productName, String picture, Integer price, Integer amount, String comment) {
		super();
		this.id = id;
		this.productNo = productNo;
		this.productName = productName;
		this.picture = picture;
		this.price = price;
		this.amount = amount;
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "product{" +
				"id=" + id +
				", productNo='" + productNo + '\'' +
				", productName='" + productName + '\'' +
				", picture='" + picture + '\'' +
				", price=" + price +
				", amount=" + amount +
				", comment='" + comment + '\'' +
				'}';
	}
}
