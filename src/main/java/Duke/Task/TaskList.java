package Duke.Task;

import java.util.ArrayList;

/**
 * Represents a task list.
 */
public class TaskList {

    private ArrayList<Task> taskList;
    private int totalTask = 0;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task to be added.
     */
    public void addTask(Task task) {
        taskList.add(task);
        totalTask++;
    }

    /**
     * Deletes the task from the task list.
     *
     * @param taskNumber of the task to be deleted.
     */
    public void deleteTask(int taskNumber) {
        taskList.remove(taskNumber);
        totalTask--;
    }

    /**
     * Sets the task as done.
     *
     * @param taskNumber of the task that is completed.
     */
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
