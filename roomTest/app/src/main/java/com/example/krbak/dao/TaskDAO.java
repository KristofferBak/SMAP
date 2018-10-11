package com.example.krbak.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.krbak.roomtest.Task;

import java.util.List;

@Dao
public interface TaskDAO {
    @Query("SELECT * FROM task")
    public List<Task> getAll();

    @Delete
    public void delete(Task task);

    @Insert
    public void insert(Task task);
}

