package com.service.hotelService.hotel.infrastructure.outputadapter;

import com.service.hotelService.common.infrastructure.annotation.PersistenceAdapter;
import com.service.hotelService.hotel.application.ports.output.*;
import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import com.service.hotelService.hotel.infrastructure.outputadapter.persistence.entity.HotelDBEntity;
import com.service.hotelService.hotel.infrastructure.outputadapter.persistence.mapper.HotelMapper;
import com.service.hotelService.hotel.infrastructure.outputadapter.persistence.repository.HotelDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class HotelRepositoryOutputAdapter implements FindingAllHotelsOutputPort, SaveHotelOutputPort,
        FindHotelByIdOutputPort, UpdateHotelOutputPort, DeleteHotelOutputPort {

    private final HotelDBRepository hotelDBRepository;
    private final HotelMapper hotelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<HotelDomainEntity> findAllHotels() {
        return hotelDBRepository.findAll().stream()
                .map(hotelMapper::toDomain).toList();
    }

    @Override
    @Transactional
    public HotelDomainEntity save(HotelDomainEntity hotel) {
        HotelDBEntity entity = new HotelDBEntity();
        entity.setName(hotel.getName());
        entity.setAddress(hotel.getAddress());
        entity.setPhone(hotel.getPhone());
        HotelDBEntity saved = hotelDBRepository.save(entity);
        return hotelMapper.toDomain(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public HotelDomainEntity findById(UUID id) {
        return hotelDBRepository.findById(id).map(hotelMapper::toDomain).orElseThrow();
    }

    @Override
    @Transactional
    public HotelDomainEntity update(UUID id, HotelDomainEntity hotel) {
        HotelDBEntity existing = hotelDBRepository.findById(id).orElseThrow();
        existing.setName(hotel.getName());
        existing.setAddress(hotel.getAddress());
        existing.setPhone(hotel.getPhone());
        HotelDBEntity updated = hotelDBRepository.save(existing);
        return hotelMapper.toDomain(updated);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        hotelDBRepository.deleteById(id);
    }
}
