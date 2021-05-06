package com.example.demo.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Item;
import com.example.demo.repo.ItemRepository;

@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;

	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
		assertEquals(4, items.size());
	}

	@Test
	public void testFindOne() {
		Item item = repository.findByName("Pens");

		assertNotNull(item);
	}

}
