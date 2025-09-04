package com.service.hotelService.room.infrastructure.persistence.entity;

import com.service.hotelService.hotel.infrastructure.outputadapter.persistence.entity.HotelDBEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "room")
@Table(name = "room", schema = "hotel")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class RoomDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String roomNumber;

    @NonNull
    @Column(nullable = false)
    private BigDecimal pricePerDay;

    @NonNull
    @Column(nullable = false)
    private BigDecimal costMaintenancePerDay;

    @NonNull
    @Column(nullable = false)
    private String description;

    @NonNull
    @Column(nullable = false)
    private Integer capacity;

    @NonNull
    @Column(nullable = false)
    private String state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hotel_id")
    private HotelDBEntity hotel;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;


}
