package com.example.Hotel.ApiHotel.repository;
import com.example.Hotel.ApiHotel.Models.CheckDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends  JpaRepository<CheckDAO, Long> {

}
