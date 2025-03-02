import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class Todo extends Task{
    protected List<Task> tasks;
    protected int total_workload;

    public Todo(){
        super(null, 0, 0);
        tasks = new ArrayList<>();
    }

    public void addTask(String description, int priority, int minutes){
        Task task = new Task(description, priority, minutes);
        if (priority > 4 || priority < 1){
            System.out.println(description + " has invalid priority");
        }
        else if (minutes < 0){
            System.out.println(description + " has invalid workload");
        }
        else {
            tasks.add(task);
        }
    }

    public void print(){
        System.out.println("Todo:");
        System.out.println("-----");
        if (tasks.isEmpty()){
            System.out.println("You're all done for today! #TodoZero");
        }
        else{
            for (Task task : tasks){
                System.out.println(task.toString());
            }
        }
        if (total_workload > 0){
            System.out.println(total_workload + " minutes of work done!");
        }

    }

    public void completeTask(int index){
        Task tsk = new Task(null, 0, 0);
        int length = tasks.size();
        if (!tasks.isEmpty() && index < length && index >= 0){ 
             tsk = tasks.get(index);
        } 
        else{
            System.out.println("Invalid index");
        } 
        if (tasks.contains(tsk)){
            total_workload += tsk.getWorkload();
            tasks.remove(tsk);
        }

    }

    public void printPriority(int limit){
        System.out.println("Filtered todo:");
        System.out.println("--------------");
        for (Task task : tasks){
            if (task.getPriority() <= limit){
                System.out.println(task.toString());
            }
        }
    }

    public void printPrioritized(){
        System.out.println("Prioritized todo:");
        System.out.println("-----------------");

        List<Task> prioritizedTasks = new ArrayList<>();

        if (!tasks.isEmpty()){
            prioritizedTasks = tasks;
        }

        prioritizedTasks.sort((Comparator.comparing(Task::getPriority).thenComparing(Task::getWorkload)));

        for (Task task : prioritizedTasks){
            System.out.println(task.toString());
        }
    }

    //* Revise this method because it's more flexible. Not sure how it works in its entirety */
    public void printPrioritized2(){ 
        System.out.println("Prioritized todo:");
        System.out.println("-----------------"); 

        List<Task> prioritizedTasks = new ArrayList<>();

        if (!tasks.isEmpty()){
            prioritizedTasks = tasks;

            Collections.sort(prioritizedTasks, new Comparator<Task>(){

                @Override
                public int compare (Task o1, Task o2) {
                    if(o1.getPriority() == o2.getPriority()){
                        return (o1.getWorkload() - o2.getWorkload());
                    }
                    
                    return (o1.getPriority() - o2.getPriority());
                }
            });

        }

    }
}
