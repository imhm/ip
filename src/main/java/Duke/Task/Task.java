package Duke.Task;

import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;

    private static int totalTask = 0;

    public static ArrayList<Task> taskList = new ArrayList<>();

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        totalTask++;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public static void setTaskList(Task task) {
        taskList.add(task);
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

    public static void deleteTask(int taskNumber) {
        taskList.remove(taskNumber);
        totalTask--;
    }
}
