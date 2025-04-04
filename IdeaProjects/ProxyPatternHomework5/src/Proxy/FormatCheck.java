package Proxy;
public class FormatCheck extends ImageUploader {
    @Override
    public boolean handle(String user, String filename) {
        if (!filename.endsWith(".jpg") && !filename.endsWith(".png")) {
            System.out.println("Ошибка:Только файлы JPG и PNG разрешены");
            return false;
        }
        System.out.println("Формат файла допустим");
        return next == null || next.handle(user, filename);
    }
}

