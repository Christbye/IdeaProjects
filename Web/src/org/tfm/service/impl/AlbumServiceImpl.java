package org.tfm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tfm.dao.AlbumDAO;
import org.tfm.entity.Album;
import org.tfm.service.AlbumService;

import java.util.List;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
@Transactional
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO dao;
    @Override
    public boolean save(Album album) {
        return dao.save(album).getId()>0;
    }

    @Override
    public List<Album> list() {
        return dao.findAll();
    }

    @Override
    public List<Album> listByKind(int kind) {
        return dao.findByKind(kind);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id)>0;
    }

    @Override
    public boolean update(Album album) {
        return dao.update(album)>0;
    }

    @Override
    public Album getAlbum(int id) {
        return dao.findById(id);
    }
}
