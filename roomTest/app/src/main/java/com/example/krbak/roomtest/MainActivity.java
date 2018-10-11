package com.example.krbak.roomtest;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.krbak.dao.TaskDAO;

public class MainActivity extends Activity {

    EditText editTask;
    EditText editLocation;
    private Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTask = findViewById(R.id.editText);
        editLocation = findViewById(R.id.editText2);
    }

    public Db getDb(){
        if(db ==null){
            db = Room.databaseBuilder(this, Db.class, "my_tasks").allowMainThreadQueries().fallbackToDestructiveMigrationFrom().build();
        }
        return db;
    }

    public void addTask(View view){
        String loc = editLocation.getText().toString();
        String task = editTask.getText().toString();

        db = getDb();

        TaskDAO td = db.taskDao();


        Task newTask = new Task();
        newTask.setLocation(loc);
        newTask.setTaskName(task);

        td.insert(newTask);
    }
}
