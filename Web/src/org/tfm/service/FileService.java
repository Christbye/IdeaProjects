package org.tfm.service;

import org.tfm.entity.FMFile;

import java.io.File;
import java.util.List;

public interface FileService {
	
	boolean save(FMFile fm, File file)throws IllegalArgumentException;
    List<FMFile> list();
    FMFile getFMFile(int id);
    List<FMFile> listByKind(int kid);
    List<FMFile> listByAlbum(int album);
    boolean delete(List<Integer> ids);
    boolean update(FMFile fm);
}
