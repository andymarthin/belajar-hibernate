/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.web.marthin.belajarHibernate.repository;

import id.web.marthin.belajarHibernate.domain.Jurusan;

import java.util.List;

/**
 *
 * @author marthin
 */
public interface JurusanRepository {
    void save(Jurusan j);
    List<Jurusan> getAllJurusan();
}
