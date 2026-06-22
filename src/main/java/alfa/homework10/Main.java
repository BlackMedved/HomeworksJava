package alfa.homework10;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static void main() {
        ArrayList<Task> listOfTasks = new ArrayList<>();
        Collections.addAll(listOfTasks, new Task("Проснуться пораньше"),
                new Task("Выпить кофе"), new Task("Принять душ"));
        TaskTracker taskTracker = new TaskTracker(listOfTasks);
        taskTracker.printTaskList();
        System.out.println("Задача \"Принять душ\" выполнена? " + (taskTracker.isTaskDone("Принять душ") ?
                "Да" : "Нет"));
        taskTracker.setTaskIsDone("Выпить кофе");
        taskTracker.addTask(new Task("Собрать кровать", true));
        taskTracker.setTaskIsDone("Принять душ");
        taskTracker.printTaskList();
        taskTracker.printTasksStatistic();
    }
}
