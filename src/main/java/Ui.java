import java.util.Scanner;

public class Ui {

    public static final String WELCOME_MESSAGE = "##    ##  #######  ##    ##  ######      ##     ## #### ##    ##  ######\n"
                                               + " ##  ##  ##     ## ###   ## ##    ##     ###   ###  ##  ###   ## ##    ##\n"
                                               + "  ####   ##     ## ####  ## ##           #### ####  ##  ####  ## ##\n"
                                               + "   ##    ##     ## ## ## ## ##   ####    ## ### ##  ##  ## ## ## ##   ####\n"
                                               + "   ##    ##     ## ##  #### ##    ##     ##     ##  ##  ##  #### ##    ##\n"
                                               + "   ##    ##     ## ##   ### ##    ##     ##     ##  ##  ##   ### ##    ##\n"
                                               + "   ##     #######  ##    ##  ######      ##     ## #### ##    ##  ######\n"
                                               + "Hello! I'm Yong Ming\n"
                                               + "What can I do for you?";
    public static final String WRONG_FORMAT_MESSAGE = "OOPS!!! One or more parameters are missing or invalid. The correct format is:\n"
                                                    + "todo [description]\n"
                                                    + "deadline [description] /by [deadline]\n"
                                                    + "event [description] /at [time]\n"
                                                    + "mark [Task#]\n"
                                                    + "unmark [Task#]\n"
                                                    + "delete [Task#]\n"
                                                    + "find [task description]\n";
    public static final String WRONG_INPUT_MESSAGE = "OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                                                   + "The accepted inputs are:\n"
                                                   + "> todo [description]\n"
                                                   + "> deadline [description] /by [deadline]\n"
                                                   + "> event [description] /at [time]\n"
                                                   + "> list\n"
                                                   + "> mark [Task#]\n"
                                                   + "> unmark [Task#]\n"
                                                   + "> delete [Task#]\n"
                                                   + "> find [Task description]\n"
                                                   + "> bye\n";
    public static final String END_MESSAGE = "Bye! Hope to see you again soon :)";

    public static void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printWrongFormat() {
        System.out.println(WRONG_FORMAT_MESSAGE);
    }

    public static void printWrongInput() {
        System.out.println(WRONG_INPUT_MESSAGE);
    }

    public static void printBye() {
        System.out.println(END_MESSAGE);
    }

    public static void printList() {
        if (TaskList.size() == 0) {
            System.out.println("There are no tasks yet!\n");
        } else {
            for (int i = 0; i < TaskList.size(); i++) {
                int listIndex = i + 1;
                System.out.println(listIndex + "." + TaskList.get(i));
            }
            System.out.println();
        }
    }

    public static void printListSize() {
        if (TaskList.size() == 0) {
            System.out.println("Now you have no tasks in the list\n");
        } else if (TaskList.size() == 1) {
            System.out.println("Now you have 1 task in the list\n");
        } else {
            System.out.println("Now you have " + TaskList.size() + " tasks in the list.\n");
        }
    }

    public static void printAddToList() {
        System.out.println("Got it. I've added this task:" + System.lineSeparator() + TaskList.get(TaskList.size() - 1));
        printListSize();
    }

    public static void printDeleteFromList(int taskIndex) {
        System.out.println("Got it. Removing this task:" + System.lineSeparator() + TaskList.get(taskIndex));
    }

    public static String readCommand(Scanner in) {
        return in.nextLine();
    }

    public static void printMatchingTasks(String targetDescription) {
        boolean isFirst = true;
        for (int i = 0; i < TaskList.size(); i++) {
            Task tempTask = TaskList.get(i);
            String taskDescription = tempTask.description;
            if (taskDescription.contains(targetDescription)) {
                if (isFirst) {
                    isFirst = false;
                    System.out.println("Here are the matching tasks in your list:");
                }
                System.out.println(tempTask);
            }
        }
        if (isFirst) {
            System.out.println("There are no matching tasks in your list!");
        }
        System.out.println();
    }

}