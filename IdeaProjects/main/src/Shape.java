public  abstract class Shape {
    public abstract double getPerimeter();
    public abstract double getArea();

    public void printArea(){
        System.out.println("MY AREA IS : "+getArea());
    }
    public void printPerimeter(){
        System.out.println("MY PERIMETER IS : "+getPerimeter());
    }
}
