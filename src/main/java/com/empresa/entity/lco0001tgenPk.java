package com.empresa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class lco0001tgenPk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tl_codtabla  ;
	String tl_clave ;
	
	public lco0001tgenPk(String id1, String id2) {
		// TODO Auto-generated constructor stub
	}
	public lco0001tgenPk() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTl_codtabla() {
		return tl_codtabla;
	}
	public void setTl_codtabla(String tl_codtabla) {
		this.tl_codtabla = tl_codtabla;
	}
	public String getTl_clave() {
		return tl_clave;
	}
	public void setTl_clave(String tl_clave) {
		this.tl_clave = tl_clave;
	}
	
	

}
