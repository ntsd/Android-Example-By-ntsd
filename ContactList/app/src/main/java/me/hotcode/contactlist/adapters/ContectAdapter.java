package me.hotcode.contactlist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import me.hotcode.contactlist.R;

/**
 * Created by Jiravat on 8/10/2559.
 */

public class ContectAdapter extends BaseAdapter {
    Context mContext;
    String[] name;
    String[] surname;
    String[] tel;
    String[] address;

    public ContectAdapter(Context mContext, String[] name, String[] surname, String[] tel, String[] address) {
        this.mContext = mContext;
        this.name = name;
        this.surname = surname;
        this.tel = tel;
        this.address = address;
    }

    @Override
    public int getCount() {
        return surname.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        if(view == null)
//            view = mInflater.inflate(R.layout.contectlistview_row, viewGroup, false);
        view = mInflater.inflate(R.layout.contectlistview_row, viewGroup, false);

        TextView textView = (TextView)view.findViewById(R.id.name);
        textView.append(name[i]);
        TextView textView2 = (TextView)view.findViewById(R.id.surname);
        textView2.append(surname[i]);
        TextView textView3 = (TextView)view.findViewById(R.id.tel);
        textView3.append(tel[i]);
        TextView textView4 = (TextView)view.findViewById(R.id.address);
        textView4.append(address[i]);

        return view;
    }
}
