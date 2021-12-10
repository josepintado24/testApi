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
import com.empresa.entity.lcotgen;
import com.empresa.entity.lcotgenPk;
import com.empresa.service.lcogenService;

@RestController
@RequestMapping("/rest/lcgen")
@CrossOrigin(origins = "http://localhost:4200")
public class lcgenController {

	@Autowired
	private lcogenService service;

	/*
	METODO GET PARA LISTAR LOS REGISTROS SEGUN EL P_CIACONT(NUMERO DE LA COMPAÑIA)
	PARAMETROS:
		P_CIACONT, NUMERO DE LA COMPAÑIA
	
	@GetMapping("/Listarlcgen/{p_ciacont}")
	@ResponseBody
	public ResponseEntity<List<lcotgen>> lista(@PathVariable("p_ciacont") String p_ciacont) throws Exception {
			//CREAMOS UN OBJETO PARA LLENAR LOS DATOS DE SALIDA
			lcotgen objSalida = new lcotgen();
			//CREAMOS UN OBJETO QUE SERA LA LLAVE PRIMARIA
			lcotgenPk pk = new lcotgenPk();
			//SETEAMOS LOS VALORES, ESTOS NO SERAN REQUERIDOS DESDE EL FRONT
			//SON REQUERIDOS PARA EL PROCEDURE
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
			try {
				//CREAMOS UNA LISTA Y LA LLENAMOS CON LA DATA QUE NOS LLEGA DE LA BASE DE DATOS
				//TAMBIEN LLAMAMOS AL OBJETO SERVICE E INVOCAMOS A SU METODO LISTA REGISTROS
				//COMO PRIMER PARAMETRO LE PASAMOS LA OPCION 0, QUE REALIZARA EL METODO GET
				//COMO SEGUNDO PARAMETRO LE PASAMOS EL P_CIACONT
				//COMO TERCER PARAMETRO LE PASAMOS EL OBJETO DE SALIDA, REQUERIDO POR EL PROCEDURE
				List<lcotgen> lista = service.listaRegistros(0, p_ciacont, objSalida);
				
				//DEVUELVE LA LISTA SI LA CONSULTA FUE EXITOSA
				return ResponseEntity.ok(lista);
			}catch(Exception e) {
				//DEVUELVE LA EXEPCION QUE HAYA CAPTURADO
				throw new Exception("Error HUR1007 + " + e.getMessage());
			}
			
			
	}*/
	
	
	
	/*
	METODO GET PARA LISTAR LOS REGISTROS SEGUN EL P_CIACONT(NUMERO DE LA COMPAÑIA), COD_TABLA Y COD_CLAVE
	PARAMETROS:
		P_CIACONT, NUMERO DE LA COMPAÑIA
		COD_TABLA, CODIGO DE TABLA A BUSCAR,
		COD_CLAVE, CODIGO CLAVE A BUSCAR(OPCIONAL)
	*/
	@GetMapping(value={"/listarporclave/{p_ciacont}/{cod_tabla}",
			"/listarporclave/{p_ciacont}/{cod_tabla}/{cod_clave}",
			"/listarporclave/{p_ciacont}"})
	@ResponseBody
	public ResponseEntity<List<lcotgen>> listaPorCodigo(@PathVariable("p_ciacont") String p_ciacont,
														@PathVariable(value="cod_tabla",required = false) String cod_tabla,
														@PathVariable(value="cod_clave", required=false) String cod_clave) throws Exception{
		
		//CREAMOS UN OBJETO PARA LLENAR LOS DATOS DE SALIDA
		lcotgen objSalida = new lcotgen();
		//CREAMOS UN OBJETO QUE SERA LA LLAVE PRIMARIA
		lcotgenPk pk = new lcotgenPk();
		//SETEAMOS EL CODIGO DE TABLA, CON EL CODIGO DE TABLA QUE VIENE POR PARAMETRO EN LA URL
		if(cod_tabla != null) {
			//SI VIENE POR PARAMETRO EL CODIGO CLAVE ENTONCES SETEAMOS ESE VALOR
			pk.setTl_codtabla(cod_tabla);
		}else {
			//EN CASO NO VENGA POR PARAMETRO 
			pk.setTl_codtabla("");
		}
		
		
		//VALIDAMOS SI VIENE O NO EL CODIGO CLAVE
		if(cod_clave != null) {
			//SI VIENE POR PARAMETRO EL CODIGO CLAVE ENTONCES SETEAMOS ESE VALOR
			pk.setTl_clave(cod_clave);
		}else {
			//EN CASO NO VENGA POR PARAMETRO 
			pk.setTl_clave("");
		}
		
		objSalida.setPkID(pk);
		objSalida.setTl_descri("a");
		objSalida.setTl_descri2("a");
		objSalida.setTl_usrcrea("a");
		objSalida.setTl_feccrea(LocalDate.now());
		objSalida.setTl_hracrea(LocalTime.now());
		objSalida.setTl_usract("a");
		objSalida.setTl_fecact(LocalDate.now());
		objSalida.setTl_hraact(LocalTime.now());
		try {
			//CREAMOS UNA LISTA Y LA LLENAMOS CON LA DATA QUE NOS LLEGA DE LA BASE DE DATOS
			//TAMBIEN LLAMAMOS AL OBJETO SERVICE E INVOCAMOS A SU METODO LISTA UN REGISTRO
			//COMO PRIMER PARAMETRO LE PASAMOS LA OPCION 4, QUE REALIZARA EL METODO GET PARA UN REGISTRO ESPECIFICO
			//COMO SEGUNDO PARAMETRO LE PASAMOS EL P_CIACONT
			//COMO TERCER PARAMETRO LE PASAMOS EL OBJETO DE SALIDA, REQUERIDO POR EL PROCEDURE
			List<lcotgen> lista = service.listaUnRegistro(0, p_ciacont, objSalida);
			return ResponseEntity.ok(lista);
		}catch(Exception e) {
			throw new Exception("Error HUR1007 + " + e.getMessage());
		}
	}
	
	
	
	/*
	METODO POST PARA LISTAR LOS REGISTROS SEGUN EL P_CIACONT(NUMERO DE LA COMPAÑIA), COD_TABLA Y COD_CLAVE
	PARAMETROS:
		P_CIACONT, NUMERO DE LA COMPAÑIA
		COD_TABLA, CODIGO DE TABLA A BUSCAR,
		COD_CLAVE, CODIGO CLAVE A BUSCAR(OPCIONAL)
	*/
	@PostMapping("/registralcgen/{p_ciacont}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registraProveedor(@PathVariable("p_ciacont") String p_ciacont,
																  @RequestBody lcotgen obj){
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		try {		
				//LLAMAMOS AL OBJETO SERVICE E INVOCAMOS EL METODO REGISTRARNUEVOREGISTRO
				//COMO PRIMER PARAMETRO LE PASAMOS LA OPCION 1, QUE CREARA UN NUEVO REGISTRO
				//COMO SEGUNDO PARAMETRO LE PASAMOS EL P_CIACONT
				//COMO TERCER PARAMETRO LE PASAMOS EL OBJETO QUE AÑADIREMOS
				service.registrarNuevoRegistro(1, p_ciacont, obj);
				salida.put("mensaje", "Registrado correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error HUR1007 "+e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
	
	/*
	METODO PUT PARA ACTUALIZAR LOS REGISTROS SEGUN EL P_CIACONT(NUMERO DE LA COMPAÑIA)
	PARAMETROS:
		P_CIACONT, NUMERO DE LA COMPAÑIA
	*/
	@PutMapping("actuTablaGen/{p_ciacont}")
	public ResponseEntity<Map<String, Object>> actualizaRegistro(@PathVariable("p_ciacont") String p_ciacont,
																 @RequestBody lcotgen obj){
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITO O ERROR
		Map<String, Object> salida = new HashMap<>();
		try {
			//ACTUALIZAMOS EL DIA Y LA HORA 
			obj.setTl_fecact(LocalDate.now());
			obj.setTl_hraact(LocalTime.now());
			
			//LLAMAMOS AL OBJETO SERVICE E INVOCAMOS AL METODO EDITAR REGISTRO
			//COMO PRIMER PARAMETRO LE PASAMOS LA OPCION 2, QUE HARA EL UPDATE DESDE EL PROCEDURE
			//COMO SEGUNDO PARAMETRO LE PASAMOS EL P_CIACONT
			//COMO TERCER PARAMETRO LE PASAMOS EL OBJETO CON LOS CAMPOS QUE QUEREMOS ACTUALIZAR
			service.editarRegistro(2, p_ciacont, obj);
			salida.put("mensaje", "Actualizado correctamente");
		}catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error HUR1007 "+ e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
	
	/*
	METODO DELETE PARA ELIMINAR LOS REGISTROS SEGUN EL P_CIACONT(NUMERO DE LA COMPAÑIA), COD_TABLA Y COD_CLAVE
	PARAMETROS:
		P_CIACONT, NUMERO DE LA COMPAÑIA
		COD_TABLA, CODIGO DE LA TABLA, CAMPO DE LA PRIMARY KEY
		COD_CLAVE, CLAVE DE LA TABLA, CAMPO DE LA PRIMERY KEY
	*/
	@DeleteMapping("elimTablaGen/{p_ciacont}/{cod_tabla}/{cod_clave}")
	public ResponseEntity<Map<String, Object>> eliminarRegistro(@PathVariable("p_ciacont") String p_ciacont,
																@PathVariable("cod_tabla") String cod_tabla,
																@PathVariable("cod_clave") String cod_clave){
				//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITO O ERROR
				Map<String, Object> salida = new HashMap<>();
				try {
					//CREAMOS UN OBJETO DE SALIDA
					lcotgen objSalida = new lcotgen();
					
					//CREAMOS UN OBJETO DE LA LLAVE PRIMARIA
					lcotgenPk pk = new lcotgenPk();
					
					//SETEAMOS LOS VALORES DE LOS CAMPOS DE LA LLAVE PRIMARIA, 
					//PARA SABER QUE REGISTRO SE VA A ELIMINAR
					pk.setTl_codtabla(cod_tabla);
					pk.setTl_clave(cod_clave);
					
					//SETEAMOS LOS VALORES DEL OBJETO, QUE ES REQUERIDO POR EL PROCEDURE
					objSalida.setPkID(pk);
					objSalida.setTl_descri("a");
					objSalida.setTl_descri2("a");
					objSalida.setTl_usrcrea("a");
					objSalida.setTl_feccrea(LocalDate.now());
					objSalida.setTl_hracrea(LocalTime.now());
					objSalida.setTl_usract("a");
					objSalida.setTl_fecact(LocalDate.now());
					objSalida.setTl_hraact(LocalTime.now());
					
					//LLAMAMOS AL OBJETO SERVICE E INVOCAMOS AL METODO ELIMINAR REGISTRO
					//COMO PRIMER PARAMETRO LE PASAMOS LA OPCION 3, QUE HARA EL DELETE DESDE EL PROCEDURE
					//COMO SEGUNDO PARAMETRO LE PASAMOS EL P_CIACONT
					//COMO TERCER PARAMETRO LE PASAMOS EL OBJETO REQUERIDO POR EL PROCEDURE
					//DEL OBJETO SOLO TOMARA LA LLAVE PRIMARIA
					service.eliminarRegistro(3, p_ciacont, objSalida);
					salida.put("mensaje", "Eliminado correctamente");
 				} catch(Exception e){
 					e.printStackTrace();
 					salida.put("mensaje", "Error HUR1007 "+ e.getMessage());
 				}
				return ResponseEntity.ok(salida);
	}
	
	
}
