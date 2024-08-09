package com.example.todolist;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListViewAdapterNameAndAge extends BaseAdapter {

    private ArrayList<Dataclass> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    private ClickListener clickListener;

    public CustomListViewAdapterNameAndAge(Context context, ArrayList<Dataclass> listData,ClickListener clickListener) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.list_items, null);
            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.showLV);
            holder.description = (TextView) convertView.findViewById(R.id.showLVdesc);
            holder.deletebtn = (ImageButton) convertView.findViewById(R.id.deletebtn);
            holder.editbtn = (ImageButton) convertView.findViewById(R.id.editbtn);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(listData.get(position).getTitle());
        holder.description.setText(listData.get(position).getDescr());

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.delete(position);
                Toast.makeText(context.getApplicationContext(),"item deleted",Toast.LENGTH_SHORT).show();
            }
        });
        holder.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.edit(position);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView description;
        ImageButton deletebtn;
        ImageButton editbtn;
    }

}
