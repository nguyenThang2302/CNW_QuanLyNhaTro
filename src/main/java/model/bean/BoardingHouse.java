package model.bean;

import java.util.UUID;


public class BoardingHouse {
	private UUID id;

    private String name;

    private String address;

    private Double electricityUnitPrice;

    private Double waterUnitPrice;
    
    private User user;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getElectricityUnitPrice() {
		return electricityUnitPrice;
	}

	public void setElectricityUnitPrice(Double electricityUnitPrice) {
		this.electricityUnitPrice = electricityUnitPrice;
	}

	public Double getWaterUnitPrice() {
		return waterUnitPrice;
	}

	public void setWaterUnitPrice(Double waterUnitPrice) {
		this.waterUnitPrice = waterUnitPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    
}
