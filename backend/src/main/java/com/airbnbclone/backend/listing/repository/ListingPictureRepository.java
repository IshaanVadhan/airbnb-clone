package com.airbnbclone.backend.listing.repository;

import com.airbnbclone.backend.listing.domain.ListingPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingPictureRepository
  extends JpaRepository<ListingPicture, Long> {}
