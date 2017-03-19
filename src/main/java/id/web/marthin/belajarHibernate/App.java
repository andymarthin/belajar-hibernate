package id.web.marthin.belajarHibernate;

import id.web.marthin.belajarHibernate.util.HibernateUtil;
import id.web.marthin.belajarHibernate.domain.JenisKelamin;
import id.web.marthin.belajarHibernate.domain.Jurusan;
import id.web.marthin.belajarHibernate.domain.Mahasiswa;
import id.web.marthin.belajarHibernate.repository.JurusanRepository;
import id.web.marthin.belajarHibernate.repository.MahasiswaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
        MahasiswaRepository mahasiswaRepository = HibernateUtil.getMahasiswaRepository();
        JurusanRepository jr = HibernateUtil.getJurusanRepository();
        
        Logger logger = LoggerFactory.getLogger(App.class);

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm("1234321");
        mahasiswa.setNama("Andy Marhin Christo");
        mahasiswa.setKelas("3IA04");
        mahasiswa.setJenisKelamin(JenisKelamin.PRIA);
        mahasiswa.setTanggalLahir(new SimpleDateFormat("dd/MM/yyyy").parse("27/11/1991"));
        
        mahasiswaRepository.save(mahasiswa);
        Jurusan jur = new Jurusan();
        jur.setMahasiswa(mahasiswa);
        jur.setNamaJurusan("Teknik Informatika");
        
        jr.save(jur);
        
        List<Mahasiswa> mahasiswas = mahasiswaRepository.getAllMahasiswa();

        for(Mahasiswa mahasiswaData: mahasiswas){
            logger.info("Npm           : {}", mahasiswaData.getNpm());
            logger.info("Nama          : {}", mahasiswaData.getNama());
            logger.info("Kelas         : {}", mahasiswaData.getKelas());
            logger.info("Jenis Kelamin : {}", mahasiswaData.getJenisKelamin());
            logger.info("Tanggal Lahir : {}", mahasiswaData.getTanggalLahir());
        }

        Mahasiswa mahasiswa1 = mahasiswaRepository.getMahasiswa("1234321");
        mahasiswa1.setNama("Andy Marhin Christo Ganteng");
        
        List<Jurusan> jursans = jr.getAllJurusan();

        for(Jurusan jurusanData: jursans){
            logger.info("id           : {}", jurusanData.getIdJurusan());
            logger.info("Nama          : {}", jurusanData.getNamaJurusan());
            logger.info("mahasiswa         : {}", jurusanData.getMahasiswa().getNama());
            logger.info("tanggal : {}", jurusanData.getTanggal());

        }
        mahasiswaRepository.update(mahasiswa1);

        //mahasiswaRepository.delete(mahasiswa1);

    }
}
