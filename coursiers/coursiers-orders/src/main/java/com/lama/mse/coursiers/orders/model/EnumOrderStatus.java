package com.lama.mse.coursiers.orders.model;

public enum EnumOrderStatus {
	
	CREATED("CREATED"), ASSIGNED("ASSIGNED"), DELIVERED("DELIVERED");
	
	private EnumOrderStatus(String title) {
		this.title = title;
	}
	
	private final String title;
	
	public String getTitle(){
		return title;
	}
	
	public static EnumOrderStatus parseCategory(String category){
		if(category.contains(CREATED.getTitle())){
			return CREATED;
		} else if(category.contains(ASSIGNED.getTitle())){
			return ASSIGNED;
		} else if(category.contains(DELIVERED.getTitle())){
			return DELIVERED;
		}
		
		return EnumOrderStatus.CREATED;
	}
	
}
