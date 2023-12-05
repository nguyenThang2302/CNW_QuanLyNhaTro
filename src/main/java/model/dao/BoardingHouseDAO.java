package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import connection.ConnectionDB;
import model.bean.BoardingHouse;

public class BoardingHouseDAO {

	public boolean create(BoardingHouse boardingHouse, UUID userId) {
		ConnectionDB connectionDB=new ConnectionDB();
		Connection connection=connectionDB.connect();
		String sql="INSERT INTO `boarding_house` (`id`, `address`, `name`, `user_id`, `electricity_unit_price`, `water_unit_price`) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		int i=0;
		try {
			int count=1;
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(count++, UUID.randomUUID().toString());
			pstm.setString(count++, boardingHouse.getAddress());
			pstm.setString(count++, boardingHouse.getName());
			pstm.setString(count++, userId.toString());
			pstm.setDouble(count++, boardingHouse.getElectricityUnitPrice());
			pstm.setDouble(count++, boardingHouse.getWaterUnitPrice());
			i=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i >0 ? true : false;
	}

	public List<BoardingHouse> getListBoardingHouse(UUID userId) {
		List<BoardingHouse> boardingHouses=new ArrayList<>();
		ConnectionDB connectionDB=new ConnectionDB();
		Connection connection=connectionDB.connect();
		String sql="SELECT * FROM boarding_house WHERE user_id=?";
		int i=0;
		try {
			int count=1;
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(count++, UUID.randomUUID().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardingHouses;
	}
	

}
