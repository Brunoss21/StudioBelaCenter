package com.studiob.studiobela.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class AtendimentoDAO {
    @Autowired DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirAtendimento(Atendimento ati){
        String sql = "INSERT INTO atendimento(nome,telefone, servico, data, horario)" + 
        " VALUEs (?,?,?,?,?)";
        Object[] obj = new Object[5];
        obj[0] = ati.getNome();
        obj[1] = ati.getTelefone();
        obj[2] = ati.getServico();
        obj[3] = ati.getData();
        obj[4] = ati.getHorario();

        jdbc.update(sql, obj);
    }
    
    public List<Map<String, Object>> listarAtendimentos(){
        String sql = "SELECT * FROM atendimento";
        return jdbc.queryForList(sql);
    }

    public List<Map<String,Object>> obterAtendimento(int id){
        String sql = "SELECT * FROM atendimento where id = ?";
        Object[] obj = new Object[1];
        obj[0] = id;
        return jdbc.queryForList(sql,obj);
    }
}
