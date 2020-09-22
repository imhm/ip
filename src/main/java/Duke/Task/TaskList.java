package Duke.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskList;
    private int totalTask = 0;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        totalTask++;
    }

    public void deleteTask(int taskNumber) {
        taskList.remove(taskNumber);
        totalTask--;
    }

    public void markTaskAsDone(int taskNumber) {
        taskList.get(taskNumber - 1).markAsDone();
    }

    public int getTotalTask() {
        return totalTask;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

}
