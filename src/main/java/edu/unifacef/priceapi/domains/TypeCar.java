package edu.unifacef.priceapi.domains;

public enum TypeCar {
	
	COMPACT("compacto"),
	SEDAN("sedan"),
	SUBCOMPACT("subcompacto"),
	LUX("luxo");
	
	private String description;
	
	TypeCar(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
