package com.example.Hotel.ApiHotel.repository;


import com.example.Hotel.ApiHotel.Models.QuartosDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartosRepository extends
           JpaRepository<QuartosDAO, Long> {
}

