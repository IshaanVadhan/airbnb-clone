package com.airbnbclone.backend.listing.domain;

import com.airbnbclone.backend.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "listing")
public class Listing extends AbstractAuditingEntity<Long> {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "listingSequenceGenerator"
  )
  @SequenceGenerator(
    name = "listingSequenceGenerator",
    sequenceName = "listing_generator",
    allocationSize = 1
  )
  @Column(name = "id")
  private Long id;

  @UuidGenerator
  @Column(name = "public_id", nullable = false)
  private UUID publicId;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "guests")
  private int guests;

  @Column(name = "bedrooms")
  private int bedrooms;

  @Column(name = "beds")
  private int beds;

  @Column(name = "bathrooms")
  private int bathrooms;

  @Column(name = "price")
  private int price;

  @Enumerated(EnumType.STRING)
  @Column(name = "category")
  private BookingCategory bookingCategory;

  @Column(name = "location")
  private String location;

  @Column(name = "landlord_public_id")
  private UUID landlordPublicId;

  @OneToMany(mappedBy = "listing", cascade = CascadeType.REMOVE)
  private Set<ListingPicture> pictures = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UUID getPublicId() {
    return publicId;
  }

  public void setPublicId(UUID publicId) {
    this.publicId = publicId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getGuests() {
    return guests;
  }

  public void setGuests(int guests) {
    this.guests = guests;
  }

  public int getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(int bedrooms) {
    this.bedrooms = bedrooms;
  }

  public int getBeds() {
    return beds;
  }

  public void setBeds(int beds) {
    this.beds = beds;
  }

  public int getBathrooms() {
    return bathrooms;
  }

  public void setBathrooms(int bathrooms) {
    this.bathrooms = bathrooms;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public BookingCategory getBookingCategory() {
    return bookingCategory;
  }

  public void setBookingCategory(BookingCategory bookingCategory) {
    this.bookingCategory = bookingCategory;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public UUID getLandlordPublicId() {
    return landlordPublicId;
  }

  public void setLandlordPublicId(UUID landlordPublicId) {
    this.landlordPublicId = landlordPublicId;
  }

  public Set<ListingPicture> getPictures() {
    return pictures;
  }

  public void setPictures(Set<ListingPicture> pictures) {
    this.pictures = pictures;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((publicId == null) ? 0 : publicId.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result =
      prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + guests;
    result = prime * result + bedrooms;
    result = prime * result + beds;
    result = prime * result + bathrooms;
    result = prime * result + price;
    result =
      prime *
      result +
      ((bookingCategory == null) ? 0 : bookingCategory.hashCode());
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result =
      prime *
      result +
      ((landlordPublicId == null) ? 0 : landlordPublicId.hashCode());
    result = prime * result + ((pictures == null) ? 0 : pictures.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Listing other = (Listing) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (publicId == null) {
      if (other.publicId != null) return false;
    } else if (!publicId.equals(other.publicId)) return false;
    if (title == null) {
      if (other.title != null) return false;
    } else if (!title.equals(other.title)) return false;
    if (description == null) {
      if (other.description != null) return false;
    } else if (!description.equals(other.description)) return false;
    if (guests != other.guests) return false;
    if (bedrooms != other.bedrooms) return false;
    if (beds != other.beds) return false;
    if (bathrooms != other.bathrooms) return false;
    if (price != other.price) return false;
    if (bookingCategory != other.bookingCategory) return false;
    if (location == null) {
      if (other.location != null) return false;
    } else if (!location.equals(other.location)) return false;
    if (landlordPublicId == null) {
      if (other.landlordPublicId != null) return false;
    } else if (!landlordPublicId.equals(other.landlordPublicId)) return false;
    if (pictures == null) {
      if (other.pictures != null) return false;
    } else if (!pictures.equals(other.pictures)) return false;
    return true;
  }

  @Override
  public String toString() {
    return (
      "Listing [id=" +
      id +
      ", publicId=" +
      publicId +
      ", title=" +
      title +
      ", description=" +
      description +
      ", guests=" +
      guests +
      ", bedrooms=" +
      bedrooms +
      ", beds=" +
      beds +
      ", bathrooms=" +
      bathrooms +
      ", price=" +
      price +
      ", bookingCategory=" +
      bookingCategory +
      ", location=" +
      location +
      ", landlordPublicId=" +
      landlordPublicId +
      ", pictures=" +
      pictures +
      "]"
    );
  }
}
