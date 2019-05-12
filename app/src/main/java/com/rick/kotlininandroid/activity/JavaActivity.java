package com.rick.kotlininandroid.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.rick.kotlininandroid.MainActivity;
import com.rick.kotlininandroid.R;
import com.rick.kotlininandroid.fragment.AFragment;
import com.rick.kotlininandroid.fragment.BFragment;
import com.rick.kotlininandroid.fragment.CFragment;
import com.rick.kotlininandroid.spec.MyGestureListener;
import com.rick.kotlininandroid.spec.Reportable;
import com.rick.kotlininandroid.utils.EditTextUtil;

import java.util.Date;

public class JavaActivity extends AppCompatActivity {

    private static final String TAG = JavaActivity.class.getSimpleName();

    private GestureDetector mDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        transFragmentPage(0);
        mDetector = new GestureDetector(this, new MyGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if (Math.abs(e1.getX() - e2.getX()) > FLIP_DISTANCE) {
                    int idx = getCurrentFragmentIdx();
                    if (e1.getX() > e2.getX()) {
                        System.out.println("向左滑...");
                        transFragmentPage(++idx);
                    } else {
                        System.out.println("向右滑...");
                        transFragmentPage(--idx);
                    }
                    return true;
                } else return false;
            }

            private int getCurrentFragmentIdx() {
                if (currentFragment instanceof AFragment) return 0;
                else if (currentFragment instanceof BFragment) return 1;
                else if (currentFragment instanceof CFragment) return 2;
                return -1;
            }
        });

        // EditText
        EditText editText = findViewById(R.id.editText);

//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // only code here...
//            }
//        });

        EditTextUtil.setOnTextChangeListener(editText, new EditTextUtil.OnChangedListener() {
            @Override
            public void onChanged(String text) {
                System.out.println("text Changed");
            }
        });

        // 第一點：Java 版本，要使用 findViewById()
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hello, Java!");

        // 第一點：Java 版本，沒有 Null Safety 機制，只能依靠判斷式
        Bundle args = getIntent().getBundleExtra(MainActivity.INTENT_KEY);
        if (args != null) {
            String str = args.getString(MainActivity.ARGS_LANG);
            Log.d(TAG, "onCreate: " + str);

            MyData data = new MyData(str != null ? str : "unKnown");
            System.out.println(data);
        }
    }

    // 第三點：Java 版本，值物件
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

    // 第四點：Java 版本，多載
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


    private Fragment currentFragment;

    private void transFragmentPage(int idx) {
        switch (idx) {
            case 0:
                currentFragment = AFragment.getInstance();
                break;
            case 1:
                currentFragment = BFragment.getInstance();
                break;
            case 2:
                currentFragment = CFragment.Companion.getInstance();
                break;
            default:
                return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, currentFragment).commit();
    }

    @Override
    protected void onDestroy() {
//        ((Reportable) currentFragment).report(currentFragment.getClass().getSimpleName());
        if (currentFragment instanceof Reportable)
            ((Reportable) currentFragment).report(currentFragment.getClass().getSimpleName());
        super.onDestroy();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }
}