package polymorphism.shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;


    public void calculatePerimeter() {

    }

    public void calculateArea() {

    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    public Double getPerimeter() {
        return perimeter;
    }
}
