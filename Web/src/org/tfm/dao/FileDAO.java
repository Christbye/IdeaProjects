package org.tfm.dao;

import org.tfm.entity.FMFile;

import java.util.List;

public interface FileDAO {
    String TABLE="FM_FILE";

	FMFile save(FMFile fm);

    List<FMFile> findAll();

    FMFile findById(int id);

    List<FMFile> findByKind(int kid);

    List<FMFile> findByAlbum(int album);

    int delete(List<Integer> ids);

    int update(FMFile fm);
}
