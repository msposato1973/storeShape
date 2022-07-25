package com.pupil.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pupil.demo.model.SquareShape;
import com.pupil.demo.repository.SquareShapeRepository;

@Service
public class SquareShapeServiceImpl implements SquareShapeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SquareShapeServiceImpl.class);

	@Autowired
	private SquareShapeRepository squareShapeRepository;

	@Override
	public List<SquareShape> getAllStoredShapes() {
		List<SquareShape> list = new ArrayList<SquareShape>();
		squareShapeRepository.findAll().forEach(item -> list.add(item));

		return list;
	}

	@Override
	public SquareShape getSquareShapeById(Long id) {
		return squareShapeRepository.findById(id).get();
	}

	@Override
	public SquareShape saveOrUpdate(SquareShape stock) {
		return squareShapeRepository.save(stock);
	}

	@Override
	public List<SquareShape> findPersonsBySearchName(String searchName) {
		List<SquareShape> squareShapes;

		LOGGER.debug("Searching SquareShape by using query annotation");
		squareShapes = squareShapeRepository.findByName(searchName);
		return squareShapes;
	}

}
