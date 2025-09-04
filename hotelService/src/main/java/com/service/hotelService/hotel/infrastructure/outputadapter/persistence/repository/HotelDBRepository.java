package com.service.hotelService.hotel.infrastructure.outputadapter.persistence.repository;

import com.service.hotelService.hotel.infrastructure.outputadapter.persistence.entity.HotelDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelDBRepository extends JpaRepository<HotelDBEntity, UUID> {
}
