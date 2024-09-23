package org.senechka.lab1.models;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User implements UserDetails {

    @PrimaryKey
    private UUID id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private Roles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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