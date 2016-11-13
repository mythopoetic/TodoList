package TodoList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gustav
 */
public class TodoList {

    private static void showAll(ArrayList<String> todoList) {
        if (todoList.isEmpty()) {
            System.out.println();
            System.out.println("List empty");
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
        if (index > todoList.size()) {
            System.out.println("There is no entry number " + index + " in the list");
        } else {
            todoList.remove(index - 1);
        }
        return todoList;
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
                    System.out.println("Type '-1' to return to menu");
                    while (renum != -1) {
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
                default:
                    System.out.println();
                    System.out.println("Invalid input");
                    System.out.println();
                    break;
            }
        }
    }
}
