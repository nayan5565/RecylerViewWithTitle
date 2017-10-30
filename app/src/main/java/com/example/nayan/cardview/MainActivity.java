package com.example.nayan.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<List<ListItem>> arraylist;
    MyRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MyRecyclerAdapter(getList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<ListItem> getList() {
        ArrayList<ListItem> arrayList=new ArrayList<>();
        for(int j=0;j<=4;j++) {
            Header header=new Header();
            header.setHeader("header"+j);
            arrayList.add(header);
            for (int i = 0; i <= 3; i++) {
                ContentItem item = new ContentItem();
                item.setRollnumber(i + "");
                item.setName("A" + i);
                arrayList.add(item);
            }
        }
        return arrayList;
    }

}
