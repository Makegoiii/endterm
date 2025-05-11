import Chainresponse.FAQBotHandler;
import Chainresponse.JuniorSupportHandler;
import Chainresponse.SeniorSupportHandler;
import Chainresponse.SupportHandler;
import commandpattern.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Chain of Responsibility ===");
        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();

        faq.setNext(junior).setNext(senior);

        String[] issues = { "password_reset", "refund_request", "account_ban", "unknown_bug" };
        for (String issue : issues) {
            faq.handle(issue);
        }

        System.out.println("\n=== Command Pattern ===");
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(light);
        Command setTemp = new SetThermostatCommand(thermostat, 22);

        Stack<Command> history = new Stack<>();

        lightOn.execute();
        history.push(lightOn);

        setTemp.execute();
        history.push(setTemp);

        System.out.println("Undo last command:");
        if (!history.isEmpty()) history.pop().undo();
    }
}
