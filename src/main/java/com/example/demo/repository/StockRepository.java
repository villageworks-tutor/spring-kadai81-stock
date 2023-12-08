package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

	/**
	 * 商品ごとの入出庫履歴を取得する
	 * SELECT * FROM stocks WHERE item_id = ?
	 */
	List<Stock> findByItemId(Integer id);

}
