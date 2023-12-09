package model.bean;

import java.util.Date;
import java.util.UUID;

import model.bean.enums.InvoiceStatus;

public class Invoice {
	private UUID id;
	private Date date;
	private Room room;
	private Double previousElectricMeter;
	private Double currentElectricMeter;
	private Double electricityCost;
	private Double previousWaterMeter;
	private Double currentWaterMeter;
	private Double waterCost;
	private Double additionalCost;
	private Double totalCost;
	private Double roomCost;

	
	private InvoiceStatus status;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Double getPreviousElectricMeter() {
		return previousElectricMeter;
	}

	public void setPreviousElectricMeter(Double previousElectricMeter) {
		this.previousElectricMeter = previousElectricMeter;
	}

	public Double getCurrentElectricMeter() {
		return currentElectricMeter;
	}

	public void setCurrentElectricMeter(Double currentElectricMeter) {
		this.currentElectricMeter = currentElectricMeter;
	}

	public Double getElectricityCost() {
		return electricityCost;
	}

	public void setElectricityCost(Double electricityCost) {
		this.electricityCost = electricityCost;
	}

	public Double getPreviousWaterMeter() {
		return previousWaterMeter;
	}

	public void setPreviousWaterMeter(Double previousWaterMeter) {
		this.previousWaterMeter = previousWaterMeter;
	}

	public Double getCurrentWaterMeter() {
		return currentWaterMeter;
	}

	public void setCurrentWaterMeter(Double currentWaterMeter) {
		this.currentWaterMeter = currentWaterMeter;
	}

	public Double getWaterCost() {
		return waterCost;
	}

	public void setWaterCost(Double waterCost) {
		this.waterCost = waterCost;
	}

	public Double getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(Double additionalCost) {
		this.additionalCost = additionalCost;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(Double roomCost) {
		this.roomCost = roomCost;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	public Invoice(UUID id, Date date, Room room, Double previousElectricMeter, Double currentElectricMeter,
			Double electricityCost, Double previousWaterMeter, Double currentWaterMeter, Double waterCost,
			Double additionalCost, Double totalCost, Double roomCost, InvoiceStatus status) {
		super();
		this.id = id;
		this.date = date;
		this.room = room;
		this.previousElectricMeter = previousElectricMeter;
		this.currentElectricMeter = currentElectricMeter;
		this.electricityCost = electricityCost;
		this.previousWaterMeter = previousWaterMeter;
		this.currentWaterMeter = currentWaterMeter;
		this.waterCost = waterCost;
		this.additionalCost = additionalCost;
		this.totalCost = totalCost;
		this.roomCost = roomCost;
		this.status = status;
		
	}

	public Invoice() {
		super();
	}

}
