public class User {
    String name;
    TaskList list;
    public User(String name){
        this.name = name;
        this.list = new TaskList();
    }

    public TaskList getList() {
        return list;
    }

    public String getName() {
        return name;
    }
}
