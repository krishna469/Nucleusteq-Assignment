public class MainDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(12);
        Rectangle rectangle = new Rectangle(30, 40);
        
        System.out.println("Perimeter of Circle : " + circle.perimeter());
        System.out.println("Area of Circle : " + circle.area());
        System.out.println("Perimeter of Rectangle : " + rectangle.perimeter());
        System.out.println("Area of Rectangle : " + rectangle.area());
    }
}
