package content;

import java.util.ArrayList;

import data.Schedule;

public class ScheduleContent {

    static ArrayList<Schedule> scheduleList = new ArrayList<>();

    public static ArrayList<Schedule> getSchedule() {
        return scheduleList;
    }

    public static void addSchedule(Schedule schedule) {
        scheduleList.add(schedule);
    }

    public static void removeSchedule(int position) { scheduleList.remove(position); }
}
