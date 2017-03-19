/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.web.marthin.belajarHibernate.repository;

import id.web.marthin.belajarHibernate.domain.Jurusan;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author marthin
 */
public class JurusanRepositoryImpl implements JurusanRepository{
    private final SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(MahasiswaRepositoryImpl.class);
    
    public JurusanRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void save(Jurusan j) {
                Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.saveOrUpdate(j);
            session.getTransaction().commit();
            LOGGER.debug("Data Tersimpan");
        }catch (HibernateException e){
            session.getTransaction().rollback();
            LOGGER.error("Error Bung {}", e.getMessage());
        }finally {
            session.close();
            LOGGER.info("Transaction selesai");
        }
    }

    @Override
    public List<Jurusan> getAllJurusan() {
        Session session = sessionFactory.openSession();
        List<Jurusan> jurusans;

        try {
            session.beginTransaction();
            jurusans = session.createCriteria(Jurusan.class).list();
            session.getTransaction().commit();
            LOGGER.debug("get mahasiswas");

            return jurusans;

        }catch (HibernateException e){
            session.getTransaction().rollback();
            LOGGER.error("Error Bung {}", e.getMessage());
        }finally {
            session.close();
            LOGGER.info("Transaction selesai");
        }

        return null;
    }
    
}
