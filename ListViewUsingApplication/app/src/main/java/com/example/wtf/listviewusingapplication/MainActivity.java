package com.example.wtf.listviewusingapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView bookListView;
    String[] bookNames;
    String[] bookAuthors;
    String[] bookPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        bookListView = (ListView) findViewById(R.id.bookListView);
        bookNames = res.getStringArray(R.array.bookNames);
        bookAuthors = res.getStringArray(R.array.bookAuthors);
        bookPrices = res.getStringArray(R.array.bookPrices);

        BookAdapter bookAdapter = new BookAdapter(this, bookNames, bookAuthors, bookPrices);
        bookListView.setAdapter(bookAdapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent imageActivityIntent = new Intent(getApplicationContext(), BookImageActivity.class);
                imageActivityIntent.putExtra("com.example.wtf.BOOK_INDEX",position);
                startActivity(imageActivityIntent);
            }
        });
    }
}