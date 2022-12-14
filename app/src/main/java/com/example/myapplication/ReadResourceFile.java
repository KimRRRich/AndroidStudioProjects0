package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;

public class ReadResourceFile extends AppCompatActivity {
    TextView txtContent,xmlContent;
    Button ReadTxT,ReadXML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_resource_file);
        txtContent=findViewById(R.id.txtContent);
        xmlContent=findViewById(R.id.xmlContent);
        ReadTxT=findViewById(R.id.ReadtxtFile);
        ReadXML=findViewById(R.id.ReadxmlFile);

        ReadTxT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources resources =getResources();
                InputStream inputStream=resources.openRawResource(R.raw.raw_file);
                try {
                    byte[] reader = new byte[inputStream.available()];
                    while(inputStream.read(reader)!=-1){}
                    txtContent.setText(new String(reader));

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        ReadXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources resources=getResources();
                XmlResourceParser parser = resources.getXml(R.xml.people);
                String msg="";
                try {
                    while (parser.next() != XmlPullParser.END_DOCUMENT) {
                        String people = parser.getName(); //??????????????????????????????people???person???person,person,people
                        String name = null;
                        String age = null;
                        String height = null;
                        if ((people != null) && people.equals("person")) {
                            int count = parser.getAttributeCount();        //???????????????
                            for (int i = 0; i < count; i++) {
                                String attrName = parser.getAttributeName(i);
                                String attrValue = parser.getAttributeValue(i);
                                if ((attrName != null) && attrName.equals("name")) {
                                    name = attrValue;
                                } else if ((attrName != null) && attrName.equals("age")) {
                                    age = attrValue;
                                } else if ((attrName != null) && attrName.equals("height")) {
                                    height = attrValue;
                                }
                            }
                            if ((name != null) && (age != null) && (height != null)) { //???????????????????????????????????????????????????????????????
                                msg += "?????????"+name+"????????????"+age+"????????????"+height+"\n";
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.e("ResourceFileDemo", e.getMessage(), e);
                }
                xmlContent.setText(msg);
            }
        });
    }
}