package com.airbnbclone.backend.booking.domain;

import com.airbnbclone.backend.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "booking")
public class Booking extends AbstractAuditingEntity<Long> {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "bookingSequenceGenerator"
  )
  @SequenceGenerator(
    name = "bookingSequenceGenerator",
    sequenceName = "booking_generator",
    allocationSize = 1
  )
  @Column(name = "id")
  private Long id;

  @UuidGenerator
  @Column(name = "public_id", nullable = false)
  private UUID publicId;

  @Column(name = "start_date", nullable = false)
  private OffsetDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private OffsetDateTime endDate;

  @Column(name = "total_price", nullable = false)
  private int totalPrice;

  @Column(name = "nb_of_travelers", nullable = false)
  private int numberofTravelers;

  @Column(name = "fk_tenant", nullable = false)
  private UUID fkTenant;

  @Column(name = "fk_listing", nullable = false)
  private UUID fkListing;

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

  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public int getNumberofTravelers() {
    return numberofTravelers;
  }

  public void setNumberofTravelers(int numberofTravelers) {
    this.numberofTravelers = numberofTravelers;
  }

  public UUID getFkTenant() {
    return fkTenant;
  }

  public void setFkTenant(UUID fkTenant) {
    this.fkTenant = fkTenant;
  }

  public UUID getFkListing() {
    return fkListing;
  }

  public void setFkListing(UUID fkListing) {
    this.fkListing = fkListing;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
    result = prime * result + totalPrice;
    result = prime * result + numberofTravelers;
    result = prime * result + ((fkTenant == null) ? 0 : fkTenant.hashCode());
    result = prime * result + ((fkListing == null) ? 0 : fkListing.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Booking other = (Booking) obj;
    if (startDate == null) {
      if (other.startDate != null) return false;
    } else if (!startDate.equals(other.startDate)) return false;
    if (endDate == null) {
      if (other.endDate != null) return false;
    } else if (!endDate.equals(other.endDate)) return false;
    if (totalPrice != other.totalPrice) return false;
    if (numberofTravelers != other.numberofTravelers) return false;
    if (fkTenant == null) {
      if (other.fkTenant != null) return false;
    } else if (!fkTenant.equals(other.fkTenant)) return false;
    if (fkListing == null) {
      if (other.fkListing != null) return false;
    } else if (!fkListing.equals(other.fkListing)) return false;
    return true;
  }

  @Override
  public String toString() {
    return (
      "Booking [id=" +
      id +
      ", publicId=" +
      publicId +
      ", startDate=" +
      startDate +
      ", endDate=" +
      endDate +
      ", totalPrice=" +
      totalPrice +
      ", numberofTravelers=" +
      numberofTravelers +
      ", fkTenant=" +
      fkTenant +
      ", fkListing=" +
      fkListing +
      "]"
    );
  }
}
