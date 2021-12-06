package com.empresa.service;

import java.util.List;



import com.empresa.entity.lco0001tgen;
import com.empresa.entity.lco0001tgenPk;

public interface lcogenService {

	public abstract List<lco0001tgen> listaProveedor(int opcion, String tablename, lco0001tgen obj);
	

	

	public abstract lco0001tgen insertaActualizaproveedor(lco0001tgen obj);
	
	void registrarNuevoRegistro(int opcion, String tablename, lco0001tgen obj);
	
	void editarRegistro(int opcion, String tablename, lco0001tgen obj);
	
	void eliminarRegistro(int opcion, String tablename, lco0001tgen obj);

	void Eliminar(lco0001tgenPk pk);
	
	

}
