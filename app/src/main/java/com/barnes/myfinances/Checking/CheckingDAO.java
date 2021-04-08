package com.barnes.myfinances.Checking;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CheckingDAO {
    @Query("SELECT * FROM Loan")
    List<Checking> getAll();

    @Query("SELECT * FROM Loan WHERE accNumber = :id")
    List<Checking> loadAllById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Checking... users);

    @Delete
    void delete(Checking user);

    @Query("DELETE FROM Checking")
    void deleteAll();
}