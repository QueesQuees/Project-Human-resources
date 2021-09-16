import java.time.LocalDate;

public class Manager extends Staff{
    private String chucDanh;
//Hàm tạo
    public Manager(String maNhanVien, String name, int age, int heSoLuong, LocalDate ngayVaoLam, Department boPhan, int soNgayNghi, String chucDanh){
        super( maNhanVien, name, age, heSoLuong, ngayVaoLam,  boPhan,soNgayNghi);
        this.chucDanh = chucDanh;
    }

    public  void setChucDanh(String chucDanh){
        this.chucDanh = chucDanh;
    }
    public String getChucDanh(){
        return chucDanh;
    }

    @Override
    //Hiển thị thông tin cho đối tượng quản lý
    public void displayInformation() {
        System.out.println("Mã nhân viên: "+ getMaNhanVien());
        System.out.println("Tên: "+ getName());
        System.out.println("Tuổi: "+ getAge());
        System.out.println("Hệ sô lương: "+ getHeSoLuong());
        System.out.println("Ngày vào làm: "+ getNgayVaoLam());
        System.out.println("Bộ phận: " + getBoPhan());
        System.out.println("Số ngày nghỉ: " + getSoNgayNghi());
        System.out.println("Chức danh: " + getChucDanh());
        System.out.println("Lương :" + calculateSalary());

    }

    @Override
    //Tính lương cho đối tương quản lý
    public double calculateSalary() {
        double luong = 0;
        if(chucDanh.equals("Business Leader")){
            luong = getHeSoLuong()* 3000000.0  + 8000000;
        }else if(chucDanh.equals("Project Leader")) {
            luong = getHeSoLuong()* 3000000.0 + 5000000;
        }else if(chucDanh.equals("Technical Leader")){
            luong = getHeSoLuong()* 3000000.0 + 6000000;
        }
        return luong;
    }
}
