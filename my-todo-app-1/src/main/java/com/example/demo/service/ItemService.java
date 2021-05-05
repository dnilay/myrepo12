package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.repo.ItemRepository;

@Service
public class ItemService {

	private ItemRepository repository;

	@Autowired
	public ItemService(ItemRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Item> calculateTotalValue() {

		List<Item> items = repository.findAll();

		items.stream().forEach((item) -> {
			item.setValue(item.getPrice() * item.getQuantity());
		});

		return items;
	}

	public void insertItem() {

	}

}
