import Proxy.AuthCheck;
import Proxy.FormatCheck;
import Proxy.ImageUploader;
import Proxy.UploadImageHandler;


public class Main {
    public static void main(String[] args) {
        ImageUploader uploader = new AuthCheck();
        uploader.setNext(new FormatCheck()).setNext(new UploadImageHandler());

        System.out.println("Попытка загрузки пользователем 'Guest':");
        uploader.handle("Guest", "house.jpg");

        System.out.println("\nПопытка загрузки агентом с неверным форматом:");
        uploader.handle("Agent", "house.txt");

        System.out.println("\nУспешная загрузка:");
        uploader.handle("Agent", "house.jpg");
    }
}
