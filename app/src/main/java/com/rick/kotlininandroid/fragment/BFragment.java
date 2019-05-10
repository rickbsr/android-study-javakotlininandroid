package com.rick.kotlininandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.rick.kotlininandroid.R;
import com.rick.kotlininandroid.spec.ReportFragment;

public class BFragment extends ReportFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ((TextView) view.findViewById(R.id.textView)).setText(BFragment.class.getSimpleName());
        return view;
    }

    // Singleton by Java
    private static Fragment instance;

    public static Fragment getInstance() {
        if (instance == null) instance = new BFragment();
        return instance;
    }
}
