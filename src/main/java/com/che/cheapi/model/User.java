package com.che.cheapi.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    @Column(unique=true)
    private String username;

    @NotNull
    @Column
    private String password;

    @Column
    private boolean enabled;

    @Column
    private String name;

    @Column(unique=true)
    private String skypeId;

	@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER) // cascade = {CascadeType.ALL}
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles;

    
    public User() {
    }

    public User(long id) {
        super();
    }

    public User(User user) {
        super();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.name = user.getName();
    }

    public User(String email, String username, String password, List<Role> roles) {
        this.email = email;
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.roles = roles;
    }

    public User(String email, String username, String password, boolean enabled, String fullname) {
        this.email = email;
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.enabled = enabled;
        this.name = fullname;
    }

    public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

    public String getName() {
        return name;
    }

    public void setName(String fullname) {
        this.name = fullname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}