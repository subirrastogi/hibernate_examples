package com.learn.hibernate.collections;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="ShOWROOM_LIST")
public class Showroom {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHOWROOM_ID")
	private int id=0;
	
	@Column(name="MANAGER")
	private String manager;
	
	@Column(name="LOCATION")
	private String location;
	
	@OneToMany
	@JoinColumn(name="SHOWROOM_ID")
	@Cascade(CascadeType.ALL)
	private List<Car> cars;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
