package com.example.Hotel.ApiHotel.DTO;

import com.example.Hotel.ApiHotel.Models.QuartosDAO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class QuartosDTO {

    private Long idQuarto;

    private int numeQuarto;
   private float preco;
    private String suites;
    private String servQuarto;
    private String quantmax;


    public QuartosDAO toDAO(){
        return QuartosDAO
               .builder()
                .idQuarto(idQuarto)
                .numeQuarto(numeQuarto)
                .preco(preco)
                .suites(suites)
                .servQuarto(servQuarto)
                .quantmax(quantmax)
               .build();
    }

}
