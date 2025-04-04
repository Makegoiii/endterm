package Proxy;
public class UploadImageHandler extends ImageUploader {
    @Override
    public boolean handle(String user, String filename) {
        System.out.println("Изображение" + filename + " успешно загружено!");
        return true;
    }
}

