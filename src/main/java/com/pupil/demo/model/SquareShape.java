package com.pupil.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SquareShape")
public class SquareShape {

	public SquareShape(Long id, String type, String name, String geometryDescriptor) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.geometryDescriptor = geometryDescriptor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String type;

	@Column
	private String name;

	@Column
	private String geometryDescriptor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getGeometryDescriptor() {
		return geometryDescriptor;
	}

	public void setGeometryDescriptor(String geometryDescriptor) {
		this.geometryDescriptor = geometryDescriptor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(geometryDescriptor, id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareShape other = (SquareShape) obj;
		return Objects.equals(geometryDescriptor, other.geometryDescriptor) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
	
}
