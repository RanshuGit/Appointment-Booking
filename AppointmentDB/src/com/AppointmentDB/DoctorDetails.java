package com.AppointmentDB;

public class DoctorDetails {
        int dId;
        String dName;
        String dSpeciality;
        String dDays;
        int dSlots;

    public DoctorDetails() {
    }

    public DoctorDetails(int dId, String dName, String dSpeciality, String dDays, int dSlots) {
        this.dId = dId;
        this.dName = dName;
        this.dSpeciality = dSpeciality;
        this.dDays = dDays;
        this.dSlots = dSlots;
    }

    public int getdId() {
        return dId;
    }

    public String getdName() {
        return dName;
    }

    public String getdSpeciality() {
        return dSpeciality;
    }

    public void setdSpeciality(String dSpeciality) {
        this.dSpeciality = dSpeciality;
    }

    public String getdDays() {
        return dDays;
    }

    public void setdDays(String dDays) {
        this.dDays = dDays;
    }

    public int getdSlots() {
        return dSlots;
    }

    public void setdSlots(int dSlots) {
        this.dSlots = dSlots;
    }

    @Override
    public String toString() {
        return "DoctorDetails{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dSpeciality='" + dSpeciality + '\'' +
                ", dDay='" + dDays + '\'' +
                ", dSlots=" + dSlots +
                '}';
    }
}
