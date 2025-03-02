public class Task {
    protected String description;
    protected int priority;
    protected int workload;

    public Task(String description, int priority, int workload){
        this.description = description;
        this.priority = priority; 
        this.workload = workload;
    }

    public String toString(){
        String str = "";

        if (priority == 1){
            str = description + " takes " + workload + " minutes and has priority very important";
        }
        if (priority == 2){
            str = description + " takes " + workload + " minutes and has priority important";
        }
        if (priority == 3){
            str = description + " takes " + workload + " minutes and has priority unimportant";
        }
        if (priority == 4){
            str = description + " takes " + workload + " minutes and has priority after learn Portuguese";
        }
        return str;
    }

    public int getWorkload() {
        return workload;
    }

    public int getPriority() {
        return priority;
    }

}
