package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.healthy.R;

import content.ScheduleContent;
import content.TrainingContent;
import data.Schedule;
import data.Training;

public class ScheduleActivity extends AppCompatActivity {

    Spinner spinnerHours,spinnerMinutes,spinnerDays;
    String hours,minutes,day;
    Bundle extras;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule2);

        extras = getIntent().getExtras();

        if(extras != null){
            position = extras.getInt("trainingPosition");
        }

        spinnerHours = findViewById(R.id.spinnerHour);
        spinnerMinutes = findViewById(R.id.spinnerMinutes);
        spinnerDays = findViewById(R.id.spinnerDays);

        ArrayAdapter<CharSequence> adapterHours = ArrayAdapter.createFromResource(this,R.array.hours,R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapterMinutes = ArrayAdapter.createFromResource(this,R.array.minutes,R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapterDays = ArrayAdapter.createFromResource(this,R.array.days,R.layout.support_simple_spinner_dropdown_item);

        adapterHours.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterMinutes.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterDays.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinnerHours.setAdapter(adapterHours);
        spinnerMinutes.setAdapter(adapterMinutes);
        spinnerDays.setAdapter(adapterDays);

        spinnerHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hours = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerMinutes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                minutes = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                day = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void addToSchedule(View v){
        Training t = TrainingContent.getTrainingByPosition(position);

        Schedule s = new Schedule(t.getTitle(),hours,minutes,day,t.getBanner(),t.getDescription(),t.getWarning(),t.getChallenge(),t.getSteps(),t.getImage1(),t.getImage2(),t.getImage3(),t.isFavStatus());

        ScheduleContent.addSchedule(s);

        Toast.makeText(this, "Added to Schedule", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void closeScheduleActivity(View v){
        finish();
    }
}