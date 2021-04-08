package com.barnes.myfinances.CD;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CD {

    public CD() {
    }

    public CD(int accNumber, int initBal,int currBal,int intRate) {
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

    /*public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");

        return sdf.format(new Date(timestamp));
    }*/


}
