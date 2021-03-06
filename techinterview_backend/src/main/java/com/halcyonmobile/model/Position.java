package com.halcyonmobile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "position")
public class Position {
	
	@Id
    @Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nrQue")
	private int nrQue;

	public Position() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getnrQue() {
		return nrQue;
	}

	public void setnrQue(int nrQue) {
		this.nrQue = nrQue;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]" + ", nrQue=" + nrQue + "]";
	}
}
