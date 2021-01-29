package com.example.trackensure_test;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Build;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MainActivity extends AppCompatActivity {

    AppCompatEditText editText;
    AppCompatButton button;
    AppCompatTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.ma_et);
        button = findViewById(R.id.m_bt);
        textView = findViewById(R.id.ma_tv);
    }


    @Override
    protected void onStart() {
        super.onStart();
        button.setOnClickListener(v -> {
            generatingAliases(editText.getText().toString());
        });

    }

    public void generatingAliases(String name) {
        char[] arrayVowels = name.toLowerCase().replaceAll("[^aeiouy]", "").toCharArray();
        char[] arrayConsonants = name.toLowerCase().replaceAll("[^qwrtypsdfghjklzxcvbnm]", "").toCharArray();
        char[] a4 = new char[arrayVowels.length + arrayConsonants.length];

        shuffleArray(arrayVowels);
        shuffleArray(arrayConsonants);
        int maxLen = Math.max(arrayVowels.length, arrayConsonants.length), j = 0;

        for (int i = 0; i < maxLen; i++) {
            if (i < arrayConsonants.length) a4[j++] = arrayConsonants[i];
            if (i < arrayVowels.length) a4[j++] = arrayVowels[i];
        }
        String lastName = new String(a4).substring(0, a4.length / 2);
        String fastName = new String(a4).substring(a4.length / 2);
        textView.setText( "Consonants:"+arrayConsonants.length+" Vowels: "+arrayVowels.length+"\n"+
                firstUpperCase(lastName) + "  " + firstUpperCase(fastName));
    }

    public void shuffleArray(char[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            char chr = array[index];
            array[index] = array[i];
            array[i] = chr;
        }
    }

    public String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}

