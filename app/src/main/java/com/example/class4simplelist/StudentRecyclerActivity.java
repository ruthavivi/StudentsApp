package com.example.class4simplelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.class4simplelist.model.Model;
import com.example.class4simplelist.model.Student;

import java.util.List;

public class StudentRecyclerActivity extends AppCompatActivity {
    List<Student> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler);

        RecyclerView list = findViewById(R.id.student_recycler_rview);
        list.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        data = Model.instance.getStudentList();

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("TAG", "row was clicked " + position);
                Intent intent = new Intent(StudentRecyclerActivity.this, StudentInfoActivity.class);
                intent.putExtra("id",data.get(position).id);
                intent.putExtra("name",data.get(position).name);
                intent.putExtra("position",position);


                startActivity(intent);
            }





        });
        ImageButton btn = (ImageButton)findViewById(R.id.add_image_bttn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentRecyclerActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });




    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        private final OnItemClickListener listener;
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.list_row_name_tv);
            idTv = itemView.findViewById(R.id.list_row_id_tv);
            cb = itemView.findViewById(R.id.list_row_cb);
            this.listener = listener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(pos);

                }
            });
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Log.d("TAG","cb was clicked " + pos);

                }
            });
        }


    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{


        private OnItemClickListener listener;

        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
        
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View rowView = inflater.inflate(R.layout.student_list_row,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(rowView, listener);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student = data.get(position);
            holder.idTv.setText(student.id);
            holder.nameTv.setText(student.name);
            holder.cb.setChecked(student.cb);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}