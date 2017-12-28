package com.example.masters.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class RegisterRoomActivity extends AppCompatActivity {


    EditText Description;
    Button submit;
    TextView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_room);

        Description = (EditText) findViewById(R.id.Description_text);
//        Description.getText().toString();

        show = (TextView) findViewById(R.id.Admin_view);
//        show.setText(Description.getText());

        submit = (Button) findViewById(R.id.Submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String description = Description.getText().toString();
                if (description.length() != 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterRoomActivity.this);
                    builder.setMessage("ยืนยันการสร้างห้อง");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
//                            show.setText(Description.getText());
                            CallWebservice(show.toString(),Description.toString());
                            Toast.makeText(getApplicationContext(),
                                    "สร้างห้องเรียบร้อย", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", null);
                    builder.create();

                    // สุดท้ายอย่าลืม show() ด้วย
                    builder.show();
                }
//                    CallWebservice();
//                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterRoomActivity.this);
//                    builder.setMessage("ยืนยันการสร้างห้อง");
//                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            show.setText(Description.getText());
////                            CallWebservice();
//                            Toast.makeText(getApplicationContext(),
//                                    "สร้างห้องเรียบร้อย", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                    builder.setNegativeButton("ยกเลิก", null);
//                    builder.create();
//
//                    // สุดท้ายอย่าลืม show() ด้วย
//                    builder.show();
            }
        });

    }

    private void CallWebservice(String name , String description) {

        String name  = show;
        String description = Description;

        
    }
}


//        Description = (EditText) findViewById(R.id.Description_text);
//        Description.getText().toString();
//        Description = null;

//        submit = (Button) findViewById(R.id.Submit_button);
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Description.setText(Description.getText().toString());
////                Log.e("aaa",Description.toString());
//                    Log.v("EditText", Description.getText().toString());
////                    CallWebservice();
//                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterRoomActivity.this);
//                    builder.setMessage("ยืนยันการสร้างห้อง");
//                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
////                            CallWebservice();
//                            Toast.makeText(getApplicationContext(),
//                                    "สร้างห้องเรียบร้อย", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                    builder.setNegativeButton("ยกเลิก", null);
//                    builder.create();
//
//                    // สุดท้ายอย่าลืม show() ด้วย
//                    builder.show();
//                    AlertDialog.Builder builder =
//                            new AlertDialog.Builder(RegisterRoomActivity.this);
//                    builder.setMessage("ยืนยันการสร้างห้อง");
//                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            CallWebservice();
//                            Toast.makeText(getApplicationContext(),
//                                    "สร้างห้องเรียบร้อย", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                    builder.setNegativeButton("ยกเลิก", null);
//                    builder.create();
//
//                    // สุดท้ายอย่าลืม show() ด้วย
//                    builder.show();
//                }
//            }
//        });

//    }
//}

