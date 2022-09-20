package com.example.adapterlistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);

        lvTraiCay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(MainActivity.this, LayoutNew.class);
                    startActivity(intent);
                }
            }
        });
        lvTraiCay.setOnItemLongClickListener(new ItemLongClickRemove());
    }
    private void AnhXa(){
        lvTraiCay = (ListView) findViewById(R.id.listviewTraiCay);
        arrayTraiCay = new ArrayList<>();

        arrayTraiCay.add(new TraiCay("Dâu Tây","Dâu tây đà lạt", R.drawable.daytay,"6$"));
        arrayTraiCay.add(new TraiCay("Xoài","Đặt sản miền trung",R.drawable.xoai,"4$"));
        arrayTraiCay.add(new TraiCay("Ổi","Ăn ngon khỏi chê",R.drawable.oi,"9$"));
        arrayTraiCay.add(new TraiCay("Cam","Không ngọt trả liền",R.drawable.cam,"2$"));
        arrayTraiCay.add(new TraiCay("Bơ","Đặc sản tây nguyên",R.drawable.bo,"8$"));
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    arrayTraiCay.remove(position);
                    //cập nhật lại listview
                    adapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}