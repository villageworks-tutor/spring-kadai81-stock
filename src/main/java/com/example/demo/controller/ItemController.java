package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	// 商品一覧表示（初期表示）
	@GetMapping("/products")
	public String index() {
		// 画面遷移
		return "itemsView";
	}
}
