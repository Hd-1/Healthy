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

import activity.FavoriteTrainingActivity;
import activity.TrainingActivity;
import adapterRecyclerView.AdapterTrainingFavorite;
import content.FavoriteTrainingContent;
import data.Training;

public class FavoriteTrainingFragment extends Fragment implements AdapterTrainingFavorite.onTrainingListener{

    View trainingView;
    RecyclerView trainingList;
    AdapterTrainingFavorite adapterTraining;
    ArrayList<Training> trainings = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        trainingView = inflater.inflate(R.layout.fragment_favorite_training, container, false);

        trainingList = trainingView.findViewById(R.id.favoriteTrainingList);
        trainingList.hasFixedSize();
        trainingList.setLayoutManager(new LinearLayoutManager(getContext()));
        trainings = FavoriteTrainingContent.getTraining();

        adapterTraining = new AdapterTrainingFavorite(trainings,this);
        trainingList.setAdapter(adapterTraining);

        return trainingView;
    }

    @Override
    public void onTrainingClick(int position) {
        trainings.get(position);
        Intent intent = new Intent(getContext(), FavoriteTrainingActivity.class);
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