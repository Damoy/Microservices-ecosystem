package com.lama.mse.restaurants.consultation.model;

public enum FoodCategory {

	ALL("all"), JUNK("junk"), ASIAN("asian"), ITALIAN("italian");
	
	private FoodCategory(String title) {
		this.title = title;
	}
	
	private final String title;
	
	public String getTitle(){
		return title;
	}
	
	public static FoodCategory parseCategory(String category){
		if(category.contains(ALL.getTitle())){
			return ALL;
		} else if(category.contains(JUNK.getTitle())){
			return JUNK;
		} else if(category.contains(ASIAN.getTitle())){
			return ASIAN;
		} else if(category.contains(ITALIAN.getTitle())){
			return ITALIAN;
		}
		
		return ALL;
	}
	
}
