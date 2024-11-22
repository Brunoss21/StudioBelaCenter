package com.studiob.studiobela.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

    @Autowired AtendimentoDAO aDao;

    public void inserirAtendimento(Atendimento ati){
        aDao.inserirAtendimento(ati);
    }

    public List<Map<String, Object>> listarAtendimentos(){
        return aDao.listarAtendimentos();  
    }
    
}
