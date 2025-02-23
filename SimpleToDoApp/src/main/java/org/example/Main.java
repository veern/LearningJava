package org.example;

import java.util.*;


public class Main {
    static Map<Integer, String> tasksInApp = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput;
            String taskValue;
            int taskToDelete;
            System.out.println("Witaj w apce To-Do!");
            while (true) {
                System.out.println("Co chciałbyś zrobić? (addtask - 1, removetask - 2, listtasks - 3, exit - 4)");
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        System.out.println("Jaka jest tresc nowego zadania?");
                        taskValue = scanner.nextLine();
                        addTask(taskValue);
                        break;
                    case "2":
                        System.out.println("Ktore zadanie chcesz usunac? Wpisz '0' aby anulowac operacje.");
                        listTasks();
                        if (scanner.hasNextInt()) {
                            taskToDelete = scanner.nextInt();
                            scanner.nextLine();
                            removeTask(taskToDelete);
                        } else {
                            System.out.println("Niepoprawna dana wejsciowa!");
                            scanner.nextLine();
                        }
                        break;
                    case "3":
                        listTasks();
                        break;
                    case "4":
                        return;
                }
                System.out.println();
            }
        }
    }

    private static void listTasks() {
        for (Map.Entry<Integer, String> entry : tasksInApp.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Number: " + key + " - " + value);
        }
    }

    private static void addTask(String valueOfTask) {
        int numberOfTask;
        if (tasksInApp.isEmpty()) {
            numberOfTask = 0;
        } else {
            numberOfTask = Collections.max(tasksInApp.keySet());
        }
        tasksInApp.put(++numberOfTask, valueOfTask);
    }

    private static void removeTask(int taskNumber) {
        if (taskNumber == 0) {
            return;
        } else if (!tasksInApp.containsKey(taskNumber)) {
            System.out.println("Brak zadania o tym numerze");
            return;
        }
        tasksInApp.remove(taskNumber);
        Map<Integer, String> tempReorderHashMap = new LinkedHashMap<>();
        int keyIterator = 1;
        for (Map.Entry<Integer, String> entry : tasksInApp.entrySet()) {
            tempReorderHashMap.put(keyIterator++, entry.getValue());
        }
        tasksInApp.clear();
        tasksInApp.putAll(tempReorderHashMap);
    }
}
