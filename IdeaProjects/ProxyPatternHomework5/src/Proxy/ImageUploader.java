package Proxy;

public abstract class ImageUploader {
    protected ImageUploader next;

    public ImageUploader setNext(ImageUploader next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String user, String filename);
}


