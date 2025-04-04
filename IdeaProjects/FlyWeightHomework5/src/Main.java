import FlyWeight.AddMarkerCommand;
import FlyWeight.Command;
import FlyWeight.MapEditor;
import FlyWeight.MapMarker;

public class Main {
    public static void main(String[] args) {
        MapEditor editor = new MapEditor();

        MapMarker gasStation = new MapMarker("Алматы, АЗС", " Заправка");
        MapMarker hospital = new MapMarker("Алматы, Больница", "Больница");

        Command addGasStation = new AddMarkerCommand(gasStation);
        Command addHospital = new AddMarkerCommand(hospital);

        editor.executeCommand(addGasStation);
        editor.executeCommand(addHospital);

        System.out.println("\nОТМЕНА последней операции:");
        editor.undoLastCommand();
    }
}
