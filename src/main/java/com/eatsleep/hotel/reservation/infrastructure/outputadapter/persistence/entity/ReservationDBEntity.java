package com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.entity;

import com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.entity.HotelDBEntity;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.entity.RoomDBEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "reservation")
@Table(name = "reservation", schema = "reservation")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class ReservationDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private UUID customerId;

    @NonNull
    @Column(nullable = false)
    private LocalDate startDate;

    @NonNull
    @Column(nullable = false)
    private LocalDate endDate;

    @NonNull
    @Column(nullable = false)
    private String state;

    @NonNull
    @Column(nullable = false)
    private BigDecimal pricePerDay;

    @NonNull
    @Column(nullable = false)
    private BigDecimal totalPrice;

    @NonNull
    @Column(nullable = false)
    private BigDecimal maintenanceCostPerDay;

    @NonNull
    @Column(nullable = false)
    private BigDecimal totalCost;

    @NonNull
    @Column(nullable = true)
    private BigDecimal discountPercentage;

    @Column(nullable = true)
    private UUID promotionId;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    private RoomDBEntity room;

}
