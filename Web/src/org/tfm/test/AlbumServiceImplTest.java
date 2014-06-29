package org.tfm.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tfm.entity.Album;
import org.tfm.service.AlbumService;

public class AlbumServiceImplTest {
    private AlbumService service;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        service = (AlbumService) ctx.getBean("albumServiceImpl");
    }

    @Test
    public void testSave() throws Exception {
        Album album = new Album();
        album.setName("诺曼底登录");
        album.setKind(3);
        Assert.assertTrue(service.save(album));
    }

    @Test
    public void testList() throws Exception {
        Assert.assertEquals(1,service.list().size());
    }

    @Test
    public void testListByKind() throws Exception {
        Assert.assertEquals(null,service.listByKind(2));
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {
        Album album = new Album();
        album.setName("诺曼底登录");
        album.setKind(2);
        album.setId(1);
        Assert.assertTrue(service.update(album));
    }

    @Test
    public void testGetAlbum() throws Exception {
        Album album = new Album();
        album.setId(1);
        Assert.assertSame(service.getAlbum(1),album);
    }
}