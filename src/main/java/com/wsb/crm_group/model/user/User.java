package com.wsb.crm_group.model.user;

import com.wsb.crm_group.model.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "app_user",
        uniqueConstraints = {
                @UniqueConstraint(name = "app_user_email_unique", columnNames = "email"),
                }
)
public class User implements UserDetails {

  @Id
  @SequenceGenerator(
          name = "app_user_sequence",
          sequenceName = "app_user_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "app_user_sequence"
  )
  @Column(
          name = "id",
          updatable = false
  )
  private Integer id;

//  @Column(
//          name = "first_name",
//          nullable = false,
//          columnDefinition = "TEXT"
//  )
  private String firstname;

//  @Column(
//          name = "last_name",
//          nullable = false,
//          columnDefinition = "TEXT"
//  )
  private String lastname;

  @Column(
          name = "email",
          nullable = false,
          columnDefinition = "TEXT"
  )
  private String email;

  @Column(
          name = "password",
          nullable = false
  )
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(
          name = "role",
          nullable = false
  )
  private Role role;

  @OneToMany(mappedBy = "user")
  @Column(
          name = "tokens",
          nullable = false
  )
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
