package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.CheckDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Checks")
public class CheckDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCheck;
    @JoinColumn(name = "idreserva")
    private Long idReserva;
    @OneToOne
    @JoinColumn(name = "idCliente")
    private ClientDAO idCliente;

    private String horarioCheckIn;
    private String horarioCheckOut;
    private int quantCart;
    //   @OneToOne(mappedBy = "checkOut")
    // private List<CheckDAO> checkout= new ArrayList<>();

    private boolean ative;

    public CheckDTO toDTO(){
        return CheckDTO
                .builder()
                .idCheck(idCheck)
                .idReserva(idReserva)
                .idCliente(idCliente)
                .horarioCheckIn(horarioCheckIn)
                .horarioCheckOut(horarioCheckOut)
                .quantCart(quantCart)
                .ative(ative)
                .build();
    }

    public boolean fazerCheckIn(){
        return  this.ative = true;

    }
    public boolean fazerCheckOut(){
        return this.ative = false;

    }

}