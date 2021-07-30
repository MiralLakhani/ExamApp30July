package com.example.examapp30july;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spCourse;
    EditText name;
    CheckBox accomodation,medical;
    TextView fees,hours,totalFees,totalHours;
    Button add,register;
    RadioButton graduate,unGraduate;
    String courseName[]={"Java", "Swift", "iOS", "Android", "Database" };
    double courseFees[]={1300,1500,1350,1400,1000};
    int courseHourse[]={6,5,5,7,4};
    public  int index;
    static double firstFees = 0;
    static int firstHours;
    static double totalFeesAmount=0;
    static int totalHoursCourse;
    static  String coName;
    ArrayList<String>selectedCourses=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define all attributes
        spCourse=findViewById(R.id.spCourse);
        name=findViewById(R.id.extName);
        fees=findViewById(R.id.txvFee);
        hours=findViewById(R.id.txvHours);
        totalFees=findViewById(R.id.txvTotalFees);
        totalHours=findViewById(R.id.txvTotalHours);
        add=findViewById(R.id.btnAdd);
        register=findViewById(R.id.btnRegister);
        graduate=findViewById(R.id.rdGraduate);
        unGraduate=findViewById(R.id.rdungraduated);
        accomodation=findViewById(R.id.chkAcco);
        medical=findViewById(R.id.chkMedical);

        //set data into array adapter
        ArrayAdapter aa = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, courseName);
        spCourse.setAdapter(aa);

        //implement the spinner event
        spCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int index, long id) {
                firstFees = courseFees[index];
                firstHours= courseHourse[index];
                coName = courseName[index];
                fees.setText(String.format("%.2f", firstFees));
                hours.setText(String.valueOf(firstHours));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //implement button events
        graduate.setOnClickListener(new ButtonsEvents());
        unGraduate.setOnClickListener(new ButtonsEvents());
        register.setOnClickListener(new ButtonsEvents());
        add.setOnClickListener(new ButtonsEvents());
        accomodation.setOnClickListener(new ButtonsEvents());
        medical.setOnClickListener(new ButtonsEvents());

    }
    //implement class for button events
    private class ButtonsEvents implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            double currentFees1=0;
            int currentHours=0;
            switch (v.getId()) {
                case R.id.rdGraduate:
                    break;
                case R.id.rdungraduated:
                    break;
                case R.id.chkAcco:
                    break;
                case R.id.chkMedical:
                    break;
                case R.id.btnAdd:
                    currentFees1 = Double.parseDouble(fees.getText().toString());
                    currentHours =Integer.parseInt(hours.getText().toString());
                    totalFees.setText(String.format("%.2f", totalFeesAmount ));
                    totalHours.setText(String.valueOf(totalHoursCourse));
                    if (graduate.isChecked()) {
                            if (totalHoursCourse >= 21)
                                Toast.makeText(getBaseContext(), "You can not add this course, Your hour limit is 21 hours", Toast.LENGTH_LONG).show();
                        } else {
                            totalFeesAmount += currentFees1;
                            totalHoursCourse += currentHours;
                        }
                        if (unGraduate.isChecked()) {
                            if (totalHoursCourse >= 19)
                                Toast.makeText(getBaseContext(), "You can not add this course, Your hour limit is 19 hours", Toast.LENGTH_LONG).show();
                        } else {
                            totalFeesAmount += currentFees1;
                            totalHoursCourse += currentHours;
                        }

                    totalFees.setText(String.format("%.2f", totalFeesAmount ));
                    totalHours.setText(String.valueOf(totalHoursCourse));
                    break;
                case R.id.btnRegister:
                    //accomodation.setChecked(true);
                    //medical.setChecked(true);
                    if(accomodation.isChecked())
                        totalFeesAmount+=1000;
                    if(medical.isChecked())
                        totalFeesAmount+=700;

                    totalFees.setText(String.format("%.2f", totalFeesAmount ));
                    totalHours.setText(String.valueOf(totalHoursCourse));

                    Toast.makeText(getBaseContext(),"Your total fees is: "+totalFeesAmount,Toast.LENGTH_LONG).show();
                    break;

            }
        }
    }

}