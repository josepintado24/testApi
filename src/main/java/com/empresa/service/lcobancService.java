package com.empresa.service;

import com.empresa.entity.lcobanc;

import java.util.List;

public interface lcobancService {

    public abstract List<Object[]> listarBanc(int opcion, String p_ciacont, lcobanc obj);
}

