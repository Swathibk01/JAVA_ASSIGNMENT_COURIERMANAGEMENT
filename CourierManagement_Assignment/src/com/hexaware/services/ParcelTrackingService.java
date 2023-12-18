package com.hexaware.services;

import com.hexaware.dao.ParcelTrackingDAO;
import com.hexaware.entity.TrackingHistoryEntry;

public class ParcelTrackingService {
    private ParcelTrackingDAO parcelTrackingDAO;

    public ParcelTrackingService() {
        this.parcelTrackingDAO = new ParcelTrackingDAO();
    }

    public boolean addTrackingHistory(TrackingHistoryEntry[] trackingHistory) {
        return parcelTrackingDAO.addTrackingHistory(trackingHistory);
    }
}