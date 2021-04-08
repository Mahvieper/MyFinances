package com.barnes.myfinances.Loan;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Loan {

    public Loan() {
    }

    public Loan(int accNumber, int initBal,int currBal,int intRate,int payment) {
        this.accNumber = accNumber;
        this.initBal = initBal;
        this.currBal = currBal;
        this.intRate = intRate;
    }

    @PrimaryKey()
    public int accNumber;

    @ColumnInfo(name = "initBal")
    public int initBal;

    @ColumnInfo(name = "currBal")
    public int currBal;

    @ColumnInfo(name = "intRate")
    public int intRate;


    @ColumnInfo(name = "payment")
    public int payment;
    /*public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");

        return sdf.format(new Date(timestamp));
    }*/


}
