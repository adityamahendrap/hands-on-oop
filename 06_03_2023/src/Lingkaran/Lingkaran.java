package Lingkaran;
public class Lingkaran {
  final double phi = 3.14;
  public double rad;
  private String color = "black";

  Lingkaran(double rad) {
    this.rad = rad;
  }

  double getDiameter() {
    return 2 * this.rad;
  }

  void setColor(String color) {
    this.color = color;
  }

  String getColor() {
    return this.color;
  }

  double countLuas() {
    return phi * this.rad * this.rad;
  }

  double countSomeLuas(double area) {
    return countLuas() * area;
  }

  double countKeliling() {
    return 2 * phi * this.rad;
  }

  public static void main(String[] args) {
    Lingkaran circle = new Lingkaran(10);
    System.out.println(circle.getDiameter());
    System.out.println(circle.countLuas());
    System.out.println(circle.countSomeLuas(0.5));
  }
}
