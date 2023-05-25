package com.example.designmode.singleton;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Staff> allStaffs = new ArrayList<>();

    public void addStaff(Staff staff) {
        allStaffs.add(staff);
    }

    public void showAllStaffs() {
        for (Staff staff : allStaffs){
            System.out.println();
        }
    }
}
