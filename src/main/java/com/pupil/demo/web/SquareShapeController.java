package com.pupil.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pupil.demo.model.SquareShape;

@RestController
@RequestMapping("/api/v1/squareShape")
public class SquareShapeController extends AdminController{
	private static final Logger LOGGER = LoggerFactory.getLogger(SquareShapeController.class);

	@GetMapping("/")
	private ResponseEntity<List<SquareShape>> getAllStoredShapes() {

		try {
			
			List<SquareShape> listStorage = squareShapeServiceImpl.getAllStoredShapes();

			if (listStorage.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(listStorage, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@GetMapping("/{id}")
	private ResponseEntity<SquareShape> getSquareShape(@PathVariable("id") Long id) {
		 return new ResponseEntity<>(squareShapeServiceImpl.getSquareShapeById(id), HttpStatus.OK); 
	}

	
	@PostMapping("/storeNewShape")
	private ResponseEntity<SquareShape> storeNewShape(@RequestBody SquareShape squareShape) {
		
		if (findSquareShapeByName(squareShape.getName()).size()>0) {
	       return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
	    } else {
	       return ResponseEntity.status(HttpStatus.CREATED).body(squareShapeServiceImpl.saveOrUpdate(squareShape));
	    }
	}
}
