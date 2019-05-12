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

public class AFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ((TextView) view.findViewById(R.id.textView)).setText(AFragment.class.getSimpleName());
        return view;
    }

// 第六點：Java 版本，Singleton by Java
private static Fragment instance;

public static Fragment getInstance() {
    if (instance == null) instance = new AFragment();
    return instance;
}
}
