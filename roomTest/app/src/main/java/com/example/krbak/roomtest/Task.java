package com.example.krbak.roomtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "taskName")
    private String taskName;

    @ColumnInfo(name = "location")
    private String location;

    public int getUid(){
        return uid;
    }

    public String getTaskName(){
        return taskName;
    }

    public String getLocation(){
        return location;
    }

    public void setUid( int _uid){
        uid = _uid;
    }
    public void setTaskName(String _name){
        taskName = _name;
    }
    public void setLocation(String _loc){
        location = _loc;
    }
}
