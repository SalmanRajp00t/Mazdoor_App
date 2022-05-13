package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contectus extends AppCompatActivity {
    EditText etTo, etsubject, etMessage;
    Button btsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contectus);

        etTo = findViewById(R.id.et_to);
        etsubject = findViewById(R.id.et_subject);
        etMessage = findViewById(R.id.et_message);
        btsend = findViewById(R.id.et_send);


        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW
                        , Uri.parse("mailto:" + etTo.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,etsubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                startActivity(intent);
            }
        });
    }
}