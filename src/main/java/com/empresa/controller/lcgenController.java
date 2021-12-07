package com.empresa.controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.empresa.entity.lco0001tgen;
import com.empresa.entity.lco0001tgenPk;
import com.empresa.service.lcogenService;

@RestController
@RequestMapping("/rest/lcgen")
@CrossOrigin(origins = "http://localhost:4200")
public class lcgenController {

	@Autowired
	private lcogenService proveedorService;

	@GetMapping("/Listarlcgen/{opcion}/{tablename}")
	@ResponseBody
	public ResponseEntity<List<lco0001tgen>> listaDocente(@PathVariable("opcion") int opcion,
														  @PathVariable("tablename") String tablename) {
		lco0001tgen objSalida = new lco0001tgen();
		lco0001tgenPk pk = new lco0001tgenPk();
		pk.setTl_codtabla("00");
		pk.setTl_clave("00");
		objSalida.setPkID(pk);
		objSalida.setTl_descri("a");
		objSalida.setTl_descri2("a");
		objSalida.setTl_usrcrea("a");
		objSalida.setTl_feccrea(LocalDate.now());
		objSalida.setTl_hracrea(LocalTime.now());
		objSalida.setTl_usract("a");
		objSalida.setTl_fecact(LocalDate.now());
		objSalida.setTl_hraact(LocalTime.now());
		List<lco0001tgen> lista = proveedorService.listaProveedor(opcion, tablename, objSalida);
		return ResponseEntity.ok(lista);
	}
	

	@PostMapping("/registralcgen/{opcion}/{tablename}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registraProveedor(@PathVariable("opcion") int opcion,
															      @PathVariable("tablename") String tablename,
																  @RequestBody lco0001tgen obj){
		Map<String, Object> salida = new HashMap<>();
		try {				
				proveedorService.registrarNuevoRegistro(opcion, tablename, obj);
				salida.put("mensaje", "Registrado correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error"+e);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("actuTablaGen/{opcion}/{cod_tabla}")
	public ResponseEntity<Map<String, Object>> actualizaRegistro(@PathVariable("opcion") int opcion,
																@PathVariable("cod_tabla") String tl_codtabla,
																@RequestBody lco0001tgen obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setTl_fecact(LocalDate.now());
			obj.setTl_hraact(LocalTime.now());
			proveedorService.editarRegistro(opcion, tl_codtabla, obj);
			salida.put("mensaje", "Actualizado correctamente");
		}catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("elimTablaGen/{opcion}/{cod_tabla}/{id1}/{id2}")
	public ResponseEntity<Map<String, Object>> eliminarRegistro(@PathVariable("opcion") int opcion,
																@PathVariable("cod_tabla") String cod_tabla,
																@PathVariable("id1") String id1,
																@PathVariable("id2") String id2){
				Map<String, Object> salida = new HashMap<>();
				try {
					lco0001tgen objSalida = new lco0001tgen();
					lco0001tgenPk pk = new lco0001tgenPk();
					pk.setTl_codtabla(id1);
					pk.setTl_clave(id2);
					
					objSalida.setPkID(pk);
					objSalida.setTl_descri("a");
					objSalida.setTl_descri2("a");
					objSalida.setTl_usrcrea("a");
					objSalida.setTl_feccrea(LocalDate.now());
					objSalida.setTl_hracrea(LocalTime.now());
					objSalida.setTl_usract("a");
					objSalida.setTl_fecact(LocalDate.now());
					objSalida.setTl_hraact(LocalTime.now());
					
					
					proveedorService.eliminarRegistro(opcion, cod_tabla, objSalida);
					salida.put("mensaje", "Eliminado correctamente");
 				} catch(Exception e){
 					e.printStackTrace();
 					salida.put("mensaje", "Error");
 				}
				return ResponseEntity.ok(salida);
	}
	
	
	/*@DeleteMapping("/EliminaProveedor")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> EliminaProveedor(@RequestBody Proveedor pk )
	{
		//log.info("==> listaMarcaPorId ==> nom : " + id);
		Map<String, Object> salida = new HashMap<>();
		try {
				
			 proveedorService.Eliminar(pk);
			 salida.put("mensaje", "Eliminado correctamente");
				
			}
	catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Marca no encontrada ");
		}
		return ResponseEntity.ok(salida);
	}*/
	
	/*@PutMapping("/actualizaProveedor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProveedor(@RequestBody Proveedor obj) {

	
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getPkID() != null) {

				Proveedor objSalida = proveedorService.insertaActualizaproveedor(obj);
				if (objSalida == null) {
					salida.put("mensaje", "Error al actualizar");
				} else {
					salida.put("mensaje", "Se actualizo correctamente");
				}	
			}else {
				salida.put("mensaje", "El ID de la Marca debe ser diferente cero");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("error al actualizar", "error");
		}
		return ResponseEntity.ok(salida);
	}*/
	
	
}
