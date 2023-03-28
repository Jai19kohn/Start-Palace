package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.DTO.EnderecoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ClientDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JoinColumn(name = "idCliente")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco")
    private EnderecoDAO endereco;
    private String senha;

    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String aniversario;

    public ClientDTO toDTO (){
        return ClientDTO.builder()
                .id(id)
                .senha(senha)
                .endereco(endereco.toDTO())
                .nome(nome)
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .build();
    }
}