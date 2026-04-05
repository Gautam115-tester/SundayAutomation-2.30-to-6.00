package com.TestNG;

import org.testng.annotations.DataProvider;

public class DataForTesting {
	
	
	@DataProvider(name = "ebay amol ka wishlist")
	public String[] search() {   // row
		String[] arr = {"mobile","sunglasses","shoes","ram 32gb ddr5","mac 3 air","Ac","Projector"};
		return arr;
	}
	
	
	
	@DataProvider(name = "ebay gautam wishlist")
	public String[][] data(){
		
		String[][] arr = new String[4][2];
		
		arr[0][0] = "mobile";
		arr[0][1] = "Mobile for sale | eBay";
		
		arr[1][0] = "5090 Rtx graphic card";
		arr[1][1] = "5090 Rtx Graphic Card for sale | eBay";
		
		arr[2][0] = "Ram 64gb ddr5 6000mhz";
		arr[2][1] = "Ram 64GB DDR5 6000MHz for sale | eBay";
		
		arr[3][0] = "ryzen 7 7900 x3d";
		arr[3][1] = "Ryzen 7 7900x3d for sale | eBay";
		
		return arr;
	}
	
	

}
