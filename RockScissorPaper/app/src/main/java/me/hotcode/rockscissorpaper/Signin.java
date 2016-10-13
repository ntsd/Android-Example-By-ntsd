package me.hotcode.rockscissorpaper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signin extends AppCompatActivity implements View.OnClickListener{

    Button go_button;
    EditText name_field;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        go_button = (Button) findViewById(R.id.editnamebut);
        go_button.setOnClickListener(this);
        name_field = (EditText) findViewById(R.id.editname);

    }

    @Override
    public void onClick(View view) {
        Intent resultIntent = new Intent();
        String name = name_field.getText().toString();
        resultIntent.putExtra("name", name);
        setResult(RESULT_OK, resultIntent);
        onBackPressed();
    }


}
