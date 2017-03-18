package id.web.marthin.belajarHibernate.repository;

import id.web.marthin.belajarHibernate.domain.Mahasiswa;
import java.util.List;

/**
 *
 * @author marthin
 */
public interface MahasiswaRepository {
    void save(Mahasiswa mahasiswa);
    void update(Mahasiswa mahasiswa);
    void delete(Mahasiswa mahasiswa);
    Mahasiswa getMahasiswa(String npm);
    List<Mahasiswa> getAllMahasiswa();
}
