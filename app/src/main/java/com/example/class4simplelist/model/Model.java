package com.example.class4simplelist.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    static final public Model instance = new Model();

    private  Model(){
        for (int i=0; i<2;i++){
            Student student = new Student();
            student.id = "000" + i;
            student.name = "Kuku" + i;
            data.add(student);
        }
    }


    private List<Student> data = new LinkedList<Student>();


    public List<Student> getStudentList(){
        return data;
    }

    public void getStudentById(String id) {
    }

    public void addNewStudent(Student student){
        data.add(student);
    }

    public void editStudent(int pos,Student student) {
        data.set(pos,student);


    }

    public void deleteStudent(int position) {
        data.remove(position);





    }
}
