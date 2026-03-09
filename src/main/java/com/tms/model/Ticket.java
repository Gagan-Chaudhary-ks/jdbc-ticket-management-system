package com.tms.model;

public class Ticket {
    private int ticketId;
    private String title;
    private String description;
    private int createdBy;
    private int assignedTo;
    private String status;
    private String priority;
    private String createdAt;
    private String updatedAt;

    public Ticket(){

    }

    public Ticket (int ticketId,String title,String description, int createdBy, int assignedTo, String status, String priority, String createdAt, String updatedAt){
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getTicketId(){
        return ticketId;
    }

    public void setTicketId(int ticketId){
        this.ticketId = ticketId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatedBy(){
        return createdBy;
    }

    public void setCreatedBy(int createdBy){
        this.createdBy = createdBy;
    }

    public int getAssignedTo(){
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo){
        this.assignedTo = assignedTo;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getPriority(){
        return priority;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", assignedTo=" + assignedTo +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
