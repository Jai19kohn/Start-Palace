package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
    private Long id;

    private EnderecoDTO endereco;
    
    private String senha;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String aniversario;



  public ClientDAO toDAO(){
        return ClientDAO
                .builder()
                .id(id)
                .endereco(endereco.toDAO())
                .senha(senha)
                .nome(nome)
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .build();
    }  
}


