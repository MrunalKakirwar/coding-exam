package com.org.model.dao;

import java.util.List;

import com.org.exception.ItemNotFoundException;
import com.org.model.beans.Item;

public interface ItemDao {
	public Item addItem(Item item);
	
	List<Item> generateReports(String itemType) throws ItemNotFoundException;
}
