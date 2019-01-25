package solid.lsp;

/*
Liskov Substitution Principle
You should be able to substitute a base type for subtype
 */
class Rectangle {
    protected int height, width;

    public Rectangle() {
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}

class Square extends Rectangle {
    public Square() {
    }

    public Square(int size) {
        height = width = size;
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}

public class Demo {

    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        // area = width * 10;
        System.out.println("Expected area of rectange " + (width * 10) + " , got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        // This will lead to wrong result
        Rectangle sq = new Square(3);
        useIt(sq);
    }
}
