package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthy.R;

public class TrainingActivity extends AppCompatActivity {

    TextView mTrainingTitle, mTrainingDescription, mWarningTraining, mStepTraining, mChallengeTraining;
    ImageView mImageTrainingOne,mImageTrainingTwo,mImageTrainingThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        mTrainingTitle = findViewById(R.id.trainingTitle);
        mTrainingDescription = findViewById(R.id.descriptionTraining);
        mWarningTraining = findViewById(R.id.warningTraining);
        mStepTraining = findViewById(R.id.stepTraining);
        mChallengeTraining = findViewById(R.id.challengeTraining);
        mImageTrainingOne = findViewById(R.id.imageTrainingOne);
        mImageTrainingTwo = findViewById(R.id.imageTrainingTwo);
        mImageTrainingThree =findViewById(R.id.imageTrainingThree);

        String trainingTitle = "Title not found";
        String trainingDescription = "Description not found";
        String trainingWarning = "Warning not found";
        String trainingChallenge = "Challenge not found";
        String trainingSteps = "Steps not found";
        int image1 = 0;
        int image2 = 0;
        int image3 = 0;

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            trainingTitle = extras.getString("trainingTitle");
            trainingDescription = extras.getString("trainingDescription");
            trainingWarning = extras.getString("trainingWarning");
            trainingChallenge = extras.getString("trainingChallenge");
            trainingSteps = extras.getString("trainingSteps");
            image1 = extras.getInt("imageOne");
            image2 = extras.getInt("imageTwo");
            image3 = extras.getInt("imageThree");
        }

        mTrainingTitle.setText(trainingTitle);
        mTrainingDescription.setText(trainingDescription);
        mWarningTraining.setText(trainingWarning);
        mStepTraining.setText(trainingSteps);
        mChallengeTraining.setText(trainingChallenge);
        mImageTrainingOne.setImageResource(image1);
        mImageTrainingTwo.setImageResource(image2);
        mImageTrainingThree.setImageResource(image3);


        getSupportActionBar().setTitle(trainingTitle);
    }
}