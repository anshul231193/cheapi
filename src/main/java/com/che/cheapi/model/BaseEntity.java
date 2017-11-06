package com.che.cheapi.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

	 protected static final long serialVersionUID = 1L;

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    public BaseEntity() {
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        BaseEntity that = (BaseEntity) o;

	        return id == that.id;
	    }

	    @Override
	    public int hashCode() {
	        return (int) (id ^ (id >>> 32));
	    }
}
