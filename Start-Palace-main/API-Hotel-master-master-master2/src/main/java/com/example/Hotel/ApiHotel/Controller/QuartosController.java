package com.example.Hotel.ApiHotel.Controller;//package com.example.Hotel.ApiHotel.Controller;


import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.DTO.QuartosDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import com.example.Hotel.ApiHotel.DTO.HoteisDTO;
import com.example.Hotel.ApiHotel.Models.QuartosDAO;
import com.example.Hotel.ApiHotel.repository.QuartosRepository;
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
public class QuartosController {

    @Autowired
    private QuartosRepository quartosRepository;
    public List<QuartosDTO>quartoList = new ArrayList<QuartosDTO>();
    public HashMap<Integer, QuartosDTO> quarto = new HashMap<Integer, QuartosDTO>();


    @PostMapping("/quartos")
    public ResponseEntity<QuartosDTO> addQuarto (@RequestBody @Valid QuartosDTO q){
        QuartosDAO quartoPersisted = quartosRepository.save(q.toDAO());
        String tamanhoLista = String.valueOf(quarto.size());
        return new ResponseEntity<QuartosDTO>(quartoPersisted.toDTO(), HttpStatus.CREATED);
    }



    @GetMapping("/quartos")
    public ResponseEntity<List<QuartosDTO>> getQuartos(){
        return ResponseEntity.ok().body(quartosRepository.findAll()
                .stream()
                .map(quartosDAO -> quartosDAO.toDTO())
                .collect(Collectors.toList()));
    }


    @GetMapping ("/quartos/{id}")
    public ResponseEntity<QuartosDTO> getIdQuartos (@PathVariable("id") Long id){
        Optional<QuartosDAO> quarto = quartosRepository.findById(id);
        if (quarto.isPresent()){
            return new ResponseEntity<QuartosDTO>(quarto.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping ("/quartos/{id}/deletar")
    public ResponseEntity<QuartosDTO> deletarQuarto(@PathVariable("id") Long id){
        QuartosDAO quarto = new QuartosDAO();
        quarto.setIdQuarto(id);
        quartosRepository.delete(quarto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/quartos/{id}/atualizar")
    public ResponseEntity<QuartosDTO> atualizeQuarto(@PathVariable("id") Long id, @RequestBody QuartosDTO q){
        q.setIdQuarto(id);
        System.out.println("");
        QuartosDAO quartosatualiza = quartosRepository.save(q.toDAO());
        return new ResponseEntity<QuartosDTO>(quartosatualiza.toDTO(), HttpStatus.OK);
    }


}
