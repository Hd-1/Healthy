package content;

import java.util.ArrayList;

import data.Training;

public class FavoriteTrainingContent {

    static ArrayList<Training> trainingList = new ArrayList<>();

    public static ArrayList<Training> getTraining() {
        return trainingList;
    }

    public static void addTraining(Training training) {
        trainingList.add(training);
    }

    public static void removeTraining(int position) { trainingList.remove(position); }
}
