package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//入庫処理
	@PostMapping("/stocks/inbound/{id}")
	public String inbound(
			@PathVariable("id") Integer itemId,
			@RequestParam("stock") Integer quantity) {
		// 入庫履歴をインスタンス化
		Stock stock = new Stock(itemId, new Timestamp(System.currentTimeMillis()), quantity);
		// 入庫履歴を永続化
		stockRepository.save(stock);
		
		// リクエストパラメータをもとに商品を取得
		Item item = itemRepository.findById(itemId).get();
		// 在庫数を変更
		item.setQuauntity(item.getQuantity() + quantity);
		// 商品を永続化
		itemRepository.save(item);
		
		// 画面遷移
		return "redirect:/stocks/" + itemId;
	}
}
