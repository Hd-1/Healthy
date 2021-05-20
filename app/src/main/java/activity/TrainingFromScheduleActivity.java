package activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthy.R;

public class TrainingFromScheduleActivity extends AppCompatActivity {

    TextView mTrainingTitle, mTrainingDescription, mWarningTraining, mStepTraining, mChallengeTraining,mScheduleDate;
    ImageView mImageTrainingOne,mImageTrainingTwo,mImageTrainingThree;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_schedule);

        mScheduleDate = findViewById(R.id.trainingDate);
        mTrainingTitle = findViewById(R.id.scheduleTitle);
        mTrainingDescription = findViewById(R.id.descriptionSchedule);
        mWarningTraining = findViewById(R.id.warningSchedule);
        mStepTraining = findViewById(R.id.stepSchedule);
        mChallengeTraining = findViewById(R.id.challengeSchedule);
        mImageTrainingOne = findViewById(R.id.imageScheduleOne);
        mImageTrainingTwo = findViewById(R.id.imageScheduleTwo);
        mImageTrainingThree =findViewById(R.id.imageScheduleThree);

        String date = "Date not found";
        String trainingTitle = "Title not found";
        String trainingDescription = "Description not found";
        String trainingWarning = "Warning not found";
        String trainingChallenge = "Challenge not found";
        String trainingSteps = "Steps not found";
        int image1 = 0;
        int image2 = 0;
        int image3 = 0;

        extras = getIntent().getExtras();

        if(extras != null){
            date = extras.getString("trainingDate");
            trainingTitle = extras.getString("trainingTitle");
            trainingDescription = extras.getString("trainingDescription");
            trainingWarning = extras.getString("trainingWarning");
            trainingChallenge = extras.getString("trainingChallenge");
            trainingSteps = extras.getString("trainingSteps");
            image1 = extras.getInt("imageOne");
            image2 = extras.getInt("imageTwo");
            image3 = extras.getInt("imageThree");
        }

        mScheduleDate.setText(date);
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
