package com.rick.kotlininandroid.spec;

import android.view.GestureDetector;
import android.view.MotionEvent;

public abstract class MyGestureListener implements GestureDetector.OnGestureListener {

    protected static final float FLIP_DISTANCE = 50;

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
}
