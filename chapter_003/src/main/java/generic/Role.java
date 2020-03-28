package generic;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class Role extends Base {
    private final String condition;

    public Role(String id, String condition) {
        super(id);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
