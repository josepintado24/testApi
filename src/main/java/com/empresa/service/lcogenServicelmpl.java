package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.lco0001tgen;
import com.empresa.entity.lco0001tgenPk;
import com.empresa.repository.lcgenRepository;

@Service
public class lcogenServicelmpl implements lcogenService {

	@Autowired
	private lcgenRepository repository;

	@Override
	public List<lco0001tgen> listaProveedor(int opcion, String tablename, lco0001tgen obj) {
		//return repository.findAll();
		return repository.listAll(opcion, tablename, obj.getPkID().getTl_codtabla(), obj.getPkID().getTl_clave(),
				obj.getTl_descri(), obj.getTl_descri2(), obj.getTl_usrcrea(), obj.getTl_feccrea(), obj.getTl_hracrea(),
				obj.getTl_usract(), obj.getTl_fecact(), obj.getTl_hraact());
	}

	@Override
	public lco0001tgen insertaActualizaproveedor(lco0001tgen obj) {
		return repository.save(obj);
	}
	

	@Override
	public void Eliminar(lco0001tgenPk pk) {
		repository.deleteById(pk);
		
	}

	@Override
	public void registrarNuevoRegistro(int opcion, String tablename, lco0001tgen obj) {
		repository.registrarRegistro(opcion, tablename, obj.getPkID().getTl_codtabla(), obj.getPkID().getTl_clave(),
				obj.getTl_descri(), obj.getTl_descri2(), obj.getTl_usrcrea(), obj.getTl_feccrea(), obj.getTl_hracrea(),
				obj.getTl_usract(), obj.getTl_fecact(), obj.getTl_hraact());
		
	}

	@Override
	public void editarRegistro(int opcion, String tablename, lco0001tgen obj) {
		repository.actualizaRegistro(opcion, tablename, obj.getPkID().getTl_codtabla(), obj.getPkID().getTl_clave(),
				obj.getTl_descri(), obj.getTl_descri2(), obj.getTl_usrcrea(), obj.getTl_feccrea(), obj.getTl_hracrea(),
				obj.getTl_usract(), obj.getTl_fecact(), obj.getTl_hraact());
	}

	@Override
	public void eliminarRegistro(int opcion, String tablename, lco0001tgen obj) {
		repository.eliminaRegistro(opcion, tablename, obj.getPkID().getTl_codtabla(), obj.getPkID().getTl_clave(),
				obj.getTl_descri(), obj.getTl_descri2(), obj.getTl_usrcrea(), obj.getTl_feccrea(), obj.getTl_hracrea(),
				obj.getTl_usract(), obj.getTl_fecact(), obj.getTl_hraact());
		
	}

}
