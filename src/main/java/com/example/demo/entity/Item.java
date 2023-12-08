package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;       // 商品ID
	private String name;      // 商品名
	private Integer price;    // 価格
	private Integer quantity; // 在庫数
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	
}
