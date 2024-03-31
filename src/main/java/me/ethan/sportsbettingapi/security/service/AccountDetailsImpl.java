package me.ethan.sportsbettingapi.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import me.ethan.sportsbettingapi.models.auth.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

public class AccountDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Getter
    private final UUID id;

    private final String username;

    @JsonIgnore
    private final String password;

    public AccountDetailsImpl(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static AccountDetailsImpl build(Account account) {
        return new AccountDetailsImpl(account.getId(),
                account.getUsername(),
                account.getPassword());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AccountDetailsImpl user = (AccountDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
