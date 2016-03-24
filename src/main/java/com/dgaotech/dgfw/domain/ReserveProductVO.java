package com.dgaotech.dgfw.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author xiaxf
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReserveProductVO {
	//商品编码
	private String productCode;
	//商品名称
	private String productName;
	//商品类型
	private String productType;
	//图片名称
	private String imgName;
	//品牌
	private String brand;
	//商品单位
	private String unit;
	//商品单价
	private String price;
	
	private List<ReserveProductVO> reserveProductList;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<ReserveProductVO> getReserveProductList() {
		return reserveProductList;
	}

	public void setReserveProductList(List<ReserveProductVO> reserveProductList) {
		this.reserveProductList = reserveProductList;
	}

	
}
