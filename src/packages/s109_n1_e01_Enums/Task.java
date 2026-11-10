package s109_n1_e01_Enums;

public class Task {
    private String title;
    private Level priority;

    public Task(String title, Level priority) {
        this.title = title;
        this.priority = priority;
    }

    public void execute() {
        System.out.println("Task: " + title);
        System.out.println("Status [" + priority.getColor() + "] -> " + priority.toString());

        // Sustitueix el nivell "HIGH" dins el switch abaix
        if (priority.isUrgentTask()) {
            System.out.println("URGENT TASK - Emergency alert!");
        } else {
            System.out.println("Task not urgent: add to standard queue.");
        }

        switch (priority) {
            case LOW:
                System.out.println("Low priority task; schedule for next week.");
                break;
            case MEDIUM:
                System.out.println("Medium priority task; execute immediately if no high-priority tasks.");
                break;
        }
    }
}
