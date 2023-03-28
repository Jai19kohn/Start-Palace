package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.CheckDAO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckDTO {

    private Long idCheck;
    private Long idReserva;

    private ClientDAO idCliente;
    private String horarioCheckIn;
    private String horarioCheckOut;
    private int quantCart;

    private boolean ative;

    public CheckDAO toDAO(){
        return CheckDAO
                .builder()
                .idCheck(idCheck)
                .idReserva(idReserva)
                .idCliente(idCliente)
                .horarioCheckIn(horarioCheckIn)
                .horarioCheckOut(horarioCheckOut)
                .quantCart(quantCart)
                .ative(true)
                .build();
    }

    public boolean fazerCheckIn(){
        return  this.ative = true;

    }
    public boolean fazerCheckOut(){
        return this.ative = false;

    }

    public CheckDTO( CheckDAO horizontePlanejamento){
        idCheck = getIdCheck();
        idReserva = getIdReserva();
        idCliente = getIdCliente();
        horarioCheckIn = getHorarioCheckIn();
        horarioCheckOut = getHorarioCheckOut();
        quantCart = getQuantCart();
    }
}