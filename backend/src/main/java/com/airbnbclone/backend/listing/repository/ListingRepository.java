package com.airbnbclone.backend.listing.repository;

import com.airbnbclone.backend.listing.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {}
