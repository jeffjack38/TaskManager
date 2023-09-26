/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Sep 20, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	//set variables
	@Id
	@GeneratedValue
	@Column(name="ID")
    private int id;
	@Column(name="TITLE")
    private String title;
	@Column(name="DESCRIPTION")
    private String description;
	@Column(name="STATUS")
    private String status;
    
    
    //no arg constructor
    public Task() {
    	super();
    }

    //constructor
    public Task(int id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }
    
    public Task(String title, String description, String status) {
    	this.title = title;
        this.description = description;
        this.status = status;
    }
    
    // Getters and setters
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}