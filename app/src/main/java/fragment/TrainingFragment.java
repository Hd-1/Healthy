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

    public void addTrainings(){
        trainings.add(new Training("First"));
        trainings.add(new Training("Second"));
        trainings.add(new Training("Third"));
        trainings.add(new Training("First"));
        trainings.add(new Training("Second"));
        trainings.add(new Training("Third"));
        trainings.add(new Training("First"));
        trainings.add(new Training("Second"));
        trainings.add(new Training("Third"));
        trainings.add(new Training("First"));
        trainings.add(new Training("Second"));
        trainings.add(new Training("Third"));
    }

    @Override
    public void onTrainingClick(int position) {
        trainings.get(position);
        Intent intent = new Intent(getContext(), TrainingActivity.class);
        intent.putExtra("trainingTitle",trainings.get(position).getTitle());
        startActivity(intent);
    }
}