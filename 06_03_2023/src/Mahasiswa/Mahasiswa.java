package Mahasiswa;

import java.util.Arrays;
import java.util.Scanner;

public class Mahasiswa extends Utils {
  private String nim;
  private String nama;
  public String jurusan;
  public int age;
  private String[] dosenFavorit = { "Sasa", "Nana" };

  public Mahasiswa(String nim, String nama, String jurusan, Integer age) {
    if (!checkDataMahasiswa(nim, nama, jurusan))
      return;
    this.nim = nim;
    this.nama = nama.toUpperCase();
    this.jurusan = jurusan.toUpperCase();
    this.age = age;
  }

  public void setNim(String nim) {
    if (!checkNimFormat(nim))
      return;
    this.nim = nim;
  }

  public String getNim() {
    return this.nim;
  }

  public void pindahJurusan(String jurusan) {
    if (!checkJurusanFormat(jurusan)) {
      System.out.println("Jurusan tidak valid!");
      return;
    }
    this.jurusan = jurusan.toUpperCase();
  }

  public int countBirthYear() {
    return getCurrentYear() - this.age;
  }

  public boolean checkDataMahasiswa(String nim, String nama, String jurusan) {
    if (!checkNimFormat(nim))
      return false;
    if (!checkNameFormat(nama))
      return false;
    if (!checkJurusanFormat(jurusan)) {
      System.out.println("Jurusan tidak valid!");
      return false;
    }

    return true;
  }

  public void shout() {
    if (dosenFavorit.length < 1) {
      System.out.println("mahasiswa teladan");
      return;
    }
    System.out.println("MANTAP");
  }

  public String[] getDosenFavorit() {
    System.out.println("Dosen favorit: " + Arrays.toString(dosenFavorit));
    return this.dosenFavorit;
  }

  public void addDosenFavorit(String name) {
    this.dosenFavorit = pushStringToArray(dosenFavorit, name);
  }

  public void updateDosenFavorite(String current, String _new) {
    this.dosenFavorit = updateStringInArray(dosenFavorit, current, _new);
  }

  public void removeDosenFavorit(String name) {
    this.dosenFavorit = removeStringFromArray(dosenFavorit, name);
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Mahasiswa m = new Mahasiswa("0001111", "budi", "teknologi informasi", 30);
    m.pindahJurusan("ekonomi");
    m.setNim("1151 ");
    m.pindahJurusan("");
    m.age = 19;
    System.out.println(m.nim + "_" + m.nama + "_" + m.jurusan + "_" + m.age);
    // m.getDosenFavorit();
    // m.addDosenFavorit("testtest");
    // m.updateDosenFavorite("testtest", "Test");
    // m.removeDosenFavorit("Sasa");
    // m.removeDosenFavorit("Nana");
    // m.removeDosenFavorit("Test");
    // m.getDosenFavorit();
    // m.shout();
  }
}