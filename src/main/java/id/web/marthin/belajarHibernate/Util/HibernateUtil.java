package id.web.marthin.belajarHibernate.Util;

import id.web.marthin.belajarHibernate.repository.MahasiswaRepository;
import id.web.marthin.belajarHibernate.repository.MahasiswaRepositoryImpl;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
/**
 *
 * @author marthin
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final MahasiswaRepository MAHASISWA_REPOSITORY;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            MAHASISWA_REPOSITORY = new MahasiswaRepositoryImpl(sessionFactory);
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
}
