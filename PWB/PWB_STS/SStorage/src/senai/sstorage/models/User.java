package senai.sstorage.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import senai.sstorage.utils.PasswordUtils;

@Entity
@Table(name = "user")
public class User implements Authentication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false, unique = false)
	@NotNull
	@Size(min = 1, max = 20)
	private String firstName;
	
	@Column(length = 40, nullable = false, unique = false)
	@NotNull
	@Size(min = 1, max = 40)
	private String lastName;
	
	@Column(length = 64, nullable = false, unique = true)
	@NotNull
	@Email
	private String email;
	
	@Column(length = 32, nullable = false, unique = false)
	@NotNull
	@Size(min = 6, max = 32)
	private String password;
	
	@NotNull
	private UserType type;

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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@JsonIgnore
	public boolean isAdministrator() {
		return type == UserType.ADMINISTRATOR;
	}
	
	public void hashPassword() {
		this.password = PasswordUtils.hashString(this.password);
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@JsonIgnore
	@Override
	public Object getCredentials() {
		return null;
	}

	@JsonIgnore
	@Override
	public Object getDetails() {
		return null;
	}

	@JsonIgnore
	@Override
	public Object getPrincipal() {
		return this;
	}

	@JsonIgnore
	@Override
	public boolean isAuthenticated() {
		return true;
	}

	@JsonIgnore
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// Nothing here
	}

	@JsonIgnore
	@Override
	public String getName() {
		return email;
	}

}
