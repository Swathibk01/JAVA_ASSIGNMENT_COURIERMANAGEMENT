package com.hexaware.dao;

import com.hexaware.entity.TrackingHistoryEntry;
import com.hexaware.util.DBPropertyUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ParcelTrackingDAO {
    public boolean addTrackingHistory(TrackingHistoryEntry[] trackingHistory) {
        String query = "INSERT INTO TrackingHistoryEntry (dateTime, location, status) VALUES (?, ?, ?)";
        try (Connection connection = DBPropertyUtil.getMyDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (TrackingHistoryEntry entry : trackingHistory) {
                preparedStatement.setObject(1, entry.getDateTime());
                preparedStatement.setString(2, entry.getLocation());
                preparedStatement.setString(3, entry.getStatus());
                preparedStatement.addBatch();
            }

            int[] rowsAffected = preparedStatement.executeBatch();

            // Check if all entries were successfully inserted
            for (int affected : rowsAffected) {
                if (affected <= 0) {
                    return false;
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}