package com.airbnbclone.backend.booking.repository;

import com.airbnbclone.backend.booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {}
