package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
	// 在庫管理画面表示
	@GetMapping("/stocks/{id}")
	public String index(Model model) {
		
		// 画面遷移
		return "stocksView";
	}
}
