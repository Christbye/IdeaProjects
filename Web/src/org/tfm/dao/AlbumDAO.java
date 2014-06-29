package org.tfm.dao;

import org.tfm.entity.Album;

import java.util.List;

/**
 * Created by christ on 14-6-18.
 * Make move.
 */
public interface AlbumDAO {
    String TABLE="ALBUM";
    List<Album> findAll();
    Album findById(int id);
    List<Album> findByKind(int kind);
    Album save(final Album album);
    int delete(int id);
    int update(Album album);
}
