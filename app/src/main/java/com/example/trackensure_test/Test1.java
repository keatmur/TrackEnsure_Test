package com.example.trackensure_test;

import android.util.Log;

import java.sql.Array;
import java.util.ArrayList;

public class Test1 {
    public Test1() {
    }
    public int test(int n) {
        ArrayList<Integer> numberOfCoints = new ArrayList<>();
        int p = 0;
        numberOfCoints.add(0, 0);
        while (true) {
            if(n== numberOfCoints.get(p)) return p;
            else if (n< numberOfCoints.get(p)) return p-1;
            p++;
            numberOfCoints.add(p,
                    numberOfCoints.get(p-1)+p);
            Log.i("MyTag","INT "+p);

        }
    }

}
