package gc;

public class User {
    public String name;
    private static int count;
    private static int[] arr;

    public User(String name) {
        this.name = name;
        count++;
        arr = new int[1000];
//            a();
    }

    /**
     * StackOverflow
     */
    private void a() {
        a();
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", count=" + count + '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(String.format("destroy object %s", this));
        super.finalize();
    }
}