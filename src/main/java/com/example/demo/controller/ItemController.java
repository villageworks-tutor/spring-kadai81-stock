package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	// 商品一覧表示（初期表示）
	@GetMapping("/products")
	public String index(Model model) {
		// すべての商品を取得
		List<Item> list = itemRepository.findAll();
		// 取得した商品リストをスコープに登録
		model.addAttribute("itemList", list);
		// 画面遷移
		return "itemsView";
	}
}
