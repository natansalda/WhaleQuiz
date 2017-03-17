package pl.nataliana.whalequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void startQuiz (View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        EditText txtname = (EditText) findViewById(R.id.textName);
        String name = txtname.getText().toString();
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("name", name);
        startActivity(i);
    }
}
