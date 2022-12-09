package com.example.demo.DemoApplication.security;

import com.example.demo.DemoApplication.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
public class PersonDetails implements UserDetails {
    private final Person person2;

    public PersonDetails(Person person2) {
        this.person2 = person2;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(person2.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person2.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person2.getUsername();
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
    public Person getPerson() {
        return this.person2;
    }
}
