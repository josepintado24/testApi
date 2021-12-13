package com.empresa.controller;

import com.empresa.entity.lcobanc;
import com.empresa.service.lcobancService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/rest/lcobanc")
@CrossOrigin(origins = "http://localhost:4200")
public class lcobancController {

    @Autowired
    private lcobancService service;

    @GetMapping("/listarBco/{p_ciacont}")
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
        obj.setBl_usrcrea("");
        obj.setBl_feccrea(LocalDate.now());
        obj.setBl_hracrea(LocalTime.now());
        obj.setBl_usract("");
        obj.setBl_fecact(LocalDate.now());
        obj.setBl_hraact(LocalTime.now());
        try{
            List<Object[]> lista = service.listarBanc(0, p_ciacont, obj);
            //Devuelve la lista si la consulta fue exitosa
            return ResponseEntity.ok(lista);
        }catch (Exception e){
            throw new Exception("Error HUR1002 + " + e.getMessage());
        }
    }
}
