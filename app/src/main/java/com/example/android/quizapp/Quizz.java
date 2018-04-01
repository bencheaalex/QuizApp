package com.example.android.quizapp;

        import android.content.Intent;
        import android.os.CountDownTimer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.ScrollView;
        import android.widget.TextView;
        import android.widget.Toast;

public class Quizz extends AppCompatActivity {

    int score;
    int counter;
    Button reset, home;
    RadioButton[] answersQuestion1 = new RadioButton[4];
    CheckBox[] answersQuestion2 = new CheckBox[4];
    RadioButton[] answersQuestion3 = new RadioButton[4];
    CheckBox[] answersQuestion4 = new CheckBox[4];
    EditText answerQuestion5;
    String answerQ5;
    RadioButton[] answersQuestion6 = new RadioButton[3];
    RadioButton[] answersQuestion7 = new RadioButton[3];
    RadioButton[] answersQuestion8 = new RadioButton[3];
    RadioButton[] answersQuestion9 = new RadioButton[3];
    RadioButton[] answersQuestion10 = new RadioButton[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        reset = findViewById(R.id.reset_button);
        home = findViewById(R.id.home_button);

        answersQuestion1[0] = findViewById(R.id.football_q1_a1);
        answersQuestion1[1] = findViewById(R.id.football_q1_a2);
        answersQuestion1[2] = findViewById(R.id.football_q1_a3);
        answersQuestion1[3] = findViewById(R.id.football_q1_a4);
        answersQuestion2[0] = findViewById(R.id.football_q2_a1);
        answersQuestion2[1] = findViewById(R.id.football_q2_a2);
        answersQuestion2[2] = findViewById(R.id.football_q2_a3);
        answersQuestion2[3] = findViewById(R.id.football_q2_a4);
        answersQuestion3[0] = findViewById(R.id.football_q3_a1);
        answersQuestion3[1] = findViewById(R.id.football_q3_a2);
        answersQuestion3[2] = findViewById(R.id.football_q3_a3);
        answersQuestion3[3] = findViewById(R.id.football_q3_a4);
        answersQuestion4[0] = findViewById(R.id.football_q4_a1);
        answersQuestion4[1] = findViewById(R.id.football_q4_a2);
        answersQuestion4[2] = findViewById(R.id.football_q4_a3);
        answersQuestion4[3] = findViewById(R.id.football_q4_a4);
        answerQuestion5 = findViewById(R.id.football_q5_a);
        answersQuestion6[0] = findViewById(R.id.ski_q1_a1);
        answersQuestion6[1] = findViewById(R.id.ski_q1_a2);
        answersQuestion6[2] = findViewById(R.id.ski_q1_a3);
        answersQuestion7[0] = findViewById(R.id.ski_q2_a1);
        answersQuestion7[1] = findViewById(R.id.ski_q2_a2);
        answersQuestion7[2] = findViewById(R.id.ski_q2_a3);
        answersQuestion8[0] = findViewById(R.id.ski_q3_a1);
        answersQuestion8[1] = findViewById(R.id.ski_q3_a2);
        answersQuestion8[2] = findViewById(R.id.ski_q3_a3);
        answersQuestion9[0] = findViewById(R.id.ski_q4_a1);
        answersQuestion9[1] = findViewById(R.id.ski_q4_a2);
        answersQuestion9[2] = findViewById(R.id.ski_q4_a3);
        answersQuestion10[0] = findViewById(R.id.ski_q5_a1);
        answersQuestion10[1] = findViewById(R.id.ski_q5_a2);
        answersQuestion10[2] = findViewById(R.id.ski_q5_a3);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //when reset button is clicked, the page is reloaded
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent footballIntent = new Intent(Quizz.this, Quizz.class);
                startActivity(footballIntent);

            }
        });

        //when the home button is clicked, the MainActivity intent is opened
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent footballIntent = new Intent(Quizz.this, MainActivity.class);
                startActivity(footballIntent);

            }
        });

    }

    //method for the submit button that will call the submitMethod only if all the questions were answered
    public void submit(View view) {
        counter = 0;
        verify();
        if (counter != 10)
            Toast.makeText(this, "Please respond to all questions!", Toast.LENGTH_SHORT).show();
        else submitMethod();
    }

    //method that verify the answers and display the score
    public void submitMethod() {
        score = 0;
        if (answersQuestion1[1].isChecked())
            score += 1;
        if (answersQuestion2[0].isChecked() && answersQuestion2[2].isChecked())
            score += 1;
        if (answersQuestion3[1].isChecked())
            score += 1;
        if (answersQuestion4[0].isChecked() && answersQuestion4[2].isChecked() && answersQuestion4[3].isChecked())
            score += 1;
        answerQ5 = answerQuestion5.getText().toString();
        if ("Portugal".equalsIgnoreCase(answerQ5))
            score += 1;
        if (answersQuestion6[1].isChecked())
            score += 1;
        if (answersQuestion7[1].isChecked())
            score += 1;
        if (answersQuestion8[2].isChecked())
            score += 1;
        if (answersQuestion9[1].isChecked())
            score += 1;
        if (answersQuestion10[2].isChecked())
            score += 1;

        Toast.makeText(this, "You finished the Quiz!\nYour score is:  " + score + " out of 10!", Toast.LENGTH_LONG).show();

    }

    //method that verify if all questions were answered
    public void verify() {
        for (int i = 0; i < 4; i++) {
            if (answersQuestion1[i].isChecked())
                counter++;
            if (answersQuestion3[i].isChecked())
                counter++;
        }
        for (int i = 0; i < 3; i++) {
            if (answersQuestion6[i].isChecked())
                counter++;
            if (answersQuestion7[i].isChecked())
                counter++;
            if (answersQuestion8[i].isChecked())
                counter++;
            if (answersQuestion9[i].isChecked())
                counter++;
            if (answersQuestion10[i].isChecked())
                counter++;
        }
        if (answersQuestion2[0].isChecked() || answersQuestion2[1].isChecked() || answersQuestion2[2].isChecked() || answersQuestion2[3].isChecked())
            counter++;
        if (answersQuestion4[0].isChecked() || answersQuestion4[1].isChecked() || answersQuestion4[2].isChecked() || answersQuestion4[3].isChecked())
            counter++;
        answerQ5 = answerQuestion5.getText().toString();
        if (answerQ5.length() > 0)
            counter++;
    }

}
