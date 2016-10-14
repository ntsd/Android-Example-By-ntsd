package me.hotcode.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import me.hotcode.contactlist.adapters.ContectAdapter;

public class MainActivity extends AppCompatActivity {
    ListView contectlistview;
    String[] list_name = { "Aerith", "Barret", "Cait"
            , "Cid", "Strife", "Red", "Sephi"
            , "Tifa", "Vincent", "Yuffie"
            , "Zack" };
    String[] list_surname = { "Gainsborough", "Wallace", "Sith"
            , "Highwind", "Cloud", "XIII", "roth"
            , "Lockhart", "Valentine", "Kisaragi"
            , "Fair" };
    String[] tel = { "0123", "456777", "6777"
            , "444444", "1111111", "555555", "6666666"
            , "0888888888", "111111113333", "12345531"
            , "12323123" };
    String[] address = { "home", "airplane", "world"
            , "sun", "river", "clound", "ddddd"
            , "ffffff", "aaaaa", "bbbbbbb"
            , "rrrrrr" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contectlistview = (ListView) findViewById(R.id.Contactlistview);

        ContectAdapter adapter = new ContectAdapter(this, list_name,list_surname,tel,address);
        contectlistview.setAdapter(adapter);
        contectlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ContectActivity.class);
                intent.putExtra("name", list_name[i]);
                intent.putExtra("surname", list_surname[i]);
                intent.putExtra("tel", tel[i]);
                intent.putExtra("address", address[i]);
                startActivity(intent);
            }
        });

    }
}
