package com.example.wtf.listviewusingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BookAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] bookNames;
    String[] bookAuthors;
    String[] bookPrices;

    public BookAdapter(Context c, String[] names, String[] authors, String[] prices) {
        bookNames = names;
        bookAuthors = authors;
        bookPrices = prices;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bookNames.length;
    }

    @Override
    public Object getItem(int position) {
        return bookNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.book_detail_layout, null);

        TextView bookNameTV = (TextView) v.findViewById(R.id.bookNameTV);
        TextView bookAuthorTV = (TextView) v.findViewById(R.id.bookAuthorTV);
        TextView bookPriceTV = (TextView) v.findViewById(R.id.bookPriceTV);

        bookNameTV.setText(bookNames[position]);
        bookAuthorTV.setText(bookAuthors[position]);
        bookPriceTV.setText(bookPrices[position]);

        return v;
    }
}
