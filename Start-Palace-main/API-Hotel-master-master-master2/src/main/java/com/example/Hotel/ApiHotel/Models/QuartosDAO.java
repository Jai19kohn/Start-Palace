package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.QuartosDTO;
import jakarta.persistence.*;
import lombok.*;



@Entity(name = "Quartos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class QuartosDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idQuarto;


    private int numeQuarto;
    private Float preco;
    private String suites;

    private String servQuarto;
    private String quantmax;

    public QuartosDTO toDTO (){
        return QuartosDTO.builder()
                .idQuarto(idQuarto)
                .numeQuarto(numeQuarto)
                .preco(preco)
                .suites(suites)
                .servQuarto(servQuarto)
                .quantmax(quantmax)
                .build();
    }

}
