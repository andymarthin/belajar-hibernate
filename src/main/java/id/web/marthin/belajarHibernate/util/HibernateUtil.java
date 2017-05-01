package id.web.marthin.belajarHibernate.util;

import id.web.marthin.belajarHibernate.repository.JurusanRepository;
import id.web.marthin.belajarHibernate.repository.JurusanRepositoryImpl;
import id.web.marthin.belajarHibernate.repository.MahasiswaRepository;
import id.web.marthin.belajarHibernate.repository.MahasiswaRepositoryImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
/**
 *
 * @author marthin
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final MahasiswaRepository MAHASISWA_REPOSITORY;
    private static final JurusanRepository JURUSAN_REPOSITORY;
    private static ServiceRegistry serviceRegistry;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            StandardPBEStringEncryptor encryptor =new StandardPBEStringEncryptor();
            encryptor.setPassword("m4rT1nG@nt3ng");
            encryptor.setAlgorithm("PBEWITHMD5ANDDES");
            Configuration configuration = new Configuration().configure();
            String pass=encryptor.decrypt(configuration.getProperty("hibernate.connection.password"));
            configuration.setProperty("hibernate.connection.password",pass);  
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            MAHASISWA_REPOSITORY = new MahasiswaRepositoryImpl(sessionFactory);
            JURUSAN_REPOSITORY = new JurusanRepositoryImpl(sessionFactory);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static MahasiswaRepository getMahasiswaRepository() {
        return MAHASISWA_REPOSITORY;
    }
    
    public static JurusanRepository getJurusanRepository(){
        return JURUSAN_REPOSITORY;
    }
}
