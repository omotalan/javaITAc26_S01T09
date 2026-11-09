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

        switch (priority) {
            case LOW:
                System.out.println("Low priority task; schedule for next week.");
                break;
            case MEDIUM:
                System.out.println("Medium priority task; execute immediately if no high-priority tasks.");
                break;
            case HIGH:
                System.out.println("High priority task; execute immediately.");
                break;
        }
    }
}
