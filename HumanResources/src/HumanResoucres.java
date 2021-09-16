import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class HumanResoucres {

    public static List<Staff> staffs = new ArrayList<>();
    public static List<Department> departments = new ArrayList<>();
    public static int soNhanVien;
    public static int bienDiem = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Hàm do - while điều khiển luồng chương trình
        do{

            System.out.println("Chọn một trong các chức năng sau ( Chọn các số từ 1 - 7 ):");
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
            System.out.println("2. Hiển thị các bộ phận trong công ty.");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
            System.out.println("4. Thêm nhân viên mới vào công ty: bao gồm 2 loại.");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
            System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
            System.out.println("Ấn bất kỳ chữ cái nào để thoát chương trình.");

            int chucNang = sc.nextInt();

            if(chucNang == 1) {
                danhSachNhanVien();
            }else if (chucNang == 2){
                hienThiCacBoPhan();
            }else if (chucNang == 3){
                hienThiNhanVienTheoBoPhan();
            }else if (chucNang == 4){
                themNhanVienMoi();
            }else  if (chucNang == 5){
                timKiemThongTinNhanVien();
            }else  if (chucNang == 6){
                hienThiBangLuong();
            }else if(chucNang == 7){
                hienThiBangLuongTangDan();
            }else if (chucNang == 8){
                hienThiBangLuongGiamDan();
            }else {
                break;
            }
            System.out.println();
        }while(true);
    }
//Hiển thìj các bộ phận trong công ty
    private static void hienThiCacBoPhan() {
        System.out.println();
        for(int i = 0;i < departments.size(); i++) {
            System.out.println(departments.get(i).toString());
        }
        System.out.println();
    }
// hiển thị bảng lương theo thứ tự tăng dần
    private static void hienThiBangLuongTangDan() {
        System.out.println();
        //hàm sắp xếp lại mảng staffs theo thứ tự tăng dần của lương
        Collections.sort(staffs, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1.calculateSalary() < o2.calculateSalary()){
                    return -1;
                }else {
                    if (o1.calculateSalary() == o2.calculateSalary()){
                        return 0;
                    }else {
                        return 1;
                    }
                }
            }
        });
        // in ra thông tin nv theo thứ tự tăng dần của lương
        for(int i = 0; i < staffs.size(); i++){
            staffs.get(i).displayInformation();
            System.out.println();
        }
    }
    public static void hienThiBangLuongGiamDan(){
        System.out.println();
        //hàm sắp xếp lại mảng staffs theo thứ tự giảm dần của lương
        Collections.sort(staffs, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if(o1.calculateSalary() < o2.calculateSalary()){
                    return 1;
                }else {
                    if (o1.calculateSalary() == o2.calculateSalary()){
                        return 0;
                    }else {
                        return -1;
                    }
                }
            }
        });
        // in ra thông tin nv theo thứ tự giảm dần của lương
        for(int i = 0; i < staffs.size(); i++){
            staffs.get(i).displayInformation();
            System.out.println();
        }
    }
//Hiện thị tên bảng lương của toàn nhân viên trong công ty.
    private static void hienThiBangLuong() {
        System.out.println();
        System.out.println("Bảng lương của nhân viên toàn công ty: ");
        for (int i = 0; i < staffs.size(); i++){
            String name = staffs.get(i).getName();
            double luong = staffs.get(i).calculateSalary();
            System.out.println(name + ": " +luong);
        }
    }
//Tìm kiếm thông tin nhân viên bằng id hoặc tên
    private static void timKiemThongTinNhanVien() {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên hoặc mã nhân viên mà bạn đang tìm kiếm :");
        String nameOrId = sc.nextLine();
        for (int i = 0; i < staffs.size(); i++){
            String tenNhanVien = staffs.get(i).getName();
            String idNhanVien = staffs.get(i).getMaNhanVien();
            if (tenNhanVien.equals(nameOrId) || idNhanVien.equals(nameOrId)){
                staffs.get(i).displayInformation();
                System.out.println();
                break;
            }
        }
    }
//Hiển thị nhân viên theo bộ phận
    private static void hienThiNhanVienTheoBoPhan() {
        System.out.println();
        subHienThiNhanVienTheoBoPhan("IT");
        subHienThiNhanVienTheoBoPhan("Kế toán");
        subHienThiNhanVienTheoBoPhan("Kinh doanh");
        subHienThiNhanVienTheoBoPhan("Nhân Sự");
    }

    //hàm sub để truyền tham số là tên bộ phận và trả lại các nhân viên trong bộ phận đó
    public static void subHienThiNhanVienTheoBoPhan(String tenBoPhan){
        System.out.println(tenBoPhan);
        for (int i = 0; i < staffs.size(); i++){
            String nameBoPhan = staffs.get(i).getBoPhan().getTenBoPhan();
            if(nameBoPhan.equals(tenBoPhan)){
                staffs.get(i).displayInformation();
            }
            System.out.println();
        }
        System.out.println();
    }
// Trả lại danh sách nhân viên
    private static void danhSachNhanVien() {
        System.out.println();
        for(int i = 0; i < staffs.size(); i++){
            staffs.get(i).displayInformation();
            System.out.println();
        }
    }
//Thêm nhân viên mới
    public static void themNhanVienMoi(){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        bienDiem++;

        System.out.println("Nhập thông tin nhân viên mới tại đây.");
        System.out.print("Mã nhân viên: ");
        String maNhanVien = sc.nextLine();

        System.out.print("Tên: ");
        String ten = sc.nextLine();

        System.out.print("Tuổi: ");
        int tuoi = sc.nextInt();

        System.out.print("Hệ số lương: ");
        int heSoLuong = sc.nextInt();
        sc.nextLine();

        //ngay vao lam
        System.out.print("Ngày vào làm (like 13/08/2021)");
        String str = sc.nextLine();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayVaoLam = LocalDate.parse(str, dt);

        //lua chon bo phan
        System.out.print("Chọn 1 trong 4 bộ phận trong công ty 1.IT, 2.Kế toan, 3.Kinh doanh, 4.Nhân sự ( 1 , 2 , 3 or 4 ): ");
        int chonBoPhan = sc.nextInt();
        if(chonBoPhan == 1){
            System.out.println("Bộ phận là IT.");
             Department department = new Department(11, "IT", bienDiem);
             departments.add(department);
        } else if (chonBoPhan == 2){
            System.out.println("Bộ phận là kế toán.");
            Department department = new Department(22, "Kế toán", bienDiem);
            departments.add(department);
        }else if (chonBoPhan == 3) {
            System.out.println("Bộ phận là kinh doanh.");
            Department department = new Department(33, "Kinh doanh", bienDiem);
            departments.add(department);
        }else if (chonBoPhan == 4){
            System.out.println("Bộ phận là nhân sự.");
            Department department = new Department(44, "Nhân Sự", bienDiem);
            departments.add(department);
        }


        System.out.print("Số ngày nghỉ: ");
        int soNgayNghi = sc.nextInt();

        //Lưa chọn thông tin thêm cho quản lý hoặc nhân viên.
        System.out.println("Người này có phải quản lý không ('y' hoặc 'n' )");
        char yn = sc.next().charAt(0);
        sc.nextLine();
        if (yn == 'y'){
            System.out.print("Chức danh quản lý: 1.Business Leader 2.Project Leader , 3.Technical Leader( 1 , 2 or 3): ");
            int chonChucDanh = sc.nextInt();
            String chucDanh = "";
            if(chonChucDanh == 1){
                System.out.println("Business Leader");
                chucDanh += "Business Leader";
            }else if (chonChucDanh == 2){
                System.out.println("Project Leader");
                chucDanh += "Project Leader";
            }else if (chonChucDanh == 3){
                System.out.println("Technical Leader");
                chucDanh += "Technical Leader";
            }
            Staff manager = new Manager(maNhanVien, ten, tuoi, heSoLuong, ngayVaoLam, departments.get(bienDiem-1), soNgayNghi,chucDanh);
            staffs.add(manager);    //Thêm đối tượng quản lý vào mảng
        }else {
            System.out.print("Số giờ làm thêm: ");
            int soGioLamThem = sc.nextInt();
            Staff employee = new Employee(maNhanVien, ten, tuoi, heSoLuong,ngayVaoLam, departments.get(bienDiem-1), soNgayNghi, soGioLamThem);
            staffs.add(employee);   //Thêm đối tượng nv vào mảng
        }

        //Lưa chọn thêm hoặc không thêm tiếp nv
        System.out.println("Bạn có muốn nhập thêm nhân viên không ('y' hoặc 'n')?");
        char yOrN = sc.next().charAt(0);
        if(yOrN == 'y') {
            themNhanVienMoi();
        }
    }
}