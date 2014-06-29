package org.tfm.service;

import org.tfm.entity.Kind;

import java.util.List;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
public interface KindService {
    boolean save(Kind k);
    List<Kind> list();
    boolean delete(int id);
    boolean update(Kind k);
    Kind getKind(int id);
}
