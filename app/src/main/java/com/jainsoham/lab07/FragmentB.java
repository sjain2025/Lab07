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

import java.util.Random;

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
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        int someInt = getArguments().getInt("someInt", 0);
        String someTitle = getArguments().getString("someTitle", "");
        TextView textView = view.findViewById(R.id.b_textview);
        TextView quoteView = view.findViewById(R.id.quoteView);
        textView.setText(someTitle);
        String[] quotes = {"You must be the change you wish to see in the world", "Spread love everywhere you go. Let no one ever come to you without leaving happier.", "The only thing we have to fear is fear itself", "Darkness cannot drive out darkness; only light can do that. Hate cannot drive out hate: only love can do that", "Do one thing every day that scares you", "Well done is better than well said", "The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart", "It is during our darkest moments that we must focus to see the light", "Do not go where the path may lead; go instead where there is no path and leave a trail", "Be yourself; everyone else is already taken", "If life were predictable, it would cease to be life and be without flavor.", "In the end, it's not the years in your life that count. It's the life in your years.", "Life is a succession of lessons which must be lived to be understood.", "You will face many defeats in life, but never let yourself be defeated", "Never let the fear of striking out keep you from playing the game", "Life is never fair, and perhaps it is a good thing for most of us that it is not", "The only impossible journey is the one you never begin", "In this life, we cannot do great things. We can only do small things with great love", "Only a life lived for others is a life worthwhile.", "The purpose of our lives is to be happy"};
        Random rand = new Random();
        int randInt = rand.nextInt(quotes.length);
        quoteView.setText("\"" + quotes[randInt] + "\"");
        Button button = view.findViewById(R.id.b_button);
        String count = getString(R.string.count, someInt);
        button.setText(count);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}