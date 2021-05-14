package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.healthy.R;

public class TrainingActivity extends AppCompatActivity {

    TextView mTrainingTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        mTrainingTitle = findViewById(R.id.trainingTitle);

        String trainingTitle = "Title not found";

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            trainingTitle = extras.getString("trainingTitle");
        }

        mTrainingTitle.setText(trainingTitle);
        getSupportActionBar().setTitle(trainingTitle);
    }
}