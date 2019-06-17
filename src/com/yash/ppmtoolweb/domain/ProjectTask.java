package com.yash.ppmtoolweb.domain;

import java.util.Date;

public class ProjectTask {

	
	private int id;
	private String acceptance_criteria;
	private Date created_at;
	private Date due_date;
	private String priority;
	private String project_identifier;
	private String project_sequence;
	private String status;
	private String summary;
	private Date updated_at;
	private int backlog_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcceptance_criteria() {
		return acceptance_criteria;
	}
	public void setAcceptance_criteria(String acceptance_criteria) {
		this.acceptance_criteria = acceptance_criteria;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getProject_identifier() {
		return project_identifier;
	}
	public void setProject_identifier(String project_identifier) {
		this.project_identifier = project_identifier;
	}
	public String getProject_sequence() {
		return project_sequence;
	}
	public void setProject_sequence(String project_sequence) {
		this.project_sequence = project_sequence;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public int getBacklog_id() {
		return backlog_id;
	}
	public void setBacklog_id(int backlog_id) {
		this.backlog_id = backlog_id;
	}
	
	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", acceptance_criteria=" + acceptance_criteria + ", created_at=" + created_at
				+ ", due_date=" + due_date + ", priority=" + priority + ", project_identifier=" + project_identifier
				+ ", project_sequence=" + project_sequence + ", status=" + status + ", summary=" + summary
				+ ", updated_at=" + updated_at + ", backlog_id=" + backlog_id + "]";
	} 
	
	
	
}
