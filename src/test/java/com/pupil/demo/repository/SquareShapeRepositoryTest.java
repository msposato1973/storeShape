package com.pupil.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pupil.demo.model.SquareShape;

@RunWith(SpringRunner.class)
@SpringBootTest
class SquareShapeRepositoryTest {
	
	@MockBean
    private SquareShapeRepository squareShapeRepository;

    private List<SquareShape> listSquareShape = new ArrayList<>();

	@Before
	void setUp() throws Exception {
		listSquareShape = buildListSquareShape();
	}

	@Test
	void testGetAllStoredShapes() {
		when(this.squareShapeRepository.findAll()).thenReturn(listSquareShape);
		
	}
	
	@Test
	void findAll_success() {
		List<SquareShape> allSquareShape = squareShapeRepository.findAll();
	    assertThat(allSquareShape.size()>0);
	}
	
	@Test
	void getSquareShapeById_success() {
		Long idToFind = Long.getLong("17371");
		SquareShape squareShapeToFind = buildsquareShape();
		
		
		when(this.squareShapeRepository.findById(idToFind)).thenReturn(Optional.of(squareShapeToFind));
		assertThat(squareShapeToFind!=null);
	}
	
	@Test
	void getSquareShapeByName_success() {
		String nameToFind = "Max";
		SquareShape squareShapeToFind = buildListSquareShapeByName().get(0);
		
		when(this.squareShapeRepository.findByName(nameToFind)).thenReturn(buildListSquareShapeByName());
		assertThat(squareShapeToFind!=null);
	}
	

	private List<SquareShape> buildListSquareShape() {
		List<SquareShape> list = Arrays.asList(
				new SquareShape(Long.getLong("17371"), "Square", "karim", "Rectanbgle"),
	            new SquareShape(Long.getLong("17372"), "Square", "khan", "Square"),
	            new SquareShape(Long.getLong("17373"), "Square", "Max", "Circle")
	    );
		
		return list;
	}
	
	private List<SquareShape> buildListSquareShapeByName() {
		List<SquareShape> list = Arrays.asList(new SquareShape(Long.getLong("17370"), "Square", "Max", "Rectanbgle"));
		
		return list;
	}
	
	
	
	private SquareShape buildsquareShape() {
		return new SquareShape(Long.getLong("17371"), "Square", "karim", "Rectanbgle");
	}

}