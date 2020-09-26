package com.org.model.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.org.exception.ItemNotFoundException;
import com.org.model.beans.Apparels;
import com.org.model.beans.Electronics;
import com.org.model.beans.Foods;
import com.org.model.beans.Item;
import com.org.model.util.ItemType;

public class CollectionBackedItemDao implements ItemDao {

	private List<Item> items;
	
	public CollectionBackedItemDao() {
		items = Arrays.asList(new Item[] {
				new Apparels(111, "T-Shirt", 170, Apparels.Size.MEDIUM),
				new Apparels(222, "T-Shirt", 160, Apparels.Size.SMALL),
				new Apparels(333, "T-Shirt", 150, Apparels.Size.LARGE),
				new Apparels(444, "Shirt", 200, Apparels.Size.MEDIUM),
				new Apparels(555, "Shirt", 250, Apparels.Size.SMALL),
				new Apparels(666, "Shirt", 300, Apparels.Size.LARGE),
				new Apparels(777, "Sweater", 120, Apparels.Size.MEDIUM),
				new Apparels(888, "Sweater", 80, Apparels.Size.SMALL),
				new Apparels(999, "Sweater", 900, Apparels.Size.LARGE),

				new Foods(11, "Milk", 5000, Foods.Vegetarian.YES),
				new Foods(12, "Curd", 2500, Foods.Vegetarian.YES),
				new Foods(13, "Cake", 10000, Foods.Vegetarian.YES),
				new Foods(14, "Butter", 2000, Foods.Vegetarian.YES),
				new Foods(15, "Bread", 8000, Foods.Vegetarian.YES),

				new Electronics(21, "TV", 600, 5),
				new Electronics(22, "Mobile", 900, 2),
				new Electronics(23, "Watch", 300, 15),
				new Electronics(24, "Laptop", 1600, 8),
				new Electronics(25, "Mixer", 100, 3),
				new Electronics(26, "Drier", 250, 4),
		});
	}
	
	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		this.items.add(item);
		return item;
	}

	@Override
	public List<Item> generateReports(String itemType) throws ItemNotFoundException {
		ItemType type = null;
		List<Item> items = null;
		
		try {
			type = ItemType.valueOf(itemType.toUpperCase());
			switch(type) {
			case APPARELS : 
				items = fetchParticularItem(this.items, ItemType.APPARELS);
				break;
			case ELECTRONICS: 
				items = fetchParticularItem(this.items, ItemType.ELECTRONICS);
				break;
			case FOODS:
				items = fetchParticularItem(this.items, ItemType.FOODS);
				break;
			}
			
		} catch(Exception e) {
			throw new ItemNotFoundException(e);
		}
		return items;
	}
	private List<Item> fetchParticularItem(List<Item> items, ItemType itemType) {
		
		// lists to get different type of items
		List<Item> apparels = new ArrayList<Item>();
		List<Item> electronics = new ArrayList<Item>();
		List<Item> foods = new ArrayList<Item>();
		for(Item item : items) {
			if(item instanceof Apparels) {
				apparels.add(item);
				
			}
			else if(item instanceof Foods) {
				foods.add(item);
				
			}	
			else if(item instanceof Electronics) {
				electronics.add(item);
				
			}
		}
		if(itemType == ItemType.ELECTRONICS)
			return electronics;
		if(itemType == ItemType.FOODS)
			return foods;
		if(itemType == ItemType.APPARELS)
			return apparels;
		return null;
	}
}
