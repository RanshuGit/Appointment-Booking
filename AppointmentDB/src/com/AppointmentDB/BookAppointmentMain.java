package com.AppointmentDB;

import java.util.Scanner;

public class BookAppointmentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentInterface ai = new AppointmentClass();

        int ch;
        int ch1;
        int ch2;
        theLabel:do {
            System.out.println("**************** APPOINTMENT BOOKING ***************");
            System.out.println("1.ADMIN\n2.USER\n3.EXIT");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    do {
                        System.out.println("\n------------------ ADMIN MODULE ---------------");
                        System.out.println("1.ADD DOCTOR\n2.VIEW DOCTOR\n3.UPDATE DOCTOR\n4.DELETE DOCTOR\n5.VIEW APPOINTMENTS\n6.EXIT");
                        System.out.print("Enter your choice: ");
                        ch1 = sc.nextInt();
                        switch (ch1) {
                            case 1:
                                System.out.print("Enter Doctor ID: ");
                                int dId = sc.nextInt();
                                System.out.print("Enter Doctor Name: ");
                                String dName = sc.next();
                                System.out.print("Enter Speciality: ");
                                String dSpeciality = sc.next();
                                System.out.print("Enter Available Days: ");
                                String dDays = sc.next();
                                System.out.print("Enter Available Slots: ");
                                int dSlots = sc.nextInt();
                                DoctorDetails d = new DoctorDetails(dId,dName,dSpeciality,dDays,dSlots);
                                ai.addDoctor(d);
                                System.out.println("Record Inserted Successfully!");
                                break;
                            case 2:
                                System.out.println("Doctor's Available");
                                ai.viewDoctor();
                                break;
                            case 3:
                                System.out.println("Update Doctor Details");
                                System.out.println("1.Speciality\n2.Available Days\n3.Slots");
                                System.out.println("Enter your choice");
                                int choice=sc.nextInt();
                                String spl = "";
                                String avdd = "";
                                int slot = 0;
                                if(choice==1) {
                                    System.out.print("Enter Doctor ID: ");
                                    int ids = sc.nextInt();
                                    System.out.print("Enter new speciality: ");
                                    spl = sc.next();
                                    DoctorDetails dd = new DoctorDetails();
                                    dd.setdSpeciality(spl);
                                    ai.updateDoctor(ids, spl, choice, dd, avdd, slot);
                                    System.out.println("Speciality Updated Successfully!");
                                }
                                if(choice==2) {
                                    System.out.print("Enter Doctor ID: ");
                                    int ids = sc.nextInt();
                                    System.out.print("Enter new days: ");
                                    avdd = sc.next();
                                    DoctorDetails dd = new DoctorDetails();
                                    dd.setdDays(avdd);
                                    ai.updateDoctor(ids, spl, choice, dd, avdd, slot);
                                    System.out.println("Days Updated Successfully!");
                                }
                                if(choice==3) {
                                    System.out.print("Enter Doctor ID: ");
                                    int ids = sc.nextInt();
                                    System.out.print("Enter new slots: ");
                                    slot = sc.nextInt();
                                    DoctorDetails dd = new DoctorDetails();
                                    dd.setdSlots(slot);
                                    ai.updateDoctor(ids, spl, choice, dd, avdd, slot);
                                    System.out.println("Slots Updated Successfully!");
                                }
                                break;
                            case 4:
                                System.out.print("Enter Doctor ID: ");
                                int dIds=sc.nextInt();
                                ai.deleteDoctor(dIds);
                                System.out.println("Record Deleted Successfully!");
                                break;
                            case 5:
                                System.out.println("Appointment's Available");
                                ai.viewAppointment();
                                break;
                            case 6:
                                continue theLabel;
                            default:
                                System.out.println("Oops! Wrong Choice.");
                                break;
                        }
                    } while (ch1 != 0);
                case 2:
                    do {
                        System.out.println("\n------------------ USER MODULE ------------------");
                        System.out.println("1.VIEW DOCTOR\n2.BOOK APPOINTMENT\n3.EXIT");
                        System.out.print("Enter your choice: ");
                        ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1:
                                System.out.println("Doctor's Available");
                                ai.viewDoctor();
                                break;
                            case 2:
                                int patId = 0;
                                System.out.println("Note: Please enter Doc_ID and Doc_Name as per above available!!!");
                                System.out.print("Enter Patient Name: ");
                                String patName = sc.next();
                                System.out.print("Enter Mobile Number: ");
                                String patMobileNo = sc.next();
                                System.out.print("Enter Doctor ID: ");
                                int docID = sc.nextInt();
                                System.out.print("Enter Doctor Name: ");
                                String docName = sc.next();
                                System.out.print("Enter Day to book: ");
                                String docDays = sc.next();
                                System.out.print("Enter Slot to book: ");
                                int docSlots = sc.nextInt();
                                AppointmentDetails ad = new AppointmentDetails(patId, patName, patMobileNo, docID, docName, docDays, docSlots);
                                ai.bookAppointment(ad);
                                System.out.println("Appointment booked Successfully!");
                                break;
                            case 3:
                                continue theLabel;
                            default:
                                System.out.println("Oops! Wrong Choice.");
                                break;
                        }
                    } while (ch2 != 0);
                    break;
                case 3:
                    System.out.println("Thanks for using me!!!");
                    return;
                default:
                    System.out.println("Oops! Wrong Choice.");
                    break;
            }
        }while (ch != 0);
    }
}