import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Título: " + title + "\nDescrição: " + description;
    }
}

public class ToDoList {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void addTask(String title, String description) {
        Task newTask = new Task(title, description);
        tasks.add(newTask);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa adicionada.");
        } else {
            System.out.println("Tarefas:");
            for (Task task : tasks) {
                System.out.println(task);
                System.out.println("-------------------");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (option) {
                case 1:
                    System.out.print("Título da tarefa: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição da tarefa: ");
                    String description = scanner.nextLine();
                    addTask(title, description);
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 3);

        scanner.close();
    }
}
