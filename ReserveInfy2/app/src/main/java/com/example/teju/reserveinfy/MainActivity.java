package com.example.teju.reserveinfy;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity {

    private static ImageButton bus_btn;
    private static ImageButton sport_btn;
    private static ImageButton booking_btn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        NewActivity();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.action_helptopics:
                Intent intent = new Intent("com.example.teju.reserveinfy.Help");
                startActivity(intent);
                break;
            case R.id.action_submitfeedback:
                showFeedbackDialog();
                break;
            case R.id.action_report:
                showReportDialog();
                break;
            case R.id.action_terms:
                showTermsDialog();
                break;
            case R.id.action_about:
                showAboutDialog();
                break;
            case R.id.action_updateprofile:
                showEditProfileDialog();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void NewActivity(){

        bus_btn =(ImageButton) findViewById(R.id.busicon);
        sport_btn =(ImageButton) findViewById(R.id.sporticon);
        booking_btn =(ImageButton) findViewById(R.id.bookingicon);

        View.OnClickListener myhandler1 = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent1 = new Intent("com.example.teju.reserveinfy.Bus");
                startActivity(intent1);
            }
        };
        bus_btn.setOnClickListener(myhandler1);

        View.OnClickListener myhandler2 = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent2 = new Intent("com.example.teju.reserveinfy.Sport");
                startActivity(intent2);
            }
        };
        sport_btn.setOnClickListener(myhandler2);

        View.OnClickListener myhandler3 = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent3 = new Intent("com.example.teju.reserveinfy.Booking");
                startActivity(intent3);
            }
        };
        booking_btn.setOnClickListener(myhandler3);

    }

    public void showAboutDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_about, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("About");
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });

        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showEditProfileDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_editprofile, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Edit Profile");
        dialogBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showFeedbackDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_feedback, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Submit Feedback");
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });


        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showReportDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_report, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Report Problems");
        dialogBuilder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showTermsDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_terms, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Terms & Conditions");
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
