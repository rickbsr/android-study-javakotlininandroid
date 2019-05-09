package com.rick.kotlininandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class JavaActivity extends AppCompatActivity {

    private static final String TAG = JavaActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        // findViewById
        TextView textView = (TextView) findViewById(R.id.textView);

        // Java 沒有 Null Safety 機制
        Bundle args = getIntent().getBundleExtra(MainActivity.INTENT_KEY);
        if (args != null) {
            String str = args.getString(MainActivity.ARGS_LANG);
            Log.d(TAG, "onCreate: " + str);

            MyData data = new MyData(str != null ? str : "unKnown");
            System.out.println(data);
        }
    }

    class MyData {
        private String str;

        public MyData(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return "MyData{" +
                    "str='" + str + '\'' +
                    '}';
        }
    }

private void doThings(String content, long time, String tag) {
    // code...
}

private void doThings(String content, long time) {
    String tag = JavaActivity.class.getSimpleName();
    doThings(content, time, tag);
}

private void doThings(String content, String tag) {
    long time = new Date().getTime();
    doThings(content, time, tag);
}

private void doThings(String content) {
    String tag = JavaActivity.class.getSimpleName();
    long time = new Date().getTime();
    doThings(content, time, tag);
}
}