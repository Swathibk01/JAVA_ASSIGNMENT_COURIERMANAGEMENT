package com.hexaware.entity;



import java.time.LocalDateTime;

public class TrackingHistoryEntry {
    private LocalDateTime dateTime;
    private String location;
    private String status;

    @Override
	public String toString() {
		return "TrackingHistoryEntry [dateTime=" + dateTime + ", location=" + location + ", status=" + status + "]";
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TrackingHistoryEntry(LocalDateTime dateTime, String location, String status) {
        this.dateTime = dateTime;
        this.location = location;
        this.status = status;
    }

    // Getters and Setters
    // ...
}
