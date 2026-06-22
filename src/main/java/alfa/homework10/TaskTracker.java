package alfa.homework10;

import java.util.ArrayList;

public class TaskTracker {
    private ArrayList<Task> taskList;

    public TaskTracker() {
        taskList = new ArrayList<>();
    }

    public TaskTracker(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void printTaskList() {
        taskList.forEach(Task::printTaskInfo);
    }

    public void setTaskIsDone(String taskName) {
        Task foundTask = getTaskFromListByTaskNameOrDefault(taskName);
        int index = taskList.indexOf(foundTask);
        if (foundTask.getTaskName() != null) {
            foundTask.setDone(true);
            taskList.set(index, foundTask);
        }
    }

    public boolean isTaskDone(String taskName) {
        Task foundTask = getTaskFromListByTaskNameOrDefault(taskName);
        return foundTask.isDone();
    }

    public void printTasksStatistic() {
        System.out.printf("""
                ___
                Всего задач: %d
                Выполнено: %d
                Открыто: %d
                ___
                """, taskList.size(),
                taskList.stream().filter(Task::isDone).count(),
                taskList.stream().filter(task -> !task.isDone()).count());
    }

    private Task getTaskFromListByTaskNameOrDefault(String taskName) {
        return taskList.stream().filter(task -> taskName.equals(task.getTaskName())).findFirst()
                .orElse(new Task());
    }
}
