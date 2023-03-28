package com.example.Hotel.ApiHotel.Models;


import com.example.Hotel.ApiHotel.DTO.HoteisDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Hotel")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class HoteisDAO {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private int idEndereco;
    private String localizacao;
    private int quantidadeQuarto;
    private double pagamento;
    private  String infoPagamento;
    private String infoOperacinal;

    public HoteisDTO toDTO (){

        return HoteisDTO.builder()
                .id(id)
                .nome(nome)
                .idEndereco(idEndereco)
                .localizacao(localizacao)
                .quatidadeQuarto(quantidadeQuarto)
                .pagamento(pagamento)
                .infoPagamento(infoPagamento)
                .infoOperacinal(infoOperacinal)
                .build();
    }




}
