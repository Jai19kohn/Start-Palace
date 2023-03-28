package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.ReservaDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity(name = "Reserva")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ReservaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private Long idQuarto;
    private String dataInicio;
    private String dataFim;
    private int quantPes;
    private double preco;

    public ReservaDTO toDTO(){
        return ReservaDTO
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
