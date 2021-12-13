package com.empresa.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "lco0001banc")
public class lcobanc {

    @Id
    private String bl_codbco;

    private String bl_nombco;
    private String bl_tipmon;
    private String bl_numcta;
    private String bl_estado;
    private String bl_cuenta;
    private String bl_desccta;
    private String bl_entfina;
    private String bl_tipocta;
    private String bl_flcaja;
    private String bl_usrcrea;
    private LocalDate bl_feccrea;
    private LocalTime bl_hracrea;
    private String bl_usract;
    private LocalDate bl_fecact;
    private LocalTime bl_hraact;
	public String getBl_codbco() {
		return bl_codbco;
	}
	public void setBl_codbco(String bl_codbco) {
		this.bl_codbco = bl_codbco;
	}
	public String getBl_nombco() {
		return bl_nombco;
	}
	public void setBl_nombco(String bl_nombco) {
		this.bl_nombco = bl_nombco;
	}
	public String getBl_tipmon() {
		return bl_tipmon;
	}
	public void setBl_tipmon(String bl_tipmon) {
		this.bl_tipmon = bl_tipmon;
	}
	public String getBl_numcta() {
		return bl_numcta;
	}
	public void setBl_numcta(String bl_numcta) {
		this.bl_numcta = bl_numcta;
	}
	public String getBl_estado() {
		return bl_estado;
	}
	public void setBl_estado(String bl_estado) {
		this.bl_estado = bl_estado;
	}
	public String getBl_cuenta() {
		return bl_cuenta;
	}
	public void setBl_cuenta(String bl_cuenta) {
		this.bl_cuenta = bl_cuenta;
	}
	public String getBl_desccta() {
		return bl_desccta;
	}
	public void setBl_desccta(String bl_desccta) {
		this.bl_desccta = bl_desccta;
	}
	public String getBl_entfina() {
		return bl_entfina;
	}
	public void setBl_entfina(String bl_entfina) {
		this.bl_entfina = bl_entfina;
	}
	public String getBl_tipocta() {
		return bl_tipocta;
	}
	public void setBl_tipocta(String bl_tipocta) {
		this.bl_tipocta = bl_tipocta;
	}
	public String getBl_flcaja() {
		return bl_flcaja;
	}
	public void setBl_flcaja(String bl_flcaja) {
		this.bl_flcaja = bl_flcaja;
	}
	public String getBl_usrcrea() {
		return bl_usrcrea;
	}
	public void setBl_usrcrea(String bl_usrcrea) {
		this.bl_usrcrea = bl_usrcrea;
	}
	public LocalDate getBl_feccrea() {
		return bl_feccrea;
	}
	public void setBl_feccrea(LocalDate bl_feccrea) {
		this.bl_feccrea = bl_feccrea;
	}
	public LocalTime getBl_hracrea() {
		return bl_hracrea;
	}
	public void setBl_hracrea(LocalTime bl_hracrea) {
		this.bl_hracrea = bl_hracrea;
	}
	public String getBl_usract() {
		return bl_usract;
	}
	public void setBl_usract(String bl_usract) {
		this.bl_usract = bl_usract;
	}
	public LocalDate getBl_fecact() {
		return bl_fecact;
	}
	public void setBl_fecact(LocalDate bl_fecact) {
		this.bl_fecact = bl_fecact;
	}
	public LocalTime getBl_hraact() {
		return bl_hraact;
	}
	public void setBl_hraact(LocalTime bl_hraact) {
		this.bl_hraact = bl_hraact;
	}
	public lcobanc(String bl_codbco, String bl_nombco, String bl_tipmon, String bl_numcta, String bl_estado,
			String bl_cuenta, String bl_desccta, String bl_entfina, String bl_tipocta, String bl_flcaja,
			String bl_usrcrea, LocalDate bl_feccrea, LocalTime bl_hracrea, String bl_usract, LocalDate bl_fecact,
			LocalTime bl_hraact) {
		super();
		this.bl_codbco = bl_codbco;
		this.bl_nombco = bl_nombco;
		this.bl_tipmon = bl_tipmon;
		this.bl_numcta = bl_numcta;
		this.bl_estado = bl_estado;
		this.bl_cuenta = bl_cuenta;
		this.bl_desccta = bl_desccta;
		this.bl_entfina = bl_entfina;
		this.bl_tipocta = bl_tipocta;
		this.bl_flcaja = bl_flcaja;
		this.bl_usrcrea = bl_usrcrea;
		this.bl_feccrea = bl_feccrea;
		this.bl_hracrea = bl_hracrea;
		this.bl_usract = bl_usract;
		this.bl_fecact = bl_fecact;
		this.bl_hraact = bl_hraact;
	}
	public lcobanc() {
		super();
	}

    
    


}
