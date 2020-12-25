package Controller.Admin;

import Model.TaiKhoan;
import Service.HopThuService;
import Service.TaiKhoanService;
import ServiceImpl.TaiKhoanServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet( "/TaiKhoanAddController")
public class TaiKhoanAddController extends HttpServlet {
    TaiKhoanService taiKhoanService= new TaiKhoanServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TaiKhoan user = new TaiKhoan();
        TaiKhoan taiKhoan = new TaiKhoan();
        String TenTK = request.getParameter("TenTK").trim();

        if (TenTK ==null || TenTK.trim().isEmpty()){
            request.setAttribute("LoiTK","Loi roi");
        }

//            String MaTK =request.getParameter("MaTK");

        String HoTen = request.getParameter("HoTen");
        if (HoTen ==null || HoTen.trim().isEmpty()){
            request.setAttribute("LoiHoTen","Loi roi");
        }
        String DiaChi = request.getParameter("DiaChi");
        if (DiaChi ==null || DiaChi.trim().isEmpty()){
            request.setAttribute("LoiDiaChi","Loi roi");
        }
        String Email = request.getParameter("Email");
        if (Email ==null || Email.trim().isEmpty()){
            request.setAttribute("Loi","Loi roi");
        }
        String TempNamSinh = request.getParameter("NamSinh");
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date NamSinh = null;
        try {
            NamSinh = (Date) sdf.parse(TempNamSinh);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }


        taiKhoan.setNamSinh(NamSinh);
        taiKhoan.setHoTen(HoTen);
        taiKhoan.setEmail(Email);
        taiKhoan.setDiaChi(DiaChi);
        taiKhoan.setChan(0);

        taiKhoan.setPhanQuyen(1);
        taiKhoan.setTenTK(TenTK);

        taiKhoanService.insert(taiKhoan);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TenTK = request.getParameter("TenTK");
        if (TenTK != null) {
            request.setAttribute("ThongBaoLoi", "Username da ton tai!!!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/add-user.jsp");
        dispatcher.forward(request, response);
    }
}
