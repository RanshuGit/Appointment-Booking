package com.AppointmentDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

interface AppointmentInterface {
    void addDoctor(DoctorDetails d);
    void viewDoctor();
    void updateDoctor(int ids, String spl, int choice, DoctorDetails dd, String avdd, int slot);
    void deleteDoctor(int dIds);
    void viewAppointment();
    void bookAppointment(AppointmentDetails ad);
}
class AppointmentClass implements AppointmentInterface {
    public void addDoctor(DoctorDetails d) {
        try{
            Connection con= DBConnection.createConnection();
            String query="insert into doctordb(did,dname,dspeciality,ddays,dslots) value(?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setInt(1,d.getdId());
            pst.setString(2,d.getdName());
            pst.setString(3,d.getdSpeciality());
            pst.setString(4,d.getdDays());
            pst.setInt(5,d.getdSlots());
            pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void viewDoctor() {
        try{
            Connection con=DBConnection.createConnection();
            String query="select * from doctordb";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s","ID","Name","Speciality","Days","Slots"+"\n");
            while(rs.next()){
                int docID = rs.getInt(1);
                String docName = rs.getString(2);
                String docSpeciality = rs.getString(3);
                String dayBooked = rs.getString(4);
                int slotBooked = rs.getInt(5);
                System.out.printf("\n"+"%-15s %-15s %-15s %-15s %-15s",docID,docName,docSpeciality,dayBooked,slotBooked);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateDoctor(int ids, String spl, int choice, DoctorDetails dd, String avdd, int slot) {
        try{
            if(choice==1){
                Connection con=DBConnection.createConnection();
                String query="update doctordb set dspeciality=? where did=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,spl);
                ps.setInt(2,ids);
                ps.executeUpdate();
            }
            if(choice==2){
                Connection con=DBConnection.createConnection();
                String query="update doctordb set ddays=? where did=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,avdd);
                ps.setInt(2,ids);
                ps.executeUpdate();
            }
            if(choice==3){
                Connection con=DBConnection.createConnection();
                String query="update doctordb set dslots=? where did=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setInt(1,slot);
                ps.setInt(2,ids);
                ps.executeUpdate();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void deleteDoctor(int dIds) {
        try{
            Connection con=DBConnection.createConnection();
            String query="delete from DoctorDB where did="+dIds;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void viewAppointment() {
        try{
            Connection con=DBConnection.createConnection();
            String query=("SELECT * FROM doctordb JOIN appointmentdb WHERE doctordb.dname = appointmentdb.docname");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s","DocID","DocName","DocSpeciality","PatID","PatName","PatMobileNo","DayBooked","SlotBooked"+"\n");
            while(rs.next()){
                int docID = rs.getInt(1);
                String docName = rs.getString(2);
                String docSpeciality = rs.getString(3);
                int patID = rs.getInt(6);
                String patName = rs.getString(7);
                String patMobileNo = rs.getString(8);
                String dayBooked = rs.getString(11);
                int slotBooked = rs.getInt(12);

                System.out.printf("\n"+"%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",docID,docName,docSpeciality,patID,patName,patMobileNo,dayBooked,slotBooked);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void bookAppointment(AppointmentDetails ad) {
        try{
            Connection con= DBConnection.createConnection();
            String query="insert into appointmentdb(patname,patmobileno,docid,docname,docdaybook,docslotbook) value(?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,ad.getPatName());
            pst.setString(2,ad.getPatMobileNo());
            pst.setInt(3,ad.getDocID());
            pst.setString(4,ad.getDocName());
            pst.setString(5,ad.getDocDayBook());
            pst.setInt(6,ad.getDocSlotBook());
            pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}