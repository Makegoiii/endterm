package Proxy;

public class AuthCheck extends ImageUploader {
    @Override
    public boolean handle(String user, String filename) {
        if (!user.equals("Agent")) {
            System.out.println("Ошибка:Вы не авторизованы для загрузки изображений");
            return false;
        }
        System.out.println("Авторизация пройден");
        return next == null || next.handle(user, filename);
    }
}

