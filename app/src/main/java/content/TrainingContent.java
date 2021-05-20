package content;

import android.content.Context;

import com.example.healthy.R;

import java.util.ArrayList;

import data.Training;

public class TrainingContent {

    static ArrayList<Training> trainings = new ArrayList<>();
    static private Context context;

    //ALL VALUES
    static String description0,description1,description2,description3,description4,description5,description6,description7,description8,warning0,warning1,warning2,warning3,warning4,warning5,warning6,warning7,warning8,
            challenge0,challenge1,challenge2,challenge3,challenge4,challenge5,challenge6,challenge7,challenge8,steps0,steps1,steps2,steps3,steps4,steps5,steps6,steps7,steps8;

    public TrainingContent(Context context) {
        TrainingContent.context = context;
    }

    //CONTENT
    public static void addTrainings(){
        setAllValues();

        trainings.add(new Training("Bodyweight Squat", R.drawable.pbanner1,description0,warning0,challenge0,steps0,R.drawable.p1,R.drawable.p2,R.drawable.p3,false));
        trainings.add(new Training("Push-Up",R.drawable.pbanner4,description1,warning1, challenge1,steps1,R.drawable.p4,R.drawable.p5,R.drawable.p6,false));
        trainings.add(new Training("Mountain Climbers",R.drawable.pbanner7,description2,warning2,challenge2,steps2,R.drawable.p7,R.drawable.p8,R.drawable.p9,false));
        trainings.add(new Training("Plank",R.drawable.pbanner10,description3,warning3,challenge3,steps3,R.drawable.p11,R.drawable.p12,R.drawable.p10,false));
        trainings.add(new Training("Bodyweight Split Squat",R.drawable.pbanner13,description4,warning4,challenge4,steps4,R.drawable.p14,R.drawable.p13,R.drawable.p15,false));
        trainings.add(new Training("Single-Leg Hip Raise",R.drawable.pbanner16,description5,warning5,challenge5,steps5,R.drawable.p17,R.drawable.p18,R.drawable.p16,false));
        trainings.add(new Training("Burpee With Push-Up",R.drawable.pbanner19,description6,warning6,challenge6,steps6,R.drawable.p21,R.drawable.p20,R.drawable.p19,false));
        trainings.add(new Training("Single-Leg Toe Touches",R.drawable.pbanner22,description7,warning7,challenge7,steps7,R.drawable.p23,R.drawable.p22,R.drawable.p24,false));
        trainings.add(new Training("Leg Raises",R.drawable.pbanner25,description8,warning8,challenge8,steps8,R.drawable.p26,R.drawable.p27,R.drawable.p25,false));
    }

    public static void removeAllTrainings(){
        trainings.clear();
    }

    private static void setAllValues() {

        description0 = context.getResources().getString(R.string.description0);
        warning0 = context.getResources().getString(R.string.warning0);
        challenge0 = context.getResources().getString(R.string.challenge0);
        steps0= context.getResources().getString(R.string.steps0);

        description1 = context.getResources().getString(R.string.description1);;
        warning1 = context.getResources().getString(R.string.warning1);
        challenge1 = context.getResources().getString(R.string.challenge1);
        steps1 = context.getResources().getString(R.string.steps1);

        description2 = context.getResources().getString(R.string.description2);;
        warning2 = context.getResources().getString(R.string.warning2);
        challenge2 = context.getResources().getString(R.string.challenge2);
        steps2 = context.getResources().getString(R.string.steps2);

        description3 = context.getResources().getString(R.string.description3);;
        warning3 = context.getResources().getString(R.string.warning3);
        challenge3 = context.getResources().getString(R.string.challenge3);
        steps3 = context.getResources().getString(R.string.steps3);

        description4 = context.getResources().getString(R.string.description4);;
        warning4 = context.getResources().getString(R.string.warning4);
        challenge4 = context.getResources().getString(R.string.challenge4);
        steps4 = context.getResources().getString(R.string.steps4);

        description5 = context.getResources().getString(R.string.description5);
        warning5 = context.getResources().getString(R.string.warning5);
        challenge5 = context.getResources().getString(R.string.challenge5);
        steps5 = context.getResources().getString(R.string.steps5);

        description6 = context.getResources().getString(R.string.description6);;
        warning6 = context.getResources().getString(R.string.warning6);
        challenge6 = context.getResources().getString(R.string.challenge6);
        steps6 = context.getResources().getString(R.string.steps6);

        description7 = context.getResources().getString(R.string.description6);;
        warning7 = context.getResources().getString(R.string.warning7);
        challenge7 = context.getResources().getString(R.string.challenge7);
        steps7 = context.getResources().getString(R.string.steps7);

        description8 = context.getResources().getString(R.string.description7);;
        warning8 = context.getResources().getString(R.string.warning8);
        challenge8 = context.getResources().getString(R.string.challenge8);
        steps8 = context.getResources().getString(R.string.steps8);
    }

    public static ArrayList<Training> getTrainings() {
        return trainings;
    }

    public static Training getTrainingByPosition(int position){return trainings.get(position);}

    public static void setTrainings(ArrayList<Training> trainings) {
        TrainingContent.trainings = trainings;
    }
}
