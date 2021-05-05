package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	private ItemService service;
	@Autowired
	public ItemController(ItemService service) {
		super();
		this.service = service;
	}

	@GetMapping("/")
	public List<Item> retrieveAllItems() {
		return service.calculateTotalValue();
	}
	/*
	 * @GetMapping("/") public ResponseEntity<?> getStatus() { return
	 * ResponseEntity.ok("hello world>.!"); }
	 */

}
