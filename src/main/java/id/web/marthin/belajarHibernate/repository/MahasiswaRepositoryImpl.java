/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.web.marthin.belajarHibernate.repository;

import id.web.marthin.belajarHibernate.domain.Mahasiswa;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

/**
 *
 * @author marthin
 */
public class MahasiswaRepositoryImpl implements MahasiswaRepository{
   
    private final SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(MahasiswaRepositoryImpl.class);

    public MahasiswaRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Mahasiswa mahasiswa){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(mahasiswa);
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
    public void update(Mahasiswa mahasiswa){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.update(mahasiswa);
            session.getTransaction().commit();
            LOGGER.debug("Data Di Update");
        }catch (HibernateException e){
            session.getTransaction().rollback();
            LOGGER.error("Error Bung {}", e.getMessage());
        }finally {
            session.close();
            LOGGER.info("Transaction selesai");
        }
    }

    @Override
    public void delete(Mahasiswa mahasiswa){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.delete(mahasiswa);
            session.getTransaction().commit();
            LOGGER.debug("Data Di Hapus");
        }catch (HibernateException e){
            session.getTransaction().rollback();
            LOGGER.error("Error Bung {}", e.getMessage());
        }finally {
            session.close();
            LOGGER.info("Transaction selesai");
        }
    }

    @Override
    public Mahasiswa getMahasiswa(String npm){
        Session session = sessionFactory.openSession();
        Mahasiswa mahasiswa;

        try {
            session.beginTransaction();
            mahasiswa = (Mahasiswa) session.get(Mahasiswa.class, npm);
            session.getTransaction().commit();
            LOGGER.debug("get mahasiswa");

            return mahasiswa;

        }catch (HibernateException e){
            session.getTransaction().rollback();
            LOGGER.error("Error Bung {}", e.getMessage());
        }finally {
            session.close();
            LOGGER.info("Transaction selesai");
        }

        return null;
    }

    @Override
    public List<Mahasiswa> getMahasiswas(){
        Session session = sessionFactory.openSession();
        List<Mahasiswa> mahasiswas;

        try {
            session.beginTransaction();
            mahasiswas = session.createCriteria(Mahasiswa.class).list();
            session.getTransaction().commit();
            LOGGER.debug("get mahasiswas");

            return mahasiswas;

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
