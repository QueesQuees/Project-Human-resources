public class Department {
    private int maBoPhan;
    private String tenBoPhan;
    private int soNhanVien;

    public Department(){};
    public Department(int maBoPhan, String tenBoPhan, int soNhanVien){
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soNhanVien = soNhanVien;
    }

    public void setMaBoPhan(int maBoPhan){
        this.maBoPhan = maBoPhan;
    }
    public int getMaBoPhan(){
        return maBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan){
        this.tenBoPhan = tenBoPhan;
    }
    public String getTenBoPhan(){
        return tenBoPhan;
    }

    public void setSoNhanVien(int soNhanVien){
        this.soNhanVien = soNhanVien;
    }
    public int getSoNhanVien(){
        return soNhanVien;
    }

//Hiện thị thông tin bộ phận
    public String toString() {
        return "Mã bộ phận: "+ maBoPhan + ", Tên bộ phận: " + tenBoPhan + ", Tổng số nhân viên của công ty: " + soNhanVien + " Nhân viên";
    }
}
