package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;          // 入出庫ID
	@Column(name = "item_id")
	private Integer itemId;      // 商品ID
	@Column(name = "checked_at")
	private Timestamp checkedAt; // 入出庫日時
	private Integer quantity;    // 数量
	
	public Integer getId() {
		return id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public Timestamp getCheckedAt() {
		return checkedAt;
	}
	public Integer getQuantity() {
		return quantity;
	}
	
}
