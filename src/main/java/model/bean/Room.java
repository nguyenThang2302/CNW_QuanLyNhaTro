package model.bean;

public class Room {
	private String id;
	private String name;
	private String boarding_house_id;
	private int number_of_people_in_room;
	private String status;
	private int current_electric_meter;
	private int current_water_meter;
	private double room_cost;
	
	public Room(String id, String name, String boarding_house_id, int number_of_people_in_room, String status,
			int current_electric_meter, int current_water_meter, double room_cost) {
		super();
		this.id = id;
		this.name = name;
		this.boarding_house_id = boarding_house_id;
		this.number_of_people_in_room = number_of_people_in_room;
		this.status = status;
		this.current_electric_meter = current_electric_meter;
		this.current_water_meter = current_water_meter;
		this.room_cost = room_cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBoarding_house_id() {
		return boarding_house_id;
	}

	public void setBoarding_house_id(String boarding_house_id) {
		this.boarding_house_id = boarding_house_id;
	}

	public int getNumber_of_people_in_room() {
		return number_of_people_in_room;
	}

	public void setNumber_of_people_in_room(int number_of_people_in_room) {
		this.number_of_people_in_room = number_of_people_in_room;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCurrent_electric_meter() {
		return current_electric_meter;
	}

	public void setCurrent_electric_meter(int current_electric_meter) {
		this.current_electric_meter = current_electric_meter;
	}

	public int getCurrent_water_meter() {
		return current_water_meter;
	}

	public void setCurrent_water_meter(int current_water_meter) {
		this.current_water_meter = current_water_meter;
	}

	public double getRoom_cost() {
		return room_cost;
	}

	public void setRoom_cost(double room_cost) {
		this.room_cost = room_cost;
	}
}
