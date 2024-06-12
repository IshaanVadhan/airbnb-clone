package com.airbnbclone.backend.listing.domain;

import com.airbnbclone.backend.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "listing_picture")
public class ListingPicture extends AbstractAuditingEntity<Long> {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "listingPictureSequenceGenerator"
  )
  @SequenceGenerator(
    name = "listingPictureSequenceGenerator",
    sequenceName = "listing_picture_generator",
    allocationSize = 1
  )
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "listing_fk", referencedColumnName = "id")
  private Listing listing;

  @Lob
  @Column(name = "file", nullable = false)
  private byte[] file;

  @Column(name = "file_content_type")
  private String fileContentType;

  @Column(name = "is_cover")
  private boolean isCover;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Listing getListing() {
    return listing;
  }

  public void setListing(Listing listing) {
    this.listing = listing;
  }

  public byte[] getFile() {
    return file;
  }

  public void setFile(byte[] file) {
    this.file = file;
  }

  public String getFileContentType() {
    return fileContentType;
  }

  public void setFileContentType(String fileContentType) {
    this.fileContentType = fileContentType;
  }

  public boolean isCover() {
    return isCover;
  }

  public void setCover(boolean isCover) {
    this.isCover = isCover;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(file);
    result =
      prime *
      result +
      ((fileContentType == null) ? 0 : fileContentType.hashCode());
    result = prime * result + (isCover ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ListingPicture other = (ListingPicture) obj;
    if (!Arrays.equals(file, other.file)) return false;
    if (fileContentType == null) {
      if (other.fileContentType != null) return false;
    } else if (!fileContentType.equals(other.fileContentType)) return false;
    if (isCover != other.isCover) return false;
    return true;
  }

  @Override
  public String toString() {
    return (
      "ListingPicture [id=" +
      id +
      ", listing=" +
      listing +
      ", file=" +
      Arrays.toString(file) +
      ", fileContentType=" +
      fileContentType +
      ", isCover=" +
      isCover +
      "]"
    );
  }
}
