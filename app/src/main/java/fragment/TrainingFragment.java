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

    public void addTrainings(){
        String description = "You squat every time you sit or stand, but don’t take this exercise for granted. It works your legs and your glutes, the most powerful muscle group in the body.";
        String warning = "Be careful: Done incorrectly, squats can be hard on your knees. As you squat, keep your butt pushed out, like you are about to sit on a chair. Use the muscles in your hips and thighs to push yourself up; don’t press your knees forward as you move. If you’re doing it correctly, your knees will move only during the first half of the squat; your hips will finish the movement.";
        String challenge = "Challenge yourself: You can add some plyometric motion to a squat by jumping from the lowest position back into your starting stance.";
        String steps= "STEPS:\n" +
                "1. Stand with your hands on the back of your head and your feet shoulder-width apart with your feet turned out slightly to open the hip joint.\n" +
                "2. Lower your body until your thighs are parallel to the floor. \n" +
                "3. Pause, then return to the starting position. \n" +
                "4. Repeat.\n" +
                "Note: Intensify this by jumping up explosively from each squat and allowing your feet to lift off the floor.\n";

        String description1 = "There’s a reason push-ups are a go-to exercise for body builders. They effectively work the muscles in your shoulders and chest.";
        String warning1 = "Modify it: If standard push-ups are too challenging, try them with your knees on the floor. That will reduce the amount of weight you need to lift.";
        String challenge1 = "Challenge yourself: If basic push-ups are too easy, place your feet on a step or block to increase the intensity.";
        String steps1 = "STEPS:\n" +
                "\n" +
                "1. Get down on all fours, placing your hands slightly wider than your shoulders. \n" +
                "\n" +
                "2. Straighten your arms and legs. \n" +
                "\n" +
                "3. Lower your body until your chest nearly touches the floor. \n" +
                "\n" +
                "4. Pause, then push yourself back up. \n" +
                "\n" +
                "5. Repeat.  ";

        String description2 = "This exercise mimics the motion climbers make as they climb steep peaks, except it’s done on the soft, flat surface of your floor. Mountain climbers are total body workouts, building strength in your core, back, arms and legs — not to mention your heart.";
        String warning2 = "Modify it: If this exercise puts too much strain on your wrists, try elevating your upper body by placing your hands on a step to reduce the weight being placed on your arms. ";
        String challenge2 = "";
        String steps2 = "\n" +
                "STEPS:\n" +
                "\n" +
                "1. Put both hands and knees on the floor.\n" +
                "\n" +
                "2. Place your right foot near your right hand and extend your left leg behind you. \n" +
                "\n" +
                "3. In one smooth motion, switch your legs, keeping your arms in the same position. \n" +
                "\n" +
                "4. Switch your legs back and forth twice, such that your right leg is again close to your right hand.";

        String description3 = "A commonly seen exercise, plank helps build strength in the core, shoulders, arms and legs. Plank tones your abs and builds strength in your upper body. Additionally, planks strengthen both the abdominal and low back muscles simultaneously and can have a beneficial effect for people with low back pain.";
        String warning3 = "Be careful: Plank pose can be hard on your wrists, which is why we suggest doing a plank on your forearm.";
        String challenge3 = "Modify it: Place your knees on the floor as you do plank to reduce the weight resting on your forearms.";
        String steps3 = "STEPS:\n" +
                "\n" +
                "1. Assume a push-up position but bend your arms at your elbows so your weight rests on your forearms. \n" +
                "\n" +
                "2. Tighten your abs, clench your glutes and keep your body straight from head to heels. \n" +
                "\n" +
                "3. Hold as long as you can.  ";

        String description4 = "This variation on a squat really targets (the quadricep and hamstring muscles in your legs as well as the glutes. Jumping into your starting position from the lowest point in your squat also adds a plyometric boost.";
        String warning4 = "Be careful: If balance is an issue, you can do this exercise close to a wall, resting your hand on it for support.";
        String challenge4 = "Modify it: Omit the plyometric jump if you find this exercise too hard on your knees.\n" +
                "\n" +
                "Challenge yourself: Jump higher to really get your heart pumping and build more strength.";
        String steps4 = "STEPS:\n" +
                "\n" +
                "1. Place your hands on your hips and take a step forward with your left leg, so your stance is staggered. \n" +
                "\n" +
                "2. Slowly lower your body as far as you can.\n" +
                "\n" +
                "3. When you’re as low as you can go, jump with enough force to propel both feet off the floor. \n" +
                "\n" +
                "4. Land with your right leg forward. \n" +
                "\n" +
                "5. Alternate back and forth for the allotted time. \n" +
                "\n" +
                "6. Once you get the hang of this move you can swing your arms in opposition to your legs as if you're running.";

        String description5 = "This exercise is adapted from yoga and targets the muscles in your glutes and abs.";
        String warning5 = "Be careful: Keep your foot firmly planted on the floor as you do this exercise.";
        String challenge5 = "Challenge yourself: Place your stable foot on a step or bench as you do this exercise to allow you to raise your hips even higher..";
        String steps5 = "STEPS:\n" +
                "\n" +
                "1. Lie on your back with your right knee bent and right foot flat on the floor. \n" +
                "\n" +
                "2. Raise your left leg so it’s in line with your right thigh. \n" +
                "\n" +
                "3. Push your hips up, keeping your left leg elevated. \n" +
                "\n" +
                "4. Pause and slowly return to the starting position. \n" +
                "\n" +
                "5. Switch legs and repeat. ";

        String description6 = "Fun to say, but also great for your body, this total body exercise will get your heart pumping fast, but don’t sacrifice form for speed. Keep your body in control as you move through the exercise.";
        String warning6 = "Be careful: If you do burpees too quickly, you will soon be gasping for breath. Try to pace yourself and your breathing. Take an in breath before you squat and breathe out during the push-up.";
        String challenge6 = "Modify it: Add leg modifications to make this more difficult. Leg modifications can include putting the right leg into a 3 o’clock position and then bringing it back to center, then bringing the left leg to a 9 o’clock position and then bringing it back to center, and then doing a push-up. We call this the 3 o’clock 9 o’clock burpee.\n" +
                "\n" +
                "Challenge yourself: To move faster through your burpees, start stretching your legs back before your hands hit the ground. Also don’t arch your back as you move, to allow your legs full range of motion.";
        String steps6 = "STEPS:\n" +
                "\n" +
                "1. Stand with your feet shoulder-width apart. \n" +
                "\n" +
                "2. Squat as deeply as you can and place your hands on the floor. Kick back into a push-up position. \n" +
                "\n" +
                "3. Do one push-up. \n" +
                "\n" +
                "4. Bring your legs back to a squat and jump up, throwing your hands above your head.\n" +
                "\n" +
                "5. Land and repeat.  ";

        String description7 = "This exercise is a great way to tone your lower body. It helps to improve balance, while also targeting your hamstrings.";
        String warning7 = "Be careful: If you have balance issues, do this exercise near a wall that you can hang onto for support if you need to.";
        String challenge7 = "Challenge Yourself: To make this more difficult, put a little hop in your planted leg when you stand up. This turns this exercise from isokinetic to plyometric and increases the degree of difficulty.";
        String steps7 = "STEPS\n" +
                "\n" +
                "1. Stand on your right leg with your left leg slightly behind you, raised off the floor. \n" +
                "\n" +
                "2. Place your arms straight out to your sides at shoulder height. \n" +
                "\n" +
                "3. Bend your right leg at the knee and squat down to touch your left hand to the toe of your right foot, then come back up. Try to keep your leg in the air behind you the entire time.\n" +
                "\n" +
                "4. Repeat motion with your left leg.\n" +
                "\n" +
                "5. Repeat.";

        String description8 = "Build your core strength without getting off the floor. The legs down exercise is great for lower back pain, but be sure move your legs in a controlled manner throughout the exercise.";
        String warning8 = "Be careful: As you raise your legs, press your lower back into the floor and engage your ab muscles. This will ensure that your core is doing most of the work, not your hips.";
        String challenge8 = "";
        String steps8 = "STEPS\n" +
                "\n" +
                "1. Lie on your back, legs straight and together. \n" +
                "\n" +
                "2. Keep your legs straight and lift them all the way up to the ceiling until your butt comes off the floor. \n" +
                "\n" +
                "3. Slowly lower your legs back down till they’re just above the floor. Hold for a moment.\n" +
                "\n" +
                "4. Raise your legs back up. Repeat.";

        trainings.add(new Training("Bodyweight Squat",R.drawable.pbanner1,description,warning,challenge,steps,R.drawable.p1,R.drawable.p2,R.drawable.p3));
        trainings.add(new Training("Push-Up",R.drawable.pbanner4,description1,warning1, challenge1,steps1,R.drawable.p4,R.drawable.p5,R.drawable.p6));
        trainings.add(new Training("Mountain Climbers",R.drawable.pbanner7,description2,warning2,challenge2,steps2,R.drawable.p7,R.drawable.p8,R.drawable.p9));
        trainings.add(new Training("Plank",R.drawable.pbanner10,description3,warning3,challenge3,steps3,R.drawable.p11,R.drawable.p12,R.drawable.p10));
        trainings.add(new Training("Bodyweight Split Squat",R.drawable.pbanner13,description4,warning4,challenge4,steps4,R.drawable.p14,R.drawable.p13,R.drawable.p15));
        trainings.add(new Training("Single-Leg Hip Raise",R.drawable.pbanner16,description5,warning5,challenge5,steps5,R.drawable.p17,R.drawable.p18,R.drawable.p16));
        trainings.add(new Training("Burpee With Push-Up",R.drawable.pbanner19,description6,warning6,challenge6,steps6,R.drawable.p21,R.drawable.p20,R.drawable.p19));
        trainings.add(new Training("Single-Leg Toe Touches",R.drawable.pbanner22,description7,warning7,challenge7,steps7,R.drawable.p23,R.drawable.p22,R.drawable.p24));
        trainings.add(new Training("Leg Raises",R.drawable.pbanner25,description8,warning8,challenge8,steps8,R.drawable.p26,R.drawable.p27,R.drawable.p25));
    }

}