package com.org.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.org.exception.ItemNotFoundException;
import com.org.model.beans.Item;
import com.org.model.dao.ItemDao;
import com.org.model.util.ItemFactory;
import com.org.model.util.LayerType;

public class ItemServiceImpl implements ItemService {

	private ItemDao dao;
	public ItemServiceImpl() {
		dao = (ItemDao) ItemFactory.getInstance(LayerType.DAO);
	}
	@Override
	public Item addItems(Item item) {
		return dao.addItem(item);
	}

	@Override
	public List<Item> generateReports(String itemType) throws ItemNotFoundException {
		List<Item> items = null;
		try {
			items = dao.generateReports(itemType);
			// using anonymous class to the sort particular type instead of creating separate class
			Collections.sort(items, new Comparator<Item>() {
				@Override
				public int compare(Item o1, Item o2) {
					return o2.getQuantity() - o1.getQuantity();
				}
			});
		} catch(ItemNotFoundException e) {
			throw new ItemNotFoundException(e.getMessage()+" ITEM "+itemType+" NOT FOUND ");
		}
		if(items == null) {
			throw new ItemNotFoundException("Item not found: "+itemType);
		}
		return fetchTop3ItemsSold(items);
	}
	// fetch top3 items from the selected item
	private List<Item> fetchTop3ItemsSold(List<Item> items) {
		// empty list to add top 3 items
		List<Item> top3Items = new ArrayList<Item>();
		int counter = 0;
		for(Item item : items) {
			top3Items.add(item);
			counter++;
			if(counter == 3)
				break;
		}
		return top3Items;
	}

}
