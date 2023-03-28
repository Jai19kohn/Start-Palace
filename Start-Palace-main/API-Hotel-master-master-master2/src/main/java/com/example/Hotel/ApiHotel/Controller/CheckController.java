package com.example.Hotel.ApiHotel.Controller;


import com.example.Hotel.ApiHotel.DTO.CheckDTO;

import com.example.Hotel.ApiHotel.Models.CheckDAO;

import com.example.Hotel.ApiHotel.repository.CheckRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CheckController {

    @Autowired
    private CheckRepository checkRepository;
    public List<CheckDTO> CheckList= new ArrayList<CheckDTO>();

    public HashMap<Integer, CheckDTO> check = new HashMap<Integer, CheckDTO>();

    @PostMapping("/checks")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CheckDTO> addCheck (@RequestBody @Valid CheckDTO c){
        CheckDAO checkPersisted = checkRepository.save(c.toDAO());
        c.setAtive(true);
        checkPersisted.setAtive(true);

        System.out.println(c.toString());
        System.out.println(checkPersisted.toString());
        return new ResponseEntity<CheckDTO>(checkPersisted.toDTO(), HttpStatus.CREATED);
    }
    @PutMapping ("/check/{id}/atualizar")
    public ResponseEntity<CheckDTO> updateCheck(@PathVariable("id") Long idCheck, @RequestBody CheckDTO c){
        CheckDAO checkoutUpdate=  new CheckDAO();
        c.setIdCheck(idCheck);
        System.out.println("");
        checkoutUpdate.setHorarioCheckIn(c.getHorarioCheckIn());
        CheckDAO checkout = checkRepository.save(c.toDAO());
        return new ResponseEntity<CheckDTO>(checkoutUpdate.toDTO(), HttpStatus.OK);

    }
    @GetMapping("/checks")
    public ResponseEntity<List<CheckDTO>> getAllCheckout(){
        return ResponseEntity.ok().body(checkRepository.findAll()
                .stream()
                .map(checkDAO -> checkDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/checks/{id}/excluir")
    public ResponseEntity<CheckDTO> deleteCheckById(@PathVariable("id") Long idCheck){
        CheckDAO check = checkRepository.findById(idCheck).get();
        check.setIdCheck(idCheck);
        check.fazerCheckOut();
        CheckDAO checkUpdate = checkRepository.save(check);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/check/{id}")
    public ResponseEntity<CheckDTO>IdCheck(@PathVariable("id") Long id){
        Optional<CheckDAO>check = checkRepository.findById(id);
        if (check.isPresent()){
            return new ResponseEntity<CheckDTO>(check.get().toDTO(), HttpStatus.OK);
        } else {

            return ResponseEntity.notFound().build();
        }
    }
}
