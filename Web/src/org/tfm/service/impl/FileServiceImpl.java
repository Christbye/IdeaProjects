package org.tfm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tfm.dao.FileDAO;
import org.tfm.entity.FMFile;
import org.tfm.service.FileService;
import org.tfm.util.MP3Util;

import java.io.File;
import java.util.List;
@Transactional
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDAO dao;

    @Override
    public boolean save(FMFile fm, File file) throws IllegalArgumentException{
       // System.out.println("start");
        fm.setSeconds(MP3Util.getSeconds(file));

        //TODO 压缩
        //MP3Util.compress(file.getAbsolutePath());
       // System.out.println("end");
        try {
            fm = dao.save(fm);
        }catch (Exception e){
            System.out.println("exception:");
            e.printStackTrace();
        }
        return fm.getId() > 0;
    }

    @Override
    public List<FMFile> list()  {
            return dao.findAll();

    }

    @Override
    public FMFile getFMFile(int id)  {
            return dao.findById(id);
    }

    @Override
    public List<FMFile> listByKind(int kid)  {
            return dao.findByKind(kid);
    }

    @Override
    public List<FMFile> listByAlbum(int album)  {
            return dao.findByAlbum(album);
    }

    @Override
    public boolean delete(List<Integer> ids)  {
            int count = dao.delete(ids);
        return count==ids.size();
    }

    @Override
    public boolean update(FMFile fm)  {
            int count = dao.update(fm);

        return count>0;
    }

}
