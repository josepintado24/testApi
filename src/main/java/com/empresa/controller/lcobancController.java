package com.empresa.controller;

import com.empresa.entity.lcobanc;
import com.empresa.service.lcobancService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/lcobanc")
@CrossOrigin(origins = "http://localhost:4200")
public class lcobancController {

    @Autowired
    private lcobancService service;

    @GetMapping("/listarCaj/{p_ciacont}")
    @ResponseBody
    public ResponseEntity<List<Object[]>> listar(@PathVariable("p_ciacont") String p_ciacont) throws Exception{
        //Creamos un objeto para el procedure
        lcobanc obj = new lcobanc();
        obj.setBl_codbco("");
        obj.setBl_nombco("");
        obj.setBl_tipmon("");
        obj.setBl_numcta("");
        obj.setBl_estado("");
        obj.setBl_cuenta("");
        obj.setBl_desccta("");
        obj.setBl_entfina("");
        obj.setBl_tipocta("");
        obj.setBl_flcaja("");
        obj.setBl_fche1("");
        obj.setBl_fche2("");
        obj.setBl_fche3("");
        obj.setBl_nche1("");
        obj.setBl_nche2("");
        obj.setBl_nche3("");
        obj.setBl_frche("");
        obj.setBl_modesdcta("");
        obj.setBl_usrcrea("");
        obj.setBl_feccrea(LocalDate.now());
        obj.setBl_hracrea(LocalTime.now());
        obj.setBl_usract("");
        obj.setBl_fecact(LocalDate.now());
        obj.setBl_hraact(LocalTime.now());
        try{
            List<Object[]> lista = service.listarCaj(0, p_ciacont, obj);
            //Devuelve la lista si la consulta fue exitosa
            return ResponseEntity.ok(lista);
        }catch (Exception e){
            throw new Exception("Error HUR1002 + " + e.getMessage());
        }
    }
    
    @GetMapping("/listarBco/{p_ciacont}")
    @ResponseBody
    public ResponseEntity<List<Object[]>> listarBco(@PathVariable("p_ciacont") String p_ciacont) throws Exception{
        //Creamos un objeto para el procedure
        lcobanc obj = new lcobanc();
        obj.setBl_codbco("");
        obj.setBl_nombco("");
        obj.setBl_tipmon("");
        obj.setBl_numcta("");
        obj.setBl_estado("");
        obj.setBl_cuenta("");
        obj.setBl_desccta("");
        obj.setBl_entfina("");
        obj.setBl_tipocta("");
        obj.setBl_flcaja("");
        obj.setBl_fche1("");
        obj.setBl_fche2("");
        obj.setBl_fche3("");
        obj.setBl_nche1("");
        obj.setBl_nche2("");
        obj.setBl_nche3("");
        obj.setBl_frche("");
        obj.setBl_modesdcta("");
        obj.setBl_usrcrea("");
        obj.setBl_feccrea(LocalDate.now());
        obj.setBl_hracrea(LocalTime.now());
        obj.setBl_usract("");
        obj.setBl_fecact(LocalDate.now());
        obj.setBl_hraact(LocalTime.now());
        try{
            List<Object[]> lista = service.listarBco(0, p_ciacont, obj);
            //Devuelve la lista si la consulta fue exitosa
            return ResponseEntity.ok(lista);
        }catch (Exception e){
            throw new Exception("Error HUR1002 + " + e.getMessage());
        }
    }
    
    
    
    /*
	METODO POST PARA LISTAR LOS REGISTROS SEGUN EL P_CIACONT(NUMERO DE LA COMPAÑIA), COD_TABLA Y COD_CLAVE
	PARAMETROS:
		P_CIACONT, NUMERO DE LA COMPAÑIA
		COD_TABLA, CODIGO DE TABLA A BUSCAR,
		COD_CLAVE, CODIGO CLAVE A BUSCAR(OPCIONAL)
	*/
	@PostMapping(value={"/registraBco/{p_ciacont}", "/registarCaj/{p_ciacont}"})
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registraNume(@PathVariable("p_ciacont") String p_ciacont,
																  @RequestBody lcobanc obj){
		//CREAMOS UN MAP, QUE ALMACENARA LOS MENSAJES DE EXITOS O ERRORES
		Map<String, Object> salida = new HashMap<>();
		try {		
			//lcobanc listageneral = new lcobanc();
			
			
			/*
			//List<lcotgen> lista = serviceGeneral.listaUnRegistro(0, p_ciacont, listageneral);
			if(lista != null) {
				//LLAMAMOS AL OBJETO SERVICE E INVOCAMOS EL METODO REGISTRARNUEVOREGISTRO
				//COMO PRIMER PARAMETRO LE PASAMOS LA OPCION 1, QUE CREARA UN NUEVO REGISTRO
				//COMO SEGUNDO PARAMETRO LE PASAMOS EL P_CIACONT
				//COMO TERCER PARAMETRO LE PASAMOS EL OBJETO QUE AÑADIREMOS*/
				obj.setBl_feccrea(LocalDate.now());
				obj.setBl_hracrea(LocalTime.now());
				obj.setBl_fecact(LocalDate.now());
				obj.setBl_hraact(LocalTime.now());
				//service.registrarNume(1, p_ciacont, obj);
				
			/*}else {
				salida.put("mensaje", "No se encontro el registro");
			}*/
			service.registrarBco(1, p_ciacont, obj);
			salida.put("mensaje", "Registrado correctamente");
				
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error HUR1002 "+e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}
}
