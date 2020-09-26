package com.org.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.org.exception.ItemNotFoundException;
import com.org.model.beans.Item;
import com.org.model.service.ItemService;
import com.org.model.util.ItemFactory;
import com.org.model.util.ItemType;
import com.org.model.util.LayerType;

public class ViewController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ItemService service = (ItemService)ItemFactory.getInstance(LayerType.SERVICE);
		String option = null;
		do {
			System.out.println("Fetch Reports of: "+Arrays.toString(ItemType.values()));
			System.out.print("Enter any one of the above item or ");
			System.out.println("Enter 2 to exit");
			option = scanner.next();
			if(option.equals("2")) {
				option = null;
			}
			else {
				try {
					List<Item> items = service.generateReports(option);
					for(Item item : items) {
						System.out.println(item);
					}
				} catch (ItemNotFoundException e) {
					System.err.println(e.getMessage());
					System.out.println("Enter only the valid item named below");
					main(args);
				}
			}
			
		} while(option != null);
		scanner.close();
	}

}
