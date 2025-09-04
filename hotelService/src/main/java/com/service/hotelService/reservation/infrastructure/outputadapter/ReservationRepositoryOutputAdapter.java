
package com.service.hotelService.reservation.infrastructure.outputadapter;

import com.service.hotelService.common.infrastructure.annotation.PersistenceAdapter;
import com.service.hotelService.reservation.application.ports.output.*;
import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import com.service.hotelService.reservation.infrastructure.outputadapter.persistence.entity.ReservationDBEntity;
import com.service.hotelService.reservation.infrastructure.outputadapter.persistence.mapper.ReservationMapper;
import com.service.hotelService.reservation.infrastructure.outputadapter.persistence.repository.ReservationDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Transactional
public class ReservationRepositoryOutputAdapter implements SaveReservationOutputPort, UpdateReservationOutputPort,
        DeleteReservationOutputPort,
        FindReservationByIdOutputPort,
        FindReservationsByRoomOutputPort,
        CheckAvailabilityOutputPort,
        FindReservationsByCustomerOutputPort,
        FindAllReservationsOutputPort
{
    private final ReservationDBRepository repository;

    @Override
    public ReservationDomainEntity save(ReservationDomainEntity reservation) {
        ReservationDBEntity saved = repository.save(ReservationMapper.toDB(reservation));
        return ReservationMapper.toDomain(saved);
    }

    @Override
    public ReservationDomainEntity update(UUID id, ReservationDomainEntity reservation) {
        ReservationDBEntity existing = repository.findById(id).orElseThrow();
        ReservationDBEntity updated = ReservationMapper.toDB(reservation);
        updated.setId(existing.getId());
        updated.setCreatedAt(existing.getCreatedAt());
        updated.setUpdatedAt(LocalDateTime.now());
        return ReservationMapper.toDomain(repository.save(updated));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public ReservationDomainEntity findById(UUID id) {
        return repository.findById(id).map(ReservationMapper::toDomain).orElseThrow();
    }

    @Override
    public List<ReservationDomainEntity> findByRoom(UUID roomId) {
        return repository.findByRoomId(roomId).stream().map(ReservationMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean isAvailable(UUID roomId, java.time.LocalDate startDate, java.time.LocalDate endDate) {
        return !repository.existsOverlap(roomId, startDate, endDate);
    }

    @Override
    public List<ReservationDomainEntity> findByCustomerId(UUID customerId) {
        return repository.findByCustomerId(customerId)
                .stream()
                .map(ReservationMapper::toDomain)
                .toList();
    }

    @Override
    public List<ReservationDomainEntity> findAll() {
        return repository.findAll()
                .stream()
                .map(ReservationMapper::toDomain)
                .toList();
    }
}
