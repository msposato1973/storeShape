package com.pupil.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pupil.demo.model.SquareShape;
import com.pupil.demo.service.SquareShapeService;

public class AdminController {
	
	@Autowired
	protected SquareShapeService squareShapeServiceImpl;
	
	
	protected List<SquareShape> findSquareShapeByName(String searchName) {
        return squareShapeServiceImpl.findPersonsBySearchName(searchName);
    }
}
