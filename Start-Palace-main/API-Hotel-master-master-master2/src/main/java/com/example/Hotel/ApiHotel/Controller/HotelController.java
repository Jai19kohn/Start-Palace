package com.example.Hotel.ApiHotel.Controller;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import com.example.Hotel.ApiHotel.DTO.HoteisDTO;
import com.example.Hotel.ApiHotel.repository.HoteisRepository;
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
 public class HotelController {
    @Autowired
    private HoteisRepository hoteisRepository;
    private List<HoteisDTO> HoteisList = new ArrayList<HoteisDTO>();

    public HashMap<Integer, HoteisDTO> hotel = new HashMap<Integer, HoteisDTO>();


    @PostMapping("/hoteis")
    public ResponseEntity<HoteisDTO> addHoteis(@RequestBody @Valid HoteisDTO h) {
        HoteisDAO hotelPersisted = hoteisRepository.save(h.toDAO());
        String tamanhoLista = String.valueOf(hotel.size());
        return new ResponseEntity<HoteisDTO>(hotelPersisted.toDTO(), HttpStatus.CREATED);
    }


    @PutMapping("/hoteis/{id}/atualize")
    public ResponseEntity<HoteisDTO> atualizarHoteis(@PathVariable("id") Long id, @RequestBody HoteisDTO h) {
        h.setId(id);
        System.out.println("");
        HoteisDAO hoteisatualize = hoteisRepository.save(h.toDAO());
        return new ResponseEntity<HoteisDTO>(hoteisatualize.toDTO(), HttpStatus.OK);
    }


    @GetMapping("/hoteis")
    public ResponseEntity<List<HoteisDTO>> getHoteis(){
        return ResponseEntity.ok().body(hoteisRepository.findAll()
                .stream()
                .map(hoteisDAO -> hoteisDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping ("/hotel/{id}")
    public ResponseEntity<HoteisDTO> getClientById(@PathVariable("id") Long id){
        Optional<HoteisDAO> hoteis = hoteisRepository.findById(id);
        if (hoteis.isPresent()){
            return new ResponseEntity<HoteisDTO>(hoteis.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/hoteis/{id}/excluir")
    public ResponseEntity<HoteisDTO>deletarHotel(@PathVariable("id") Long id){
        HoteisDAO hotel = new HoteisDAO();
        hotel.setId(id);
        hoteisRepository.delete(hotel);
        return ResponseEntity.noContent().build();

    }
}

