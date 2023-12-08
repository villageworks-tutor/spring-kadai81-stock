package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Item;
import com.example.demo.entity.Stock;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.StockRepository;

@Controller
public class StockController {
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	StockRepository stockRepository;
	
	// 在庫管理画面表示
	@GetMapping("/stocks/{id}")
	public String index(
			@PathVariable("id") Integer id,
			Model model) {
		// 指定された商品を取得
		Item item = itemRepository.findById(id).get();
		// 取得した商品をスコープに登録
		model.addAttribute("item", item);
		
		// 指定された商品の入出庫履歴を取得
		List<Stock> list = stockRepository.findByItemId(id);
		// 取得した入出庫履歴リストをスコープに登録
		model.addAttribute("stockList", list);
		
		// 画面遷移
		return "stocksView";
	}
}
