package model.bean;

import java.util.UUID;

import model.bean.enums.BoardingHouseType;

public class BoardingHouse {
	private UUID id;

    private String name;

    private String address;

    private BoardingHouseType type;

    private Double electricityUnitPrice;

    private Double waterUnitPrice;
    
    
}
