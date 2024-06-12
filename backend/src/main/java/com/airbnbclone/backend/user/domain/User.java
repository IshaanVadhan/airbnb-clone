package com.airbnbclone.backend.user.domain;

import com.airbnbclone.backend.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "airbnb_user")
public class User extends AbstractAuditingEntity<Long> {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "userSequenceGenerator"
  )
  @SequenceGenerator(
    name = "userSequenceGenerator",
    sequenceName = "user_generator",
    allocationSize = 1
  )
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "image_url")
  private String imageUrl;

  @UuidGenerator
  @Column(name = "public_id", nullable = false)
  private UUID publicId;

  @ManyToMany
  @JoinTable(
    name = "user_authority",
    joinColumns = {
      @JoinColumn(name = "user_id", referencedColumnName = "id"),
    },
    inverseJoinColumns = {
      @JoinColumn(name = "authority_name", referencedColumnName = "name"),
    }
  )
  private Set<Authority> authorities = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public UUID getPublicId() {
    return publicId;
  }

  public void setPublicId(UUID publicId) {
    this.publicId = publicId;
  }

  public Set<Authority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Set<Authority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
    result = prime * result + ((publicId == null) ? 0 : publicId.hashCode());
    result =
      prime * result + ((authorities == null) ? 0 : authorities.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    User other = (User) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (firstName == null) {
      if (other.firstName != null) return false;
    } else if (!firstName.equals(other.firstName)) return false;
    if (lastName == null) {
      if (other.lastName != null) return false;
    } else if (!lastName.equals(other.lastName)) return false;
    if (email == null) {
      if (other.email != null) return false;
    } else if (!email.equals(other.email)) return false;
    if (imageUrl == null) {
      if (other.imageUrl != null) return false;
    } else if (!imageUrl.equals(other.imageUrl)) return false;
    if (publicId == null) {
      if (other.publicId != null) return false;
    } else if (!publicId.equals(other.publicId)) return false;
    if (authorities == null) {
      if (other.authorities != null) return false;
    } else if (!authorities.equals(other.authorities)) return false;
    return true;
  }

  @Override
  public String toString() {
    return (
      "User [id=" +
      id +
      ", firstName=" +
      firstName +
      ", lastName=" +
      lastName +
      ", email=" +
      email +
      ", imageUrl=" +
      imageUrl +
      ", publicId=" +
      publicId +
      ", authorities=" +
      authorities +
      "]"
    );
  }
}
