package id.web.marthin.belajarHibernate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marthin
 */

@Entity
@Table(name="tb_mahasiswa")
public class Mahasiswa implements Serializable {
    
    @Id
    @Column(name="npm", length=8)
    private String npm;
    
    @Column(name = "nama", nullable = false, length = 100)
    private String  nama;
    
    @Column(name = "kelas", nullable = false, length = 5)
    private String kelas;
    
    @Column(name = "jenisKemlamin",nullable = false, length = 6 )
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;
    
    @Column(name = "tanggalLahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }


}
