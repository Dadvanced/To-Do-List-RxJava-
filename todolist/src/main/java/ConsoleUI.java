import java.util.Scanner;

public class ConsoleUI {
    private final ToDoList toDoList;

    public ConsoleUI(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n--- To-Do List ---");
            displayTasks();

            System.out.println("\nOpciones:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese la descripción de la nueva tarea: ");
                    String description = scanner.nextLine();
                    Task newTask = new Task(description);
                    toDoList.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Ingrese el número de la tarea que desea marcar como completada: ");
                    int completeIndex = scanner.nextInt();
                    toDoList.completeTask(toDoList.getTasks().get(completeIndex - 1));
                    break;
                case 3:
                    System.out.print("Ingrese el número de la tarea que desea eliminar: ");
                    int removeIndex = scanner.nextInt();
                    toDoList.removeTask(toDoList.getTasks().get(removeIndex - 1));
                    break;
                case 4:
                    System.out.println("¡Adiós!");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private void displayTasks() {
        int index = 1;
        for (Task task : toDoList.getTasks()) {
            System.out.println(index + ". " + task);
            index++;
        }
    }
}
