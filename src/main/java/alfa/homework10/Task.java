package alfa.homework10;

public class Task {
    private String taskName;
    private boolean isDone;

    public Task() {}

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(String taskName, boolean isDone) {
        this.taskName = taskName;
        this.isDone = isDone;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void printTaskInfo() {
        System.out.printf("[%s] %s\n", isDone ? "x" : " ", taskName);
    }
}
