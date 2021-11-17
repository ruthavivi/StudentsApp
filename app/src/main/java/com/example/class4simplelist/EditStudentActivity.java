package com.example.class4simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditStudentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        TextView text=findViewById(R.id.editStudent);
        EditText name=findViewById(R.id.new_name_et);
        EditText id=findViewById(R.id.new_id_tv);
        Button cancel=findViewById(R.id.cancel2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditStudentActivity.super.onBackPressed();

            }
        });

        Button save=findViewById(R.id.button_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////להוסיף כאן אופציה של שמירת סטודנט שהוכנס
                EditStudentActivity.super.onBackPressed();

            }
        });

        Button delete=findViewById(R.id.delete_bttn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////להוסיף כאן אופציה של מחיקת סטודנט
                EditStudentActivity.super.onBackPressed();

            }
        });



    }
}