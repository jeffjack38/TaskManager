/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Sep 20, 2023
 */
package model;

public class Task {
	//set variables
    private int id;
    private String title;
    private String description;
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