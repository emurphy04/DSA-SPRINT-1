import java.util.LinkedList;

public class TaskList {
    LinkedList<Task> TaskList;
    public TaskList(){
        this.TaskList = new LinkedList<Task>();
    }

    public void addTask(String taskDesc){
        TaskList.add(new Task(taskDesc));
    }

    public void completeTask(int i){
        try {
            TaskList.get(i).completeTask();
        } catch (Exception e) {
            System.out.println();
            System.out.println("No task exists with that index.");
        }
    }

    public void getListIncomplete(){
        for (int i = 0; i < TaskList.size(); i++) {
            if (TaskList.get(i).getStatus().equals("Incomplete")) {
                System.out.println((i+1)+". "+TaskList.get(i).toString());
            }
        }
    }

    public void getListComplete(){
        for (int i = 0; i < TaskList.size(); i++) {
            if (TaskList.get(i).getStatus().equals("Complete")) {
                System.out.println((i+1)+". "+TaskList.get(i).toString());
            }
        }
    }
}
