package com.barnes.myfinances.CD;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CDDao {
    @Query("SELECT * FROM CD")
    List<CD> getAll();

    @Query("SELECT * FROM CD WHERE accNumber = :id")
    List<CD> loadAllById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CD users);

    @Delete
    void delete(CD user);

    @Query("DELETE FROM CD")
    void deleteAll();
}
