package com.devti.aula.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Chave primária da cidade")
    private Integer id;

    @Column
    @ApiModelProperty(value = "Nome da cidade")
    private String name;

    @Column
    @ApiModelProperty(value = "Unidade federativa da cidade")
    private String uf;


    public City() {
    }

    public City(Integer id, String name, String uf) {
        this.id = id;
        this.name = name;
        this.uf = uf;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof City)) {
            return false;
        }
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(name, city.name) && Objects.equals(uf, city.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, uf);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", uf='" + getUf() + "'" +
            "}";
    }

}