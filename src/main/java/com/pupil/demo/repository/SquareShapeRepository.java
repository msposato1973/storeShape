package com.pupil.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pupil.demo.model.SquareShape;

@Repository
public interface SquareShapeRepository extends JpaRepository<SquareShape,Long>{
	
	/**
     * Finds SquareShape by using the last name as a search criteria.
     * @param Name
     * @return  A list of SquareShape whose last name is an exact match with the given  name.
     *          If no SquareShape is found, this method returns null.
     */
	@Query(value = "SELECT * FROM SquareShape p WHERE LOWER(p.name) = LOWER(:name)", nativeQuery = true)
    List<SquareShape> findByName(@Param("name") String name);
}