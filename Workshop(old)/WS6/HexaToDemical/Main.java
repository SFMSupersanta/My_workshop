import javax.swing.event.SwingPropertyChangeSupport;

public class Main {
    public static void main(String[] args) {
        ToDemical hex = new ToDemical();
        System.out.println("Test result: " + hex.toDemical("FF8"));
    }
}
