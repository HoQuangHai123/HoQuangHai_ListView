package com.example.adapterlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMota, txtTien;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

       ViewHolder holder;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();

            //anh xa view
            holder.txtTen = (TextView) view.findViewById(R.id.textViewTen);
            holder.txtMota = (TextView) view.findViewById(R.id.textViewMota);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imgViewHinh);
            holder.txtTien = (TextView) view.findViewById(R.id.textViewTien);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //gan gia tri
        TraiCay traiCay = traiCayList.get(i);
        holder.txtTen.setText(traiCay.getTen());
        holder.txtMota.setText(traiCay.getMota());
        holder.imgHinh.setImageResource(traiCay.getHinh());
        holder.txtTien.setText(traiCay.getTien());

        return view;
    }
}
