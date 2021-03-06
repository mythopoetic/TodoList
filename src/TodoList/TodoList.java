package TodoList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gustav
 */
public class TodoList {

    private static void showAll(ArrayList<String> todoList) {
        if (todoList.isEmpty()) {
            System.out.println();
            System.out.println("List is empty");
            System.out.println();
        } else {
            int index = 1;
            System.out.println();
            for (String entry : todoList) {
                System.out.println(index + ". " + entry);
                index++;
            }
            System.out.println();
        }
    }

    private static ArrayList<String> addEntry(ArrayList<String> todoList, String entry) {
        todoList.add(entry);
        return todoList;
    }

    private static ArrayList<String> removeEntry(ArrayList<String> todoList, int index) {
        if (index > todoList.size() || index <= 0) {
            System.out.println("There is no entry number " + index + " in the list");
        } else {
            todoList.remove(index - 1);
        }
        return todoList;
    }

    private static ArrayList<String> rotateRight(ArrayList<String> todoList, int k) {
        int size = todoList.size();
        String[] listArray = todoList.toArray(new String[0]);
        String[] rotatedListArray = new String[size];

        for (int i = 0; i < size; i++) {
            rotatedListArray[(i + k) % size] = listArray[i];
        }
        
        ArrayList<String> rotatedList = new ArrayList<>(Arrays.asList(rotatedListArray));

        return rotatedList;
    }

    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        scanner:
        while (true) {
            System.out.println("Press 1 to see all entries");
            System.out.println("Press 2 to add a new entry");
            System.out.println("Press 3 to remove an entry");
            System.out.println("Press 4 to exit");
            if (todoList.size() >= 2) {
                System.out.println("Press 5 to rotate list");
            }
            System.out.print("Input: ");
            int num = in.nextInt();
            in.nextLine();

            switch (num) {
                case 1:
                    showAll(todoList);
                    break;
                case 2:
                    System.out.println();
                    String entry = "";
                    System.out.println("Type 'stop' to return to menu");
                    while (!entry.equalsIgnoreCase("stop")) {
                        System.out.print("Type your new entry: ");
                        entry = in.nextLine();
                        if (entry.equalsIgnoreCase("stop")) {
                            break;
                        }
                        todoList = addEntry(todoList, entry);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    int renum = 0;
                    if (todoList.isEmpty()) {
                        System.out.println("List is empty, no entries to remove");
                        System.out.println();
                        break;
                    }
                    System.out.println("Type '-1' to return to menu");
                    while (!todoList.isEmpty()) {
                        System.out.println("Current list:");
                        showAll(todoList);
                        System.out.print("Type the number of the entry you wish to remove: ");
                        renum = in.nextInt();
                        in.nextLine();
                        if (renum == -1) {
                            break;
                        }
                        todoList = removeEntry(todoList, renum);
                    }
                    System.out.println();
                    break;
                case 4:
                    break scanner;
                case 5:
                    if (todoList.size() >= 2) {
                        System.out.println("Current list:");
                        showAll(todoList);
                        System.out.println("How many positions do you want to rotate?: ");
                        int k = in.nextInt();
                        in.nextLine();
                        todoList = rotateRight(todoList, k);
                        System.out.println("Updated list:");
                        showAll(todoList);
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Invalid input");
                        System.out.println();
                        break;
                    }
                default:
                    System.out.println();
                    System.out.println("Invalid input");
                    System.out.println();
                    break;
            }
        }
    }
}
