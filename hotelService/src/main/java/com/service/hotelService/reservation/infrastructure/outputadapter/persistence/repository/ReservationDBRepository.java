
package com.service.hotelService.reservation.infrastructure.outputadapter.persistence.repository;

import com.service.hotelService.reservation.infrastructure.outputadapter.persistence.entity.ReservationDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ReservationDBRepository extends JpaRepository<ReservationDBEntity, UUID> {

    List<ReservationDBEntity> findByRoomId(UUID roomId);
    List<ReservationDBEntity> findByCustomerId(UUID customerId);

    @Query("""
        SELECT CASE WHEN COUNT(r)>0 THEN TRUE ELSE FALSE END
        FROM ReservationDBEntity r
        WHERE r.roomId = :roomId
          AND r.state <> 'cancelled'
          AND r.startDate < :endDate
          AND r.endDate > :startDate
    """)
    boolean existsOverlap(@Param("roomId") UUID roomId,
                          @Param("startDate") LocalDate startDate,
                          @Param("endDate") LocalDate endDate);
}
