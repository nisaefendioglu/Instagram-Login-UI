package com.nisaefendioglu.instagram;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResetPasswordActivity extends Activity {
    private String[] countries = {"Afrikaans", "Čeština", "Dansk", "Deutsch", "Ελληνικά","English","English (UK)"
    , "Español (España)", "Español","Suomi", "Français","Bahasa Indonesia","Italiano", "日本語","한국어","Bahasa Melayu",
    "Norsk","Nederlands","Polski","Português (Brasil)","Português (Portugal)","Русский","Svenska","ภาษาไทย","Filipino",
    "Türkçe", "中文(简体)","中文(台灣)",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword_layout);
        ListView list=(ListView) findViewById(R.id.country);
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, countries);
        list.setAdapter(dataAdapter);


    }

}
