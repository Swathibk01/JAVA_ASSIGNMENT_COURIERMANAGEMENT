package com.hexaware.entity;

import java.util.ArrayList;
import java.util.List;

public class CourierCompanyCollection {
    private List<CourierCompany> companies;

    public CourierCompanyCollection() {
        companies = new ArrayList<>();
    }

    public List<CourierCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CourierCompany> companies) {
        this.companies = companies;
    }

    public void addCourierCompany(CourierCompany company) {
        companies.add(company);
    }

    public CourierCompany getCompanyByName(String companyName) {
        for (CourierCompany company : companies) {
            
			if (company.getCompanyName() == companyName) {
                return company;
            }
        }
        return null; // If the company ID is not found
    }

    
}
