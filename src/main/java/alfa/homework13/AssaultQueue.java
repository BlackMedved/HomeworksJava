package alfa.homework13;

import java.util.LinkedList;

public class AssaultQueue {
    private LinkedList<String> queue;

    public AssaultQueue() {
        queue = new LinkedList<>();
    }

    public void addRecruit(String name) {
        queue.addLast(name);
    }

    public String retreatCoward() {
        if (!queue.isEmpty()) return queue.removeFirst();
        else return "";
    }

    public void printQueue() {
        System.out.println(queue.toString());
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
