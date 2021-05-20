package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import content.DishesContent;
import content.TrainingContent;
import data.Training;

public class TrainingFragment extends Fragment implements AdapterTraining.onTrainingListener{

    View trainingView;
    RecyclerView trainingList;
    AdapterTraining adapterTraining;
    ArrayList<Training> trainings = TrainingContent.getTrainings();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        trainingView = inflater.inflate(R.layout.fragment_training, container, false);

        trainingList = trainingView.findViewById(R.id.trainingList);
        trainingList.hasFixedSize();
        trainingList.setLayoutManager(new LinearLayoutManager(getContext()));



        adapterTraining = new AdapterTraining(trainings,this);
        trainingList.setAdapter(adapterTraining);

       return trainingView;
    }

    @Override
    public void onTrainingClick(int position) {
        trainings.get(position);
        Intent intent = new Intent(getContext(), TrainingActivity.class);
        intent.putExtra("trainingPosition",position);
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

}