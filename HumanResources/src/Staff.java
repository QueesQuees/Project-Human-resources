
// Lớp cha của Employee và Manager
// trừu tượng một phần
import java.time.LocalDate;

public abstract class Staff implements ICalculator {
   private String maNhanVien;
   private String name;
   private int age;
   private int heSoLuong;
   private LocalDate ngayVaoLam;
   private Department boPhan;
   private int soNgayNghi;

   public Staff(String maNhanVien, String name,int age, int heSoLuong, LocalDate ngayVaoLam, Department boPhan, int soNgayNghi){
      this.maNhanVien =maNhanVien;
      this.name = name;
      this.age = age;
      this.heSoLuong = heSoLuong;
      this.ngayVaoLam = ngayVaoLam;
      this.boPhan = boPhan;
      this.soNgayNghi = soNgayNghi;
   }

   public void setMaNhanVien(String maNhanVien) {
      this.maNhanVien = maNhanVien;
   }
   public String getMaNhanVien(){
      return maNhanVien;
   }

   public void setName(String name){
      this.name = name;
   }
   public String getName(){
      return name;
   }

   public void setAge(int age){
      this.age = age;
   }
   public int getAge(){
      return age;
   }

   public void setHeSoLuong(int heSoLuong){
      this.heSoLuong = heSoLuong;
   }
   public int getHeSoLuong(){
      return heSoLuong;
   }

   public void setNgayVaoLam(LocalDate ngayVaoLam){
      this.ngayVaoLam = ngayVaoLam;
   }
   public LocalDate getNgayVaoLam(){
      return  ngayVaoLam;
   }

   public void setBoPhan(Department boPhan){
      this.boPhan = boPhan;
   }
   public Department getBoPhan(){
      return  boPhan;
   }
   public void setSoNgayNghi(int soNgayNghi){
      this.soNgayNghi = soNgayNghi;
   }
   public int getSoNgayNghi(){
      return soNgayNghi;
   }

   abstract void displayInformation();
}
