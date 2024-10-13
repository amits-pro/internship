package com.bv.gms.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "grievance")
public class Grievance {
   
   @Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    
    @Column(name = "raised_by")
    @NotBlank(message="Enter user that raised grievance")
    private Integer raisedBy;

    @Column(name = "title")
    @NotBlank(message="Grievance title required")
    private String title;
    
    @Column(name = "description")
    @NotBlank(message="Description of grievance required")
    private String description;
    
    @Column(name = "grievance_type")
    @NotBlank(message="Type of Grievance required")
    private String grievanceType;

    @Column(name = "status")
    @NotBlank(message="Grievance status is mandatory")
    private String status;

    @Column(name = "priority")
    @NotBlank(message="Enter date on which grievance is raised")
    private String priority;    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(Integer raisedBy) {
		this.raisedBy = raisedBy;
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
	public String getGrievanceType() {
		return grievanceType;
	}
	public void setGrievanceType(String grievanceType) {
		this.grievanceType = grievanceType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Grievance(Integer raisedBy, String title,  String description, String type, 
			String status, String priority) {
		super();
		this.raisedBy = raisedBy;
		this.title = title;
		this.description = description;
		this.grievanceType = type;
		this.status = status;
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "Grievance [id=" + id + ", Description=" + description + ", Title=" + title
				+ ", Raised By=" + raisedBy + ", Status="
				+ status +  ", Priority=" + priority + "]";
	}
	
    
}
  
	