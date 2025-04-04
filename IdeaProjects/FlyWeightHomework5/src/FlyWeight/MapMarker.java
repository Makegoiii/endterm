package FlyWeight;

public class MapMarker {
    private String location;
    private String type;

    public MapMarker(String location, String type) {
        this.location = location;
        this.type = type;
    }

    public void add() {
        System.out.println("Добавлен маркер: " + type + " в " + location);
    }

    public void remove() {
        System.out.println("Удалён маркер: " + type + " из " + location);
    }
}
