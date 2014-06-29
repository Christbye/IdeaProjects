package org.tfm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tfm.dao.KindDAO;
import org.tfm.entity.Kind;
import org.tfm.service.KindService;

import java.util.List;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
@Service
@Transactional
public class KindServiceImpl implements KindService {
    @Autowired
    private KindDAO dao;
    @Override
    public boolean save(Kind k) {
        return dao.save(k).getId()> 0;
    }

    @Override
    public List<Kind> list() {
        return dao.findAll();
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id) > 0;
    }

    @Override
    public boolean update(Kind k) {
        return dao.update(k) > 0;
    }

    @Override
    public Kind getKind(int id) {
        return dao.findById(id);
    }
}
