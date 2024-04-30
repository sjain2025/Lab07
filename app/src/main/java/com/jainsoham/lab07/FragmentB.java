package com.jainsoham.lab07;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    View view;

    public static FragmentB newInstance(int someInt, String someTitle) {
        FragmentB fragmentB = new FragmentB();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        fragmentB.setArguments(args);
        return fragmentB;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        int someInt = getArguments().getInt("someInt", 0);
        String someTitle = getArguments().getString("someTitle", "");
        TextView textView = view.findViewById(R.id.b_textview);
        textView.setText(someTitle);
        Button button = view.findViewById(R.id.b_button);
        String count = getString(R.string.count, someInt);
        button.setText(count);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}