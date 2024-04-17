import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final List<Task> tasks;
    private final PublishSubject<Task> taskSubject; // event emitter

    public ToDoList() {
        tasks = new ArrayList<>();
        taskSubject = PublishSubject.create();
    }

    public void addTask(Task task) {
        tasks.add(task);
        taskSubject.onNext(task);
    }

    public void completeTask(Task task) {
        task.setCompleted(true);
        taskSubject.onNext(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        taskSubject.onNext(task);
    }

    public Observable<Task> getTasksObservable() {
        return taskSubject;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
