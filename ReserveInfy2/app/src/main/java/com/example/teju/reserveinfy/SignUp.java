package com.example.teju.reserveinfy;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends ActionBarActivity {

    ReserveInfyDatabase myDb;
    EditText employee_Id, employee_Name, employee_Pass, employee_Mobile, employee_TransportId, employee_HealthId;
    RadioGroup employee_Transport;
    String employee_Email, transport_radiovalue;
    RadioGroup employee_Health;
    String health_radiovalue;
    Button sign_Up;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        myDb = new ReserveInfyDatabase(this);

        employee_Id = (EditText) findViewById(R.id.employee_Id);
        employee_Name = (EditText) findViewById(R.id.employee_Name);
        employee_Pass = (EditText) findViewById(R.id.employee_Pass);
        employee_Email = "dsd";
        employee_Mobile = (EditText) findViewById(R.id.employee_Mobile);
        employee_TransportId = (EditText) findViewById(R.id.transport_Id);
        employee_HealthId = (EditText) findViewById(R.id.health_Id);

        AddData();
    }

    public void AddData() {

        employee_Transport = (RadioGroup) findViewById(R.id.transportRadioGroup);
        transport_radiovalue = ((RadioButton) this.findViewById(employee_Transport.getCheckedRadioButtonId())).getText().toString();
        employee_Health = (RadioGroup) findViewById(R.id.healthRadioGroup);
        health_radiovalue = ((RadioButton) this.findViewById(employee_Health.getCheckedRadioButtonId())).getText().toString();
        sign_Up = (Button) findViewById(R.id.create_Account);

        sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.InsertSignUp(employee_Id.getText().toString(), employee_Name.getText().toString(), employee_Pass.getText().toString(), employee_Email,
                        employee_Mobile.getText().toString(), transport_radiovalue, employee_TransportId.getText().toString(), health_radiovalue, employee_HealthId.getText().toString());

                if (isInserted)
                    Toast.makeText(SignUp.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SignUp.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
            }
        });

    }

}
