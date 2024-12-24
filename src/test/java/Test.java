import java.util.ResourceBundle;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        System.out.println(bundle.getString("user"));
    }
}
