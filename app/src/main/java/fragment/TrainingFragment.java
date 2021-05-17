package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthy.R;

import java.util.ArrayList;

import activity.TrainingActivity;
import adapterRecyclerView.AdapterTraining;
import data.Training;

public class TrainingFragment extends Fragment implements AdapterTraining.onTrainingListener{

    View trainingView;
    RecyclerView trainingList;
    AdapterTraining adapterTraining;
    ArrayList<Training> trainings = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        trainingView = inflater.inflate(R.layout.fragment_training, container, false);

        trainingList = trainingView.findViewById(R.id.trainingList);
        trainingList.hasFixedSize();
        trainingList.setLayoutManager(new LinearLayoutManager(getContext()));

        addTrainings();

        adapterTraining = new AdapterTraining(trainings,this);
        trainingList.setAdapter(adapterTraining);

       return trainingView;
    }

    @Override
    public void onTrainingClick(int position) {
        trainings.get(position);
        Intent intent = new Intent(getContext(), TrainingActivity.class);
        intent.putExtra("trainingTitle",trainings.get(position).getTitle());
        intent.putExtra("trainingDescription",trainings.get(position).getDescription());
        intent.putExtra("trainingWarning",trainings.get(position).getWarning());
        intent.putExtra("trainingChallenge",trainings.get(position).getChallenge());
        intent.putExtra("trainingSteps",trainings.get(position).getSteps());
        intent.putExtra("imageOne",trainings.get(position).getImage1());
        intent.putExtra("imageTwo",trainings.get(position).getImage2());
        intent.putExtra("imageThree",trainings.get(position).getImage3());
        startActivity(intent);
    }

    //CONTENT
    public void addTrainings(){
        setAllValues();

        trainings.add(new Training("Bodyweight Squat",R.drawable.pbanner1,description0,warning0,challenge0,steps0,R.drawable.p1,R.drawable.p2,R.drawable.p3));
        trainings.add(new Training("Push-Up",R.drawable.pbanner4,description1,warning1, challenge1,steps1,R.drawable.p4,R.drawable.p5,R.drawable.p6));
        trainings.add(new Training("Mountain Climbers",R.drawable.pbanner7,description2,warning2,challenge2,steps2,R.drawable.p7,R.drawable.p8,R.drawable.p9));
        trainings.add(new Training("Plank",R.drawable.pbanner10,description3,warning3,challenge3,steps3,R.drawable.p11,R.drawable.p12,R.drawable.p10));
        trainings.add(new Training("Bodyweight Split Squat",R.drawable.pbanner13,description4,warning4,challenge4,steps4,R.drawable.p14,R.drawable.p13,R.drawable.p15));
        trainings.add(new Training("Single-Leg Hip Raise",R.drawable.pbanner16,description5,warning5,challenge5,steps5,R.drawable.p17,R.drawable.p18,R.drawable.p16));
        trainings.add(new Training("Burpee With Push-Up",R.drawable.pbanner19,description6,warning6,challenge6,steps6,R.drawable.p21,R.drawable.p20,R.drawable.p19));
        trainings.add(new Training("Single-Leg Toe Touches",R.drawable.pbanner22,description7,warning7,challenge7,steps7,R.drawable.p23,R.drawable.p22,R.drawable.p24));
        trainings.add(new Training("Leg Raises",R.drawable.pbanner25,description8,warning8,challenge8,steps8,R.drawable.p26,R.drawable.p27,R.drawable.p25));
    }

    //ALL VALUES
    String description0,description1,description2,description3,description4,description5,description6,description7,description8,warning0,warning1,warning2,warning3,warning4,warning5,warning6,warning7,warning8,
            challenge0,challenge1,challenge2,challenge3,challenge4,challenge5,challenge6,challenge7,challenge8,steps0,steps1,steps2,steps3,steps4,steps5,steps6,steps7,steps8;

    private void setAllValues() {

        description0 = getResources().getString(R.string.description0);
        warning0 = getResources().getString(R.string.warning0);
        challenge0 = getResources().getString(R.string.challenge0);
        steps0= getResources().getString(R.string.steps0);

        description1 = getResources().getString(R.string.description1);;
        warning1 = getResources().getString(R.string.warning1);
        challenge1 = getResources().getString(R.string.challenge1);
        steps1 = getResources().getString(R.string.steps1);

        description2 = getResources().getString(R.string.description2);;
        warning2 = getResources().getString(R.string.warning2);
        challenge2 = getResources().getString(R.string.challenge2);
        steps2 = getResources().getString(R.string.steps2);

        description3 = getResources().getString(R.string.description3);;
        warning3 = getResources().getString(R.string.warning3);
        challenge3 = getResources().getString(R.string.challenge3);
        steps3 = getResources().getString(R.string.steps3);

        description4 = getResources().getString(R.string.description4);;
        warning4 = getResources().getString(R.string.warning4);
        challenge4 = getResources().getString(R.string.challenge4);
        steps4 = getResources().getString(R.string.steps4);

        description5 = getResources().getString(R.string.description5);
        warning5 = getResources().getString(R.string.warning5);
        challenge5 = getResources().getString(R.string.challenge5);
        steps5 = getResources().getString(R.string.steps5);

        description6 = getResources().getString(R.string.description6);;
        warning6 = getResources().getString(R.string.warning6);
        challenge6 = getResources().getString(R.string.challenge6);
        steps6 = getResources().getString(R.string.steps6);

        description7 = getResources().getString(R.string.description6);;
        warning7 = getResources().getString(R.string.warning7);
        challenge7 = getResources().getString(R.string.challenge7);
        steps7 = getResources().getString(R.string.steps7);

        description8 = getResources().getString(R.string.description7);;
        warning8 = getResources().getString(R.string.warning8);
        challenge8 = getResources().getString(R.string.challenge8);
        steps8 = getResources().getString(R.string.steps8);


    }

}