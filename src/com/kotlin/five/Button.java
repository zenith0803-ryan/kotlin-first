package com.kotlin.five;


import com.kotlin.four.View;

public class Button {
    public void setOnClickListener(OnClickListener l){
        System.out.println("setOnClickListener!");
    }
    public void postponeComputation(int delay, Runnable computation){}
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked!!!");
            }
        });
    }
}

