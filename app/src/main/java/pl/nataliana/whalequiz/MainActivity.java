package pl.nataliana.whalequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] whaleQuestions = new String[]{
            "1. Baleen whales are in general faster and smaller than toothed whales",
            "2. All baleen whales have two blowholes, whilst toothed whales only have one",
            "3. There are currently more than 67 species of whales, dolphins and porpoises",
            "4. It is impossible to recognize doplhin by his whistle",
            "5. Whales can't see underwater - they only can use echolocation to know where they are",
            "6. Whales don't have a sense of smell",
            "7. Dolphins get all the water they need directly from the food they eat",
            "8. Dolphins, just like humans, have breathing reflex, thans to which they can still breath while sleeping",
            "9. Whales are born with a small amount of hair, which they loose when they get older",
            "10.  Dolphins breathe through a nostril, called a blowhole, located right on top of their heads"
    };

    private Boolean[] whaleAnswers = new Boolean[]{
            false,
            true,
            true,
            false,
            false,
            true,
            true,
            false,
            true,
            true
    };

    private int score = 0;
    private int actualQuestion = -1;
    Map<String, Integer> pictureMap = new HashMap<String, Integer>();
    public TextView question;
    private ImageView whalePictureView;
    private RadioButton trueRadio;
    private RadioButton falseRadio;
    private Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whalePictureView = (ImageView) findViewById(R.id.imageView);
        question = (TextView) findViewById(R.id.question);
        trueRadio = (RadioButton) findViewById(R.id.trueRadio);
        falseRadio = (RadioButton) findViewById(R.id.falseRadio);
        nextQuestion = (Button) findViewById(R.id.button);
        setImageMap();
        nextQuestion();
    }

    private void setImageMap() {
        pictureMap.put("w1", R.drawable.w1);
        pictureMap.put("w2", R.drawable.w2);
        pictureMap.put("w3", R.drawable.w3);
        pictureMap.put("w4", R.drawable.w4);
        pictureMap.put("w5", R.drawable.w5);
        pictureMap.put("w6", R.drawable.w6);
        pictureMap.put("w7", R.drawable.w7);
        pictureMap.put("w8", R.drawable.w8);
        pictureMap.put("w9", R.drawable.w9);
        pictureMap.put("w10", R.drawable.w10);
    }

    private void nextQuestion() {
        actualQuestion++;
        showQuestion(whaleQuestions[actualQuestion]);
        whalePictureView.setImageResource(pictureMap.get("w" + (actualQuestion + 1)));
        falseRadio.setChecked(false);
        trueRadio.setChecked(false);
    }

    public void clickTrue(View view) {
        if (whaleAnswers[actualQuestion] == true) {
            score++;
        }
    }

    public void clickFalse(View view) {
        if (whaleAnswers[actualQuestion] == false) {
            score++;
        }
    }

    public void next(View view) {
        if (actualQuestion < 9) {
            nextQuestion();
        } else {
            showScore();
        }
    }

    public void displayMessage(String score) {
        TextView scoreView = (TextView) findViewById(R.id.question);
        scoreView.setText(String.valueOf(score));
    }

    public void showScore() {
        falseRadio.setVisibility(View.INVISIBLE);
        trueRadio.setVisibility(View.INVISIBLE);
        nextQuestion.setVisibility(View.INVISIBLE);
        String messageString = "Your score is " + String.valueOf(score);
        displayMessage(messageString);

        if (score <= 2) {
            messageString += "\nYou are a sea horse. Learn more and you will be a bigger fish one day!";
            displayMessage(messageString);
        } else if (score <= 4) {
            messageString += "\nYou are a seal. Pretty sweet but not very powerful yet.";
            displayMessage(messageString);
        } else if (score <= 6) {
            messageString += "\nYou are a dolphin. I can tell you are an intelligent creature! Keep going this way!";
            displayMessage(messageString);
        } else if (score <= 8) {
            messageString += "\nYou are a killer whale. You are on the good track to become the ocean king!";
            displayMessage(messageString);
        } else if (score <= 10) {
            messageString += "\nYou are a whale. You know everything, everybody respects you, there is nothing in the world you couldn't achieve!";
            displayMessage(messageString);
        }
    }

    private void showQuestion(String message) {
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(message);
    }

}