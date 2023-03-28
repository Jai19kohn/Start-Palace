package com.example.Hotel.ApiHotel.DTO;

import com.example.Hotel.ApiHotel.Models.ReservaDAO;

import lombok.*;

import java.util.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDTO {
    private Long idReserva;
    private Long idQuarto;
    private String dataInicio;
    private String dataFim;
    private int quantPes;
    private double preco;

    public ReservaDAO toDAO(){
        return ReservaDAO
                .builder()
                .idReserva(idReserva)
                .idQuarto(idQuarto)
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .quantPes(quantPes)
                .preco(preco)
                .build();
    }


}
