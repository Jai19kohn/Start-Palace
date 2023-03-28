package com.example.Hotel.ApiHotel.Models;

import  com.example.Hotel.ApiHotel.DTO.EnderecoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Endereco")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter


public class EnderecoDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idEndereco;

    private int numero;
    private String endereco;
    private String cidade;
    private String estado;
    private String pais;

    public  EnderecoDTO toDTO (){
        return EnderecoDTO.builder()
                .idEndereco(idEndereco)
                .numero(numero)
                .endereco(endereco)
                .cidade(cidade)
                .estado(estado)
                .pais(pais)
                .build();
    }


    public void setid() {
    }
}


