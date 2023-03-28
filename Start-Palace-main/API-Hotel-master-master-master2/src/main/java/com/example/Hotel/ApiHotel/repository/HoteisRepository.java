package com.example.Hotel.ApiHotel.repository;

import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoteisRepository extends
        JpaRepository<HoteisDAO, Long> {


}
