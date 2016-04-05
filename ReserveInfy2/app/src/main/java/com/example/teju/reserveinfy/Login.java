package com.example.teju.reserveinfy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Login extends Activity{

    private static EditText employee_Id;
    private static EditText employee_Pass;
    private static Button login_btn;
    private static Button signup_btn;
    private static TextView forgot_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton() {
        employee_Id = (EditText) findViewById(R.id.employee_Id);
        employee_Pass = (EditText) findViewById(R.id.employee_Pass);
        login_btn = (Button) findViewById(R.id.sign_in);
        signup_btn = (Button) findViewById(R.id.sign_up);
        forgot_pass = (TextView) findViewById(R.id.forgotpassword);

        View.OnClickListener myhandler1 = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent("com.example.teju.reserveinfy.SignUp");
                startActivity(intent);
            }
        };
        signup_btn.setOnClickListener(myhandler1);

        View.OnClickListener myhandler2 = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent2 = new Intent("com.example.teju.reserveinfy.MainActivity");
                startActivity(intent2);
            }
        };
        login_btn.setOnClickListener(myhandler2);

        View.OnClickListener myhandler3 = new View.OnClickListener(){
            public void onClick(View v){
                showForgotpassDialog();
            }
        };
        forgot_pass.setOnClickListener(myhandler3);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    public void showForgotpassDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_forgotpass, null);

        AlertDialog.Builder alert = new AlertDialog.Builder(this,R.style.Dialog);
        alert.setTitle("Forgot Password");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Send", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // code for matching password
                Toast.makeText(getBaseContext(), "Username Password: ", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}
