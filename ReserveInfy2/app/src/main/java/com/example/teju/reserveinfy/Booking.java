package com.example.teju.reserveinfy;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class Booking extends AppCompatActivity {

    private Toolbar toolbar;
    TableLayout table_layout;
    EditText rowno_et, colno_et;
    Button build_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        rowno_et=(EditText)findViewById(R.id.rowno_id);
        colno_et=(EditText)findViewById(R.id.colno_id);
        build_btn=(Button)findViewById(R.id.build_btn_id);
        table_layout=(TableLayout)findViewById(R.id.ViewBookingtable);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        BuildTable(2,3);

        build_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String rowstring = rowno_et.getText().toString();
                String colstring = colno_et.getText().toString();

                if (!rowstring.equals("") && !colstring.equals("")) {
                    int rows = Integer.parseInt(rowstring);
                    int cols = Integer.parseInt(colstring);
                    table_layout.removeAllViews();
                    BuildTable(rows, cols);
                } else {
                    Toast.makeText(Booking.this,
                            "Please Enter the row and col Numbers",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
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
            case R.id.action_about:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void BuildTable(int rows, int cols) {

            // outer for loop
            for (int i = 1; i <= rows; i++) {

                TableRow row = new TableRow(this);
                row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT));

                // inner for loop
                for (int j = 1; j <= cols; j++) {

                    TextView tv = new TextView(this);
                    tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT));
                    tv.setPadding(5, 5, 5, 5);
                    tv.setText("R " + i + ", C" + j);

                    row.addView(tv);

                }

                table_layout.addView(row);

            }
    }


}
