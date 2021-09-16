import java.time.LocalDate;

public class Employee extends Staff{
    private int soGioLamThem;
//Hàm tạo
    public Employee(String maNhanVien, String name, int age, int heSoLuong, LocalDate ngayVaoLam, Department boPhan, int soNgayNghi, int soGioLamThem){
        super( maNhanVien, name, age, heSoLuong, ngayVaoLam,  boPhan,soNgayNghi);
        this.soGioLamThem = soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem){
        this.soGioLamThem = soGioLamThem;
    }
    public int getSoGioLamThem(){
        return  soGioLamThem;
    }

//tính lương cho nhân viên
    public double calculateSalary(){
        return getHeSoLuong()* 3000000.0 + soGioLamThem * 200000;
    }

    @Override
    //Hiển thị thông tin cho nhân viên thường
    public void displayInformation() {
        System.out.println("Mã nhân viên: "+ getMaNhanVien());
        System.out.println("Tên: "+ getName());
        System.out.println("Tuổi: "+ getAge());
        System.out.println("Hệ sô lương: "+ getHeSoLuong());
        System.out.println("Ngày vào làm: "+ getNgayVaoLam());
        System.out.println("Bộ phận: " +  getBoPhan());
        System.out.println("Số ngày nghỉ: " + getSoNgayNghi());
        System.out.println("Số giờ làm Thêm: " + getSoGioLamThem());
        System.out.println("Lương :" + calculateSalary());
    }
}