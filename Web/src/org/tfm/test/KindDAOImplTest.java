package org.tfm.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tfm.dao.KindDAO;
import org.tfm.dao.impl.KindDAOImpl;
import org.tfm.entity.Kind;

import java.util.List;

public class KindDAOImplTest {
    KindDAO dao;
    @Before
    public void setUp() throws Exception {
        dao = new KindDAOImpl();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("finish");
    }

    @Test
    public void testFindAll() throws Exception {
        System.out.println(dao.findAll());
    }

    @Test
    public void testSave() throws Exception {
        Kind k = new Kind();
        k.setName("Christ");
        k.setType(1);
        System.out.println(dao.save(k));
        k.setName("Christ_Ablum");
        k.setType(2);
        System.out.println(dao.save(k));
    }

    @Test
    public void testDelete() throws Exception {
        List<Kind> list = dao.findAll();
        int count = list.size();
        System.out.println(dao.delete(list.get(count-1).getId()));
    }

    @Test
    public void testUpdate() throws Exception {
        Kind k = new Kind();
        k.setId(2);
        k.setName("test1");
        k.setType(2);
        dao.update(k);

    }

    @Test
    public void testFindById() throws Exception {
        System.out.println(dao.findById(2));
    }
}