package com.example.hughsquizapp;
//Source for Time Motion image 'motion_time_graph.jpg': https://physicsigcse.wordpress.com/2016/05/22/1-2-plot-and-interpret-distance-time-graphs/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup q1radioGroup;
    ImageView q1ImageView;
    RadioButton q1FalseRadioButton, q1TrueRadioButton;

    TextView q2TextView;
    ImageView q2ImageView;

    CheckBox q3iCheckBox, q3iiCheckBox, q3iiiCheckBox, q3ivCheckBox, q3vCheckBox;
    ImageView q3iImageView, q3iiImageView, q3iiiImageView, q3ivImageView, q3vImageView;

    boolean hasCheckBoxQ3i = false;
    boolean hasCheckBoxQ3ii = false;
    boolean hasCheckBoxQ3iii = false;
    boolean hasCheckBoxQ3iv = false;
    boolean hasCheckBoxQ3v = false;

    EditText q4iAnswerEditText, q4iiAnswerEditText, q4iiiAnswerEditText, q4ivAnswerEditText;
    ImageView q4iImageView, q4iiImageView, q4iiiImageView, q4ivImageView;

    int userScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1FalseRadioButton = (RadioButton) findViewById(R.id.q1_radioButton_false);
        q1TrueRadioButton = (RadioButton) findViewById(R.id.q1_radioButton_true);
        q1radioGroup = (RadioGroup) findViewById(R.id.q1_radio_buttons);

        q2TextView = (TextView) findViewById(R.id.q2_editText);

        q3iCheckBox = (CheckBox) findViewById(R.id.q3_i_checkbox);
        q3iiCheckBox = (CheckBox) findViewById(R.id.q3_ii_checkbox);
        q3iiiCheckBox = (CheckBox) findViewById(R.id.q3_iii_checkbox);
        q3ivCheckBox = (CheckBox) findViewById(R.id.q3_iv_checkbox);
        q3vCheckBox = (CheckBox) findViewById(R.id.q3_v_checkbox);

        q4iAnswerEditText = (EditText) findViewById(R.id.q4_i_editBox);
        q4iiAnswerEditText = (EditText) findViewById(R.id.q4_ii_editBox);
        q4iiiAnswerEditText = (EditText) findViewById(R.id.q4_iii_editBox);
        q4ivAnswerEditText = (EditText) findViewById(R.id.q4_iv_editBox);

        q1ImageView = (ImageView) findViewById(R.id.q1_redgreencheck_imageview);
        q2ImageView = (ImageView) findViewById(R.id.q2_redgreencheck_imageview);
        q3iImageView = (ImageView) findViewById(R.id.q3_i_greencheck_imageview);
        q3iiImageView = (ImageView) findViewById(R.id.q3_ii_greencheck_imageview);
        q3iiiImageView = (ImageView) findViewById(R.id.q3_iii_redcheck_imageview); //only wrong answer
        q3ivImageView = (ImageView) findViewById(R.id.q3_iv_greencheck_imageview);
        q3vImageView = (ImageView) findViewById(R.id.q3_v_greencheck_imageview);
        q4iImageView = (ImageView) findViewById(R.id.q4_i_redgreencheck_imageview);
        q4iiImageView = (ImageView) findViewById(R.id.q4_ii_redgreencheck_imageview);
        q4iiiImageView = (ImageView) findViewById(R.id.q4_iii_redgreencheck_imageview);
        q4ivImageView = (ImageView) findViewById(R.id.q4_iv_redgreencheck_imageview);
    }

    //Show users total score
    public void showScore(View view) {
       //Check score for question 1
        //Ref //https://www.tutlane.com/tutorial/android/android-radiogroup-with-examples

        RadioGroup q1RadioGroup = (RadioGroup) findViewById(R.id.q1_radio_buttons);
        switch (q1RadioGroup.getCheckedRadioButtonId()) {
            case R.id.q1_radioButton_false:
                userScore += 0;
                q1ImageView.setImageResource(R.mipmap.red_cross);
                break;
            case R.id.q1_radioButton_true:
                userScore += 1;
                q1ImageView.setImageResource(R.mipmap.green_tick);
                break;
        }

        //Check score for question 2
        String q2Answer = "1000000";
        if (q2TextView.getText().toString().equals(q2Answer)) {
            userScore += 1;
            q2ImageView.setImageResource(R.mipmap.green_tick);
        } else q2ImageView.setImageResource(R.mipmap.red_cross);

        //check score for question 3
        //has Q3-i been ticked
        hasCheckBoxQ3i = q3iCheckBox.isChecked();
        //has Q3-ii been ticked
        hasCheckBoxQ3ii = q3iiCheckBox.isChecked();
        //has Q3-iii been ticked
        hasCheckBoxQ3iii = q3iiiCheckBox.isChecked();
        //has Q3-iv been ticked
        hasCheckBoxQ3iv = q3ivCheckBox.isChecked();
        //has Q3-v been ticked
        hasCheckBoxQ3v = q3vCheckBox.isChecked();

        if (hasCheckBoxQ3i) {
            userScore += 1;
            q3iImageView.setImageResource(R.mipmap.green_tick);
        }
        else q3iImageView.setImageResource(R.mipmap.red_cross);
        if (hasCheckBoxQ3ii) {
            userScore += 1;
            q3iiImageView.setImageResource(R.mipmap.green_tick);
        }
        else q3iiImageView.setImageResource(R.mipmap.red_cross);

        //Q3iiithis is the only wrong answer
        if (hasCheckBoxQ3iii) {
            userScore += 0;
            q3iiiImageView.setImageResource(R.mipmap.red_cross);
        }
        else q3iiiImageView.setImageResource(R.mipmap.red_cross);

        if (hasCheckBoxQ3iv) {
            userScore += 1;
            q3ivImageView.setImageResource(R.mipmap.green_tick);
        }
        else q3ivImageView.setImageResource(R.mipmap.red_cross);

        if (hasCheckBoxQ3v) {
            userScore += 1;
            q3vImageView.setImageResource(R.mipmap.green_tick);
        }
        else q3vImageView.setImageResource(R.mipmap.red_cross);

        //Check score for Q4
        //Reference: string comparison https://stackoverflow.com/questions/16143562/string-comparison-android/16143606#:~:text=The%20%3D%3D%20operator%20checks%20to,to%20compare%20strings%20for%20equality.
        final String Q4_i = "E";
        final String Q4_ii = "A";
        final String Q4_iii = "C";
        final String Q4_iv = "B";

        if (q4iAnswerEditText.getText().toString().equals(Q4_i)) {
            userScore += +1;
            q4iImageView.setImageResource(R.mipmap.green_tick);
        } else q4iImageView.setImageResource(R.mipmap.red_cross);

        if (q4iiAnswerEditText.getText().toString().equals(Q4_ii)) {
            userScore += +1;
            q4iiImageView.setImageResource(R.mipmap.green_tick);
        } else q4iiImageView.setImageResource(R.mipmap.red_cross);

        if (q4iiiAnswerEditText.getText().toString().equals(Q4_iii)) {
            userScore += +1;
            q4iiiImageView.setImageResource(R.mipmap.green_tick);
        } else q4iiiImageView.setImageResource(R.mipmap.red_cross);

        if (q4ivAnswerEditText.getText().toString().equals(Q4_iv)) {
            userScore += +1;
            q4ivImageView.setImageResource(R.mipmap.green_tick);
        } else q4ivImageView.setImageResource(R.mipmap.red_cross);

        //  Toast message to user with score
        Context context = getApplicationContext();
        CharSequence text = "You scored: " + userScore + " out of 10";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //reset User Score
        userScore = 0;
    }

    // reset answers clear all redgreen check boxes and user input views
    public void resetQuestions(View view) {
        userScore = 0;

        //reset Q1
        q1radioGroup.clearCheck();
        q1ImageView.setVisibility(View.INVISIBLE);

        //reset Q2
        q2TextView.setText("");
        q2ImageView.setVisibility(View.INVISIBLE);

        //reset Q3
        q3iCheckBox.setChecked(false);
        q3iiCheckBox.setChecked(false);
        q3iiiCheckBox.setChecked(false);
        q3ivCheckBox.setChecked(false);
        q3vCheckBox.setChecked(false);
        q3iImageView.setVisibility(View.INVISIBLE);
        q3iiImageView.setVisibility(View.INVISIBLE);
        q3iiiImageView.setVisibility(View.INVISIBLE);
        q3ivImageView.setVisibility(View.INVISIBLE);
        q3vImageView.setVisibility(View.INVISIBLE);

        //reset Q4
        q4iAnswerEditText.setText("");
        q4iiAnswerEditText.setText("");
        q4iiiAnswerEditText.setText("");
        q4ivAnswerEditText.setText("");
        q4iImageView.setVisibility(View.INVISIBLE);
        q4iiImageView.setVisibility(View.INVISIBLE);
        q4iiiImageView.setVisibility(View.INVISIBLE);
        q4ivImageView.setVisibility(View.INVISIBLE);
    }
}
