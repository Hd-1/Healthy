package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthy.R;

public class FavoriteTrainingActivity extends AppCompatActivity {

    TextView mTrainingTitle, mTrainingDescription, mWarningTraining, mStepTraining, mChallengeTraining;
    ImageView mImageTrainingOne,mImageTrainingTwo,mImageTrainingThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_training);

        mTrainingTitle = findViewById(R.id.favoriteTrainingTitle);
        mTrainingDescription = findViewById(R.id.favoriteDescriptionTraining);
        mWarningTraining = findViewById(R.id.favoriteWarningTraining);
        mStepTraining = findViewById(R.id.favoriteStepTraining);
        mChallengeTraining = findViewById(R.id.favoriteChallengeTraining);
        mImageTrainingOne = findViewById(R.id.favoriteImageTrainingOne);
        mImageTrainingTwo = findViewById(R.id.favoriteImageTrainingTwo);
        mImageTrainingThree =findViewById(R.id.favoriteImageTrainingThree);

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