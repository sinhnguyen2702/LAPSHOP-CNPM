package Model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Base64;
import java.util.Objects;

/*
* MaSP - NSX - TenSP -  GiaBan -  GiaGoc - SoLuong - CPU - RAM - OCung - ManHin - Pin
* */
@Entity
@Table(name = "HangHoa")
public class HangHoa {
	private int MaSP ;
	private  NSX NSX;
	private String TenSP;
	private int GiaBan;
	private int GiaGoc;
	private int SoLuong;
	private String CPU;
	private String RAM;
	private String OCung;
	private String ManHinh;
	private String PIN;
	private  String MoTa;
	private float Sao;
	private byte[] Hinh;
	private String base64Image;

	public HangHoa() {
	}

	public HangHoa(int maSP, NSX NSX, String tenSP, int giaBan, int giaGoc, int soLuong,
				   String cPU, String rAM, String oCung, String manHinh, String pIN, String moTa,float sao,byte[] hinh) {
		super();
		this.MaSP = maSP;
		this.NSX = NSX;
		this.TenSP = tenSP;
		this.GiaBan = giaBan;
		this.GiaGoc = giaGoc;
		this.SoLuong = soLuong;
		this.CPU = cPU;
		this.RAM = rAM;
		this.OCung = oCung;
		this.ManHinh = manHinh;
		this.PIN = pIN;
		this.MoTa = moTa;
		this.Sao = sao;
		Hinh = hinh;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaNSX", nullable = false,referencedColumnName = "MaNSX"	)
	public Model.NSX getNSX() {
		return NSX;
	}

	public void setNSX(Model.NSX NSX) {
		this.NSX = NSX;
	}

	@Column(name = "GiaBan", nullable = false)
	public int getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(int giaBan) {
		GiaBan = giaBan;
	}

	@Column(name = "GiaGoc", nullable = false)
	public int getGiaGoc() {
		return GiaGoc;
	}
	public void setGiaGoc(int giaGoc) {
		GiaGoc = giaGoc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaSP", nullable = false)
	public int getMaSP() {
		return MaSP;
	}
	public void setMaSP(int maSP) {
		MaSP = maSP;
	}

	@Column(name = "SoLuong", nullable = false)
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	@Column(name = "CPU", nullable = false)
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String CPU) {
		this.CPU = CPU;
	}

	@Column(name = "ManHinh", nullable = false)
	public String getManHinh() {
		return ManHinh;
	}
	public void setManHinh(String manHinh) {
		ManHinh = manHinh;
	}

	@Column(name = "OCung", nullable = false)
	public String getOCung() {
		return OCung;
	}
	public void setOCung(String OCung) {
		this.OCung = OCung;
	}

	@Column(name = "Pin", nullable = false)
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String PIN) {
		this.PIN = PIN;
	}

	@Column(name = "Ram", nullable = false)
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String RAM) {
		this.RAM = RAM;
	}

	@Column(name = "TenSP", nullable = false)
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}


	@Column(name = "Hinh", nullable = true)
	public byte[] getHinh() {
		return Hinh;
	}
	public void setHinh(byte[] hinh) {
		Hinh = hinh;
	}

	@Column(name = "MoTa", nullable = true)
	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	@Column(name="Sao", nullable = true)
	public float getSao() {
		return Sao;
	}

	public void setSao(float sao) {
		Sao = sao;
	}

	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.Hinh);
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMaSP(),getNSX().getMaNSX());
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof HangHoa)) return false;
		HangHoa that = (HangHoa) o;
		return Objects.equals(getMaSP(), that.getMaSP())&&
				Objects.equals(getNSX().getMaNSX(), that.getNSX().getMaNSX());
	}
}
