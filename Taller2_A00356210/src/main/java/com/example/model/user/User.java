package com.example.model.user;


import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user_table")
public class User implements UserDetails {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String username;
    private String password;
	@Enumerated(EnumType.STRING)
	private UserType role;

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(roles.toString()));
        return roles;
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
    public void setPassword(String pass) {
		password = password;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public void setUserName(String name) {
		username = name;
	}
	@Override
	public String getUsername() {
		return username;
	}
}