package id.web.marthin.belajarHibernate;

import id.web.marthin.belajarHibernate.Util.HibernateUtil;
import id.web.marthin.belajarHibernate.domain.JenisKelamin;
import id.web.marthin.belajarHibernate.domain.Mahasiswa;
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
        Logger logger = LoggerFactory.getLogger(App.class);

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm("282738723");
        mahasiswa.setNama("Andy Marhin Christo");
        mahasiswa.setKelas("3IA04");
        mahasiswa.setJenisKelamin(JenisKelamin.PRIA);
        mahasiswa.setTanggalLahir(new SimpleDateFormat("dd/MM/yyyy").parse("27/11/1991"));

        mahasiswaRepository.save(mahasiswa);

        List<Mahasiswa> mahasiswas = mahasiswaRepository.getMahasiswas();

//        for(Mahasiswa mahasiswaData: mahasiswas){
//            logger.info("Npm           : {}", mahasiswaData.getNpm());
//            logger.info("Nama          : {}", mahasiswaData.getNama());
//            logger.info("Kelas         : {}", mahasiswaData.getKelas());
//            logger.info("Jenis Kelamin : {}", mahasiswaData.getJenisKelamin());
//            logger.info("Tanggal Lahir : {}", mahasiswaData.getTanggalLahir());
//        }

        Mahasiswa mahasiswa1 = mahasiswaRepository.getMahasiswa("282738723");
        mahasiswa1.setNama("Andy Marhin Christo Ganteng");

        mahasiswaRepository.update(mahasiswa1);

        mahasiswaRepository.delete(mahasiswa1);

    }
}
