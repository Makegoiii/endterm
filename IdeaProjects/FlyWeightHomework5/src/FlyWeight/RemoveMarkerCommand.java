package FlyWeight;
public class RemoveMarkerCommand implements Command {
    private MapMarker marker;

    public RemoveMarkerCommand(MapMarker marker) {
        this.marker = marker;
    }

    @Override
    public void execute() {
        marker.remove();
    }

    @Override
    public void undo() {
        marker.add();
    }
}

