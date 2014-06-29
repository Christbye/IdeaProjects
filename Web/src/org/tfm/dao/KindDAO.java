package org.tfm.dao;

import org.tfm.entity.Kind;

import java.util.List;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
public interface KindDAO {
    String TABLE = "KIND";
    List<Kind> findAll();
    Kind save(Kind k);
    int delete(int id);
    int update(Kind k);
    Kind findById(int id);
}
