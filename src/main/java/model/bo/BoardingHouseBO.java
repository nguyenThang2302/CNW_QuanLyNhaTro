package model.bo;

import java.util.List;
import java.util.UUID;

import model.bean.BoardingHouse;
import model.bean.Room;
import model.dao.BoardingHouseDAO;

public class BoardingHouseBO {
	BoardingHouseDAO boardingHouseDAO=new BoardingHouseDAO();
	
	public boolean create(BoardingHouse boardingHouse, UUID userId) {
		return boardingHouseDAO.create(boardingHouse,userId);
		
	}
	public List<BoardingHouse> getListBoardingHouse(UUID userId){
		return boardingHouseDAO.getListBoardingHouse(userId);
	}
	public BoardingHouse getBoardingHouseById(UUID userId,UUID boardingHouseId){
		return boardingHouseDAO.getBoardingHouseById(userId,boardingHouseId);
	}
	public boolean update(BoardingHouse boardingHouse, UUID userId) {
		return boardingHouseDAO.create(boardingHouse,userId);
		
	}
	public List<BoardingHouse> getListBoardingHouseOfTenant(UUID userId){
		return boardingHouseDAO.getListBoardingHoseOfTenant(userId);
	}
}
