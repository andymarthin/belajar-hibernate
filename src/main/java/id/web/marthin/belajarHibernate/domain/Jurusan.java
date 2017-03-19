/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.web.marthin.belajarHibernate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author marthin
 */

@Entity
@Table(name="tb_jurusan")
public class Jurusan implements Serializable{
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String idJurusan;
    
    @ManyToOne
    @JoinColumn(name="mahasiswa", nullable=false)
    private Mahasiswa mahasiswa;
    
    @Column(name="nama_jurusan", nullable=false)
    private String namaJurusan;
    
    @Column(name="tanggal", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal = new Date();

    public String getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
