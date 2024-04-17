import io.reactivex.rxjava3.disposables.Disposable;

public class Main {
    public static void main(String[] args) {

        ToDoList toDoList = new ToDoList();
        ConsoleUI consoleUI = new ConsoleUI(toDoList);
        consoleUI.start();
        /*
        ToDoList toDoList = new ToDoList();

        Disposable disposable = toDoList.getTasksObservable()
                .subscribe(task -> System.out.println("Updated task: " + task));

        Task task1 = new Task("Hacer la compra");
        Task task2 = new Task("Estudiar");
        Task task3 = new Task("Ir a pasear");

        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);

        toDoList.completeTask(task1);

        toDoList.removeTask(task2);

        disposable.dispose();
        */
    }
}
