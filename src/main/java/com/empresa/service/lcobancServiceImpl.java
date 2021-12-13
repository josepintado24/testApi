package com.empresa.service;

import com.empresa.entity.lcobanc;
import com.empresa.repository.lcobancRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class lcobancServiceImpl implements lcobancService{

    @Autowired
    private lcobancRepository repository;

    @Override
    public List<Object[]> listarBanc(int opcion, String p_ciacont, lcobanc obj) {
        return repository.listarBanc(opcion, p_ciacont, obj.getBl_codbco(),
                obj.getBl_nombco(), obj.getBl_tipmon(), obj.getBl_numcta(), obj.getBl_estado(),
                obj.getBl_cuenta(), obj.getBl_desccta(), obj.getBl_entfina(), obj.getBl_tipocta(),
                obj.getBl_flcaja(), obj.getBl_usrcrea(), obj.getBl_feccrea(), obj.getBl_hracrea(),
                obj.getBl_usract(), obj.getBl_fecact(), obj.getBl_hraact());
    }
}
