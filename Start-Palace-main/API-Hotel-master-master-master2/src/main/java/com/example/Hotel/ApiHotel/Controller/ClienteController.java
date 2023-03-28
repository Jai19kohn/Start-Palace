package com.example.Hotel.ApiHotel.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.repository.ClientRepository;

@RestController
public class ClienteController {
    //--------------------------------------|CLIENT|------------------------------------------------------
    @Autowired
    private ClientRepository clientRepository;
   
    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> addClient (@RequestBody ClientDTO c){
        ClientDAO clientePersisted = clientRepository.save(c.toDAO());
        return new ResponseEntity<ClientDTO>(clientePersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping ("/clients/{id}/atualizar")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO c){
        c.setId(id);
        System.out.println("");
        ClientDAO clientUpdated = clientRepository.save(c.toDAO());
        return new ResponseEntity<ClientDTO>(clientUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/clientsall")
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        return ResponseEntity.ok().body(clientRepository.findAll()
                .stream()
                .map(clientDAO -> clientDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping ("/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id){
        Optional<ClientDAO> client = clientRepository.findById(id);
        if (client.isPresent()){
            return new ResponseEntity<ClientDTO>(client.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping ("/clients/{id}/excluir")
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable("id") Long id){
        ClientDAO client = new ClientDAO();
        client.setId(id);
        clientRepository.delete(client);
        return ResponseEntity.noContent().build();
    }

}
