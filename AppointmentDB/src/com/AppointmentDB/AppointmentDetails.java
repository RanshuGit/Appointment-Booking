package com.AppointmentDB;

public class AppointmentDetails {
    int patId;
    String patName;
    String patMobileNo;
    int docID;
    String docName;
    String docDayBook;
    int docSlotBook;

    public AppointmentDetails(int patId, String patName, String patMobileNo, int docID, String docName, String docDayBook, int docSlotBook) {
        this.patId = patId;
        this.patName = patName;
        this.patMobileNo = patMobileNo;
        this.docID = docID;
        this.docName = docName;
        this.docDayBook = docDayBook;
        this.docSlotBook = docSlotBook;
    }

    public String getPatName() {
        return patName;
    }

    public String getPatMobileNo() {
        return patMobileNo;
    }

    public int getDocID() {
        return docID;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocDayBook() {
        return docDayBook;
    }

    public int getDocSlotBook() {
        return docSlotBook;
    }

    @Override
    public String toString() {
        return "AppointmentDetails{" +
                "patId=" + patId +
                ", patName='" + patName + '\'' +
                ", patMobileNo=" + patMobileNo +
                ", docID=" + docID +
                ", docName='" + docName + '\'' +
                ", docDayBook='" + docDayBook + '\'' +
                ", docSlotBook=" + docSlotBook +
                '}';
    }
}

