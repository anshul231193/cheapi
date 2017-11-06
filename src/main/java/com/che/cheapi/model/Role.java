package com.che.cheapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="roles")
public class Role extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

    @NotNull
    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles") // cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    @JsonIgnore
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(long id, String name) {
        this.setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
