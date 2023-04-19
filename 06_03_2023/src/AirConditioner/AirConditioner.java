package AirConditioner;

import java.text.DecimalFormat;

class People {
  String nama;
  double tabungan;
  AirConditioner ac = null;

  People(String nama, double tabungan) {
    this.nama = nama;
    this.tabungan = tabungan;
  }

  private void tambahTabungan(double value) {
    this.tabungan += value;
    DecimalFormat decimalFormat = new DecimalFormat("#.##############");
    String _tabungan = decimalFormat.format(this.tabungan);
    System.out.println("Tabungan " + this.nama + " bertambah menjadi " + _tabungan);
  }

  void haveAc(AirConditioner ac) {
    this.ac = ac;
    System.out.println(this.nama + " memiliki AC");
  }

  void sellAc() {
    System.out.println(this.nama + " menjual AC-nya dengan harga " + this.ac.price);
    tambahTabungan(ac.price);
    this.ac = null;
  }
}

class AirConditioner {
  boolean isOn = false;
  private int temp = 20;
  final int maxTemp = 32;
  final int minTemp = 16;
  double price;

  AirConditioner(double price) {
    this.price = price;
  }

  void turnOn() {
    if (!isOn) {
      this.isOn = true;
      System.out.println("AC dinyalakan");
      return;
    }
    System.out.println("AC sudah menyala dari tadi");
  }

  void turnOff() {
    if (isOn) {
      this.isOn = false;
      System.out.println("AC dimatikan");
      return;
    }
    System.out.println("AC memang tidak menyala dari tadi");
  }

  void increaceTemp() {
    if (!isOn) {
      System.out.println("harap nyalakan AC terlebih dahulu");
      return;
    }
    if (this.temp < this.maxTemp) {
      this.temp++;
      System.out.println("suhu ditingkatkan menjadi " + this.temp);
      return;
    }
    System.out.println("suhu AC sudah maksimal, tidak dapat ditingkatkan lagi");
  }

  void decreaseTemp() {
    if (!isOn) {
      System.out.println("harap nyalakan AC terlebih dahulu");
      return;
    }
    if (this.temp > this.minTemp) {
      this.temp--;
      System.out.println("suhu diturunkan menjadi " + +this.temp);
      return;
    }
    System.out.println("suhu AC sudah minimal, tidak dapat diturunkan lagi");
  }

  void setTemp(int temp) {
    if (temp > maxTemp || temp < minTemp)
      return;
    this.temp = temp;
    System.out.println("suhu diubah menjadi " + this.temp);
  }

  public int getTemp() {
    return this.temp;
  }

  void togglePower() {
    if (isOn) {
      this.isOn = false;
      System.out.println("Ac dimatikan");
      return;
    }
    this.isOn = true;
    System.out.println("Ac dinyalakan");
  }

  public static void main(String[] args) {
    People people1 = new People("Budi", 20000000);
    AirConditioner ac1 = new AirConditioner(3000000);

    people1.haveAc(ac1);
    people1.ac.increaceTemp();
    people1.ac.togglePower();
    people1.ac.increaceTemp();
    people1.ac.decreaseTemp();
    people1.ac.setTemp(32);
    System.out.println(people1.ac.getTemp());
  }
}
