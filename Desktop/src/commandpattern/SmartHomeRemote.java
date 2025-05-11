package commandpattern;

import java.util.*;

public class SmartHomeRemote {
    private Map<String, Command> slots = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    public void setCommand(String name, Command command) {
        slots.put(name, command);
    }

    public void pressButton(String name) {
        if (slots.containsKey(name)) {
            Command cmd = slots.get(name);
            cmd.execute();
            history.push(cmd);
        } else {
            System.out.println("[Remote] No command for: " + name);
        }
    }

    public void undoButton() {
        if (!history.isEmpty()) {
            Command lastCmd = history.pop();
            lastCmd.undo();
        } else {
            System.out.println("[Remote] Nothing to undo");
        }
    }
}

