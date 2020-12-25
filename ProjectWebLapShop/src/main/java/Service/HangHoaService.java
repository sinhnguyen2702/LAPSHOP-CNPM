package Service;

import Model.HangHoa;

import java.util.List;

public interface HangHoaService {
    void insert(HangHoa hangHoa);

    void edit(HangHoa hangHoa);

    void delete(HangHoa hangHoa);

    HangHoa get(int MaSP);

    List<HangHoa> getAll();

    List<HangHoa> timKiemBangTen(String tenHangHoa);
}