package org.tfm.service;

import org.tfm.entity.Album;

import java.util.List;

/**
 * Created by christ on 14-6-16.
 */
public interface AlbumService {
    boolean save(Album album);
    List<Album> list();
    List<Album> listByKind(int kind);
    boolean delete(int id);
    boolean update(Album album);
    Album getAlbum(int id);
}
