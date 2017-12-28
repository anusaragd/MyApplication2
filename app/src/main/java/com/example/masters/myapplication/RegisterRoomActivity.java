package com.example.masters.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class RegisterRoomActivity extends AppCompatActivity {


    EditText Description;
    Button submit;
    TextView show;

    private String ID_Cus = null;

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
//                CallWebservice();

                String description = Description.getText().toString();
                if (description.length() != 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterRoomActivity.this);
                    builder.setMessage("ยืนยันการสร้างห้อง");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            show.setText(Description.getText());
                            CallWebservice();
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

    private String CallWebservice() {

        String name  = show.toString();
        String description = Description.toString();
//        ID_Cus = show.toString() ;

        int cnt = 0;
        String strResponse="";

        String URL =  "http://203.151.213.80/webservice/WebService1.asmx";
        String NAMESPACE = "http://tempuri.org/";
        String METHOD_NAME = "Register_Room";
        String SOAP_ACTION = "http://tempuri.org/Register_Room";
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        /**** with parameter *****/
        PropertyInfo pi;


        //CID
        String CustomerID = name;
        pi=new PropertyInfo();
        pi.setName("Customer_ID");
        pi.setValue(CustomerID);
        pi.setType(String.class);
        request.addProperty(pi);
        Toast.makeText(RegisterRoomActivity.this,"a",Toast.LENGTH_SHORT).show();
        //ShowMsg(strCardID);

//        //ID_Room
//        String ID_Room = "123456";
//        pi=new PropertyInfo();
//        pi.setName("ID_Room");
//        pi.setValue(ID_Room);
//        pi.setType(String.class);
//        request.addProperty(pi);
//        Toast.makeText(RegisterRoomActivity.this,"b",Toast.LENGTH_SHORT).show();
        //ShowMsg(ID_Room);

        //Description
        String Description = description;
        pi=new PropertyInfo();
        pi.setName("Description");
        pi.setValue(Description);
        pi.setType(String.class);
        request.addProperty(pi);
        Toast.makeText(RegisterRoomActivity.this,"c",Toast.LENGTH_SHORT).show();
        //ShowMsg(Name_Title_TH);

        /*************************/

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        androidHttpTransport.debug = true;
        try
        {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapObject response;
            response= (SoapObject) envelope.bodyIn;
            strResponse = response.getProperty(0).toString();
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            strResponse = e.toString();
        }

//        logMsg(strResponse);
        Toast.makeText(RegisterRoomActivity.this,"OOOOO",Toast.LENGTH_SHORT).show();
        Toast.makeText(RegisterRoomActivity.this,strResponse, Toast.LENGTH_SHORT).show();

        return strResponse;


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

