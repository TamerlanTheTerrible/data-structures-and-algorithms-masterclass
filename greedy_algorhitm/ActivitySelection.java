package greedy_algorhitm;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Temurbek Ismoilov on 01/02/23.
 */

public class ActivitySelection {
    public static void activitySelection(ArrayList<Activity> activityList) {
        Comparator<Activity> finishTimeComparator = Comparator.comparingInt(Activity::getFinishTime);
        activityList.sort(finishTimeComparator);

        Activity previousActivity = activityList.get(0);
        System.out.println("\n\nRecommended Schedule:\n" + previousActivity);
        for (int i = 1; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);
            if (activity.getStartTime() >= previousActivity.getFinishTime()) {
                System.out.println(activity);
                previousActivity = activity;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1", 0, 6));
        activities.add(new Activity("A2", 3, 4));
        activities.add(new Activity("A3", 1, 2));
        activities.add(new Activity("A4", 5, 8));
        activities.add(new Activity("A5", 5, 7));
        activities.add(new Activity("A6", 8, 9));

        ActivitySelection.activitySelection(activities  );
    }
}
