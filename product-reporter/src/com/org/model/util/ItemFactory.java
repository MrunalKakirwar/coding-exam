package com.org.model.util;

import com.org.model.dao.CollectionBackedItemDao;
import com.org.model.service.ItemServiceImpl;

public class ItemFactory {
	public static Object getInstance(LayerType layerType) {
		switch(layerType) {
		case DAO : 
			return new CollectionBackedItemDao();
		case SERVICE : 
			return new ItemServiceImpl();
		}
		throw new RuntimeException("Unable to create layer instance");
	}
}
