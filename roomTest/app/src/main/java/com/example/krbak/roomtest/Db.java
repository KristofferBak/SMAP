package com.example.krbak.roomtest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.krbak.dao.TaskDAO;

@Database(entities = {Task.class}, version = 4, exportSchema = false)
//@TypeConverters({Converters.class})
public abstract class Db extends RoomDatabase{
    public abstract TaskDAO taskDao();

}
