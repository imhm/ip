import java.util.Arrays;

public class Task {
    protected String description;
    protected boolean isDone;

    private static int totalTask = 0;

    public static final int MAX_TASK = 100;

    public static Task[] taskList = new Task[MAX_TASK];

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        totalTask++;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public static void setTaskList(Task taskList) {
        Task.taskList[totalTask - 1] = taskList;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public static int getTotalTask() {
        return totalTask;
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone() {
        this.isDone = true;
    }
}
