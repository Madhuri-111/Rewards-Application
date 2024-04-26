
public class TaskManager {
    private static volatile boolean isTaskDone = false;

    public static boolean isTaskDone() {
        return isTaskDone;
    }

    public static void setTaskDone(boolean taskDone) {
        isTaskDone = taskDone;
    }
}