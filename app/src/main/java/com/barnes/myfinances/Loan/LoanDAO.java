package com.barnes.myfinances.Loan;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LoanDAO {
    @Query("SELECT * FROM Loan")
    List<Loan> getAll();

    @Query("SELECT * FROM Loan WHERE accNumber = :id")
    List<Loan> loadAllById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Loan... users);

    @Delete
    void delete(Loan user);

    @Query("DELETE FROM Loan")
    void deleteAll();
}