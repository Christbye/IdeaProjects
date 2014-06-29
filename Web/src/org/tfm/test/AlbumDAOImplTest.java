package org.tfm.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tfm.dao.AlbumDAO;
import org.tfm.entity.Album;

public class AlbumDAOImplTest {
    AlbumDAO dao;
    @Before
    public void setUp() throws Exception {
       dao = (AlbumDAO) new ClassPathXmlApplicationContext("spring-config.xml").getBean("albumDAOImpl");
    }

    @Test
    public void testSave() throws Exception {
        Album album = new Album();
        album.setName("守卫战");
        album.setKind(4);
        Assert.assertEquals(2,dao.save(album));
    }
}