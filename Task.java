public class Task {
    boolean status;
    String desc;

    public Task(String desc){
        this.desc = desc;
        this.status = false;
    }

    public void completeTask(){
        this.status = true;
    }

    public String getDesc() {
        return desc;
    }

    public String getStatus(){
        if (status) {
            return "Complete";
        } else {
            return "Incomplete";
        }
    }

    @Override
    public String toString() {
        return getDesc()+" | Status: "+getStatus();
    }
}
