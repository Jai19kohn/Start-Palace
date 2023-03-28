package com.example.Hotel.ApiHotel.repository;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.EnderecoDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository
extends JpaRepository<EnderecoDAO, Long> {



}
