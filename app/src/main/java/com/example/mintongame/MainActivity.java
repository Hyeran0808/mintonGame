package com.example.mintongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private Spinner leagueSpin, genderSpin, ageSpin, gradeSpin;
    int league, gender, age, grade;
    Button btn_add, btn_result;
    ArrayList<Team> arrayList = new ArrayList<Team>();
    ListView listView;
    EditText edtName;
    String str_gen, str_age, str_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leagueSpin = (Spinner) findViewById(R.id.leagueSpin);
        genderSpin = (Spinner) findViewById(R.id.spinGen);
        ageSpin = (Spinner) findViewById(R.id.spinAge);
        gradeSpin = (Spinner) findViewById(R.id.spinGrade);
        edtName = (EditText) findViewById(R.id.edtName);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_result = (Button) findViewById(R.id.btn_result);
        listView = (ListView) findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        leagueSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                league = leagueSpin.getSelectedItemPosition(); // 토너먼트 = 0, 리그전 = 1
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        genderSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender = genderSpin.getSelectedItemPosition(); // 남=0, 여=1
                if(gender == 0) {
                    str_gen = "남";
                } else {
                    str_gen = "여";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ageSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                age = ageSpin.getSelectedItemPosition(); // 10대 = 0, 20대 = 1, 30대 = 2, 40대 = 3, 50대 = 4, 60대 = 5
                if(age == 0) {
                    str_age = "10대";
                } else if(age == 1){
                    str_age = "20대";
                } else if(age == 2){
                    str_age = "30대";
                } else if(age == 3){
                    str_age = "40대";
                } else if(age == 4){
                    str_age = "50대";
                } else
                    str_age = "60대";

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gradeSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                grade = gradeSpin.getSelectedItemPosition(); // A = 0, B = 1, C = 2, D = 3, 초심 = 4;
                if(grade == 0){
                    str_grade = "A";
                } else if(grade == 1 ){
                    str_grade = "B";
                } else if(grade == 2 ){
                    str_grade = "C";
                } else if(grade == 3 ){
                    str_grade = "D";
                } else {
                    str_grade = "초심";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] info = {edtName.getText().toString(), str_gen, str_age, str_grade};
                String Result = setTextLength(info[0],10) + setTextLength(info[1],10) + setTextLength(info[2],10) + setTextLength(info[3],10);
                arrayList.add(new Dataset(name.get(info[0]));
                adapter.notifyDataSetChanged();
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("확인");
                for (int index = 0; index < arrayList.size(); index++) {
                    System.out.println(arrayList.get(index));
                }
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }

    public String setTextLength(String text, int length){
        if(text.length()<length){
            int gap = length - text.length();
            for (int i=0; i<gap; i++){
                text = text + " ";
            }
        }
        return text;
    }
}

class Dataset{
    String name, gen, age, grade;
    public Dataset(){

    }
    public Dataset(String str_name, String str_gen, String str_age, String str_grade){
        //return
        name = str_name;
        gen = str_gen;
        age = str_age;
        grade = str_grade;
    }
    //getter
    public String getName(){
        return name;
    }
    public String getGen(){
        return gen;
    }
    public String getAge(){
        return age;
    }
    public String getGrade(){
        return grade;
    }
    //setter
    public void setName(){
        this.name = name;
    }
    public void setGen(){
        this.gen = gen;
    }
    public void setAge(){
        this.age = age;
    }
    public void setGrade(){
        this.grade = grade;
    }
}