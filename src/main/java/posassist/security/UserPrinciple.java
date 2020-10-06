package posassist.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import posassist.entities.User;

@Getter
@Setter
public class UserPrinciple implements UserDetails{
	private static final long serialVersionUID = -7979624377992706818L;
    private Long id;
    
    private String name;
    
    private String userName;
    
    private String emailId;

    @JsonIgnore
    private String password;
    
    private Collection<? extends GrantedAuthority> authorities;
    
    public UserPrinciple(Long id, String name, String userName, 
            String emailId, String password, 
            Collection<? extends GrantedAuthority> authorities) {
			this.id = id;
			this.name = name;
			this.userName = userName;
			this.emailId = emailId;
			this.password = password;
			this.authorities = authorities;
    	}
    
    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRole().stream().map(role ->
                new SimpleGrantedAuthority(role.getRole().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getName(),
                user.getEmailId(),
                user.getPassword(),
                user.getUserName(),
                authorities
        );
    }
    
    @Override
    public String getUsername() {
        return userName;
    }
    
    
    public String getEmailId() {
    	return emailId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
