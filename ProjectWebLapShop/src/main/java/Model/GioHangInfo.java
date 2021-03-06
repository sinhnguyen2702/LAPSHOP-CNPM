package Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "GioHangInfo")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.gioHang",
                joinColumns = @JoinColumn(name = "maGiohang")),
        @AssociationOverride(name = "primaryKey.hangHoa",
                joinColumns = @JoinColumn(name = "maSP")) })
public  class  GioHangInfo{


    private  int SoLuong;
    private GioHangInfoId primaryKey = new GioHangInfoId();
    public GioHangInfo(){

    }
    public  GioHangInfo(GioHang gioHang,HangHoa hangHoa,int soLuong){
        super();
        this.setHangHoa(hangHoa);
        this.setGioHang(gioHang);
        this.SoLuong = soLuong;
    }
    @EmbeddedId
    public GioHangInfoId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(GioHangInfoId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient

    public HangHoa getHangHoa() {
        return getPrimaryKey().getHangHoa();
    }

    public void setHangHoa(HangHoa hangHoa) {
        getPrimaryKey().setHangHoa(hangHoa);
    }

    @Transient
    public GioHang getGioHang() {
        return getPrimaryKey().getGioHang();
    }

    public void setGioHang(GioHang gioHang) {
        getPrimaryKey().setGioHang(gioHang);
    }


    @Column(name = "SoLuong",nullable = false)
    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimaryKey().getGioHang().getMaGioHang(), getPrimaryKey().getHangHoa().getMaSP());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GioHangInfo)) return false;
        GioHangInfo that = (GioHangInfo) o;
        return Objects.equals(getPrimaryKey().getGioHang().getMaGioHang(), that.getPrimaryKey().getGioHang().getMaGioHang())&&
                Objects.equals(getPrimaryKey().getHangHoa().getMaSP(), that.getPrimaryKey().getHangHoa().getMaSP());
    }
}