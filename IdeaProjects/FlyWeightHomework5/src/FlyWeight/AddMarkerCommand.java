package FlyWeight;
public class AddMarkerCommand implements Command {
    private MapMarker marker;

    public AddMarkerCommand(MapMarker marker) {
        this.marker = marker;
    }

    @Override
    public void execute() {
        marker.add();
    }

    @Override
    public void undo() {
        marker.remove();
    }
}

