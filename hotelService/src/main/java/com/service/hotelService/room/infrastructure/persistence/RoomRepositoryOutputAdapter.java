package com.service.hotelService.room.infrastructure.persistence;

import com.service.hotelService.common.infrastructure.annotation.PersistenceAdapter;
import com.service.hotelService.hotel.infrastructure.outputadapter.persistence.repository.HotelDBRepository;
import com.service.hotelService.room.application.ports.output.*;
import com.service.hotelService.room.domain.model.RoomDomainEntity;
import com.service.hotelService.room.infrastructure.persistence.entity.RoomDBEntity;
import com.service.hotelService.room.infrastructure.persistence.mapper.RoomMapper;
import com.service.hotelService.room.infrastructure.persistence.repository.RoomDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class RoomRepositoryOutputAdapter implements CountingRoomByHotelOutputPort, SaveRoomOutputPort,
        FindRoomByIdOutputPort, FindAllRoomsOutputPort, UpdateRoomOutputPort, DeleteRoomOutputPort {

    private final RoomDBRepository roomDBRepository;
    private final HotelDBRepository hotelDBRepository; // to set hotel relationship if needed

    @Override
    public int countRoomByHotel(UUID hotelId) {
        return roomDBRepository.countByHotel_Id(hotelId);
    }

    @Override
    @Transactional
    public RoomDomainEntity save(RoomDomainEntity room) {
        RoomDBEntity e = RoomMapper.toDB(room);
        if (room.getHotelId() != null) {
            hotelDBRepository.findById(room.getHotelId()).ifPresent(e::setHotel);
        }
        RoomDBEntity saved = roomDBRepository.save(e);
        return RoomMapper.toDomain(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public RoomDomainEntity findById(UUID id) {
        return roomDBRepository.findById(id).map(RoomMapper::toDomain).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoomDomainEntity> findAll() {
        return roomDBRepository.findAll().stream().map(RoomMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RoomDomainEntity update(UUID id, RoomDomainEntity room) {
        RoomDBEntity existing = roomDBRepository.findById(id).orElseThrow();
        existing.setRoomNumber(room.getRoomNumber());
        existing.setPricePerDay(room.getPricePerDay());
        existing.setCostMaintenancePerDay(room.getMaintenanceCostPerDay());
        existing.setDescription(room.getDescription());
        existing.setCapacity(room.getCapacity());
        existing.setState(room.getState());
        RoomDBEntity updated = roomDBRepository.save(existing);
        return RoomMapper.toDomain(updated);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        roomDBRepository.deleteById(id);
    }
}
