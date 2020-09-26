package com.org.model.service;

import java.util.List;

import com.org.exception.ItemNotFoundException;
import com.org.model.beans.Item;

public interface ItemService {
	public Item addItems(Item item);
	public List<Item> generateReports(String itemType)throws ItemNotFoundException;
}
