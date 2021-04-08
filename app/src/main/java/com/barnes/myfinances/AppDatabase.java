package com.barnes.myfinances;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.barnes.myfinances.CD.CD;
import com.barnes.myfinances.CD.CDDao;
import com.barnes.myfinances.Checking.Checking;
import com.barnes.myfinances.Checking.CheckingDAO;
import com.barnes.myfinances.Loan.Loan;
import com.barnes.myfinances.Loan.LoanDAO;

@Database(entities = {CD.class, Loan.class, Checking.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CDDao userDao();
    public abstract LoanDAO loanDao();
    public abstract CheckingDAO checkingDAODao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 1;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}