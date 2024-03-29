package org.example.service;


import org.example.model.Paciente;
import org.example.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Define a classe como um bean do Spring
public class PacienteService {

        @Autowired
        private IPacienteRepository repository; // injeta o repositório

        public List<Paciente> findAll(){
            return repository.findAll();
        } // retorna uma lista com todas as clinicas inseridas

        public Paciente findOne(Long id){
            return repository.findOne(id);
        } // retorna paciente a partir do id informado

        public Paciente save (Paciente paciente){
            return repository.saveAndFlush(paciente);
        }  // salva ou atualiza um paciente

        public void delete (Long id){
            repository.delete(id);
        } // exclui paciente
    }

