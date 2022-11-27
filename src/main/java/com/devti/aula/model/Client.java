package com.devti.aula.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Chave primária de cliente")
	private Integer id;
	
	@Column
	@ApiModelProperty(value = "Nome do cliente")
	private String name;
	
	@Column
	@ApiModelProperty(value = "Gênero do cliente")
	private String gender;
	
	@Column
	@ApiModelProperty(value = "Idade do cliente")
	private Integer age;
	
	@ManyToOne
	private City city;
	
	public Client() {
		super();
	}
	public Client(Integer id, String name, String gender, Integer age, City city) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null) 
				return false;
		} else if (!id.equals(other.id)) 
			return false;
		return true;
	}
	
	
	
	
	
}
