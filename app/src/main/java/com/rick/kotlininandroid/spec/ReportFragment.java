package com.rick.kotlininandroid.spec;

import androidx.fragment.app.Fragment;

public abstract class ReportFragment extends Fragment implements Reportable {

    @Override
    public void report(String info) {
        // do report() code...
        System.out.println("Report: " + info);
    }
}
