/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.model;

import com.wpj.domain.UserMsg;
import com.wpj.domain.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SecurityUser extends UserMsg implements UserDetails
{

	private static final long serialVersionUID = 1L;

	public SecurityUser(UserMsg userMsg) {
        if(userMsg != null)
		{
			this.setId(userMsg.getId());
			this.setUserName(userMsg.getUserName());
			this.setUserEmail(userMsg.getUserEmail());
			this.setUserPwd(userMsg.getUserPwd());
			this.setUserMotto(userMsg.getUserMotto());
			this.setUserActivity(userMsg.getUserActivity());
			this.setUserLastLogin(userMsg.getUserLastLogin());
			this.setId(userMsg.getId());
		}
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<UserRole> userRoles = this.getUserRoleSet();
		
		if(userRoles != null)
		{
			for (UserRole role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getUserPwd();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
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
