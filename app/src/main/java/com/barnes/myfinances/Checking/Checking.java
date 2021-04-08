package com.barnes.myfinances.Checking;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Checking {
    public Checking() {
    }

    public Checking(int accNumber,int currBal) {
        this.accNumber = accNumber;

        this.currBal = currBal;

    }

    @PrimaryKey()
    public int accNumber;



    @ColumnInfo(name = "currBal")
    public int currBal;


    /*public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");

        return sdf.format(new Date(timestamp));
    }*/

}
