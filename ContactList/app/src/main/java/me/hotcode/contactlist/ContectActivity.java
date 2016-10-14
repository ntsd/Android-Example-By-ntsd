package me.hotcode.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contect);
        TextView textView = (TextView) findViewById(R.id.name);
        textView.append(getIntent().getStringExtra("name"));
        TextView textView2 = (TextView) findViewById(R.id.surname);
        textView2.append(getIntent().getStringExtra("surname"));
        TextView textView3 = (TextView) findViewById(R.id.tel);
        textView3.append(getIntent().getStringExtra("tel"));
        TextView textView4 = (TextView) findViewById(R.id.address);
        textView4.append(getIntent().getStringExtra("address"));
    }
}
