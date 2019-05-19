package com.example.android.notepad;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by zspmh on 2017-05-02.
 */

public class MySimpleCursorAdapter extends SimpleCursorAdapter {
    public MySimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    public MySimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        String text = cursor.getString(2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time = Long.parseLong(text);
        String dateString = "最后改动时间："+format.format(time);
        if (text == null) {
            text = "";
        }
        View v = view.findViewById(android.R.id.text2);
        if (v instanceof TextView) {
            setViewText((TextView) v, dateString);
        }
    }
}