package FlyWeight;
import java.util.Stack;

public class MapEditor {
    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            history.pop().undo();
        } else {
            System.out.println("Нет команд для отмены!");
        }
    }
}

