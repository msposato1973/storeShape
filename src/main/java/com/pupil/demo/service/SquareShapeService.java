package com.pupil.demo.service;

import java.util.List;

import com.pupil.demo.model.SquareShape;

public interface SquareShapeService {
	
	List<SquareShape> getAllStoredShapes();
	
	SquareShape getSquareShapeById(Long id);
	  
	SquareShape saveOrUpdate(SquareShape stock);
    
    List<SquareShape> findPersonsBySearchName(String searchName);

}
