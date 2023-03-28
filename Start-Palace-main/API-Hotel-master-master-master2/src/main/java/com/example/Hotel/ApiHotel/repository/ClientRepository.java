package com.example.Hotel.ApiHotel.repository;

import com.example.Hotel.ApiHotel.Models.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends
        JpaRepository<ClientDAO, Long> {

}