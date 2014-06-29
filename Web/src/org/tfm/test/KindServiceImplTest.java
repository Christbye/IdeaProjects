package org.tfm.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tfm.entity.Kind;
import org.tfm.service.KindService;

import java.util.List;

public class KindServiceImplTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    KindService service ;
    @Before
    public void setUp() throws Exception {

        service = (KindService) ctx.getBean("kindServiceImpl");
    }

    @Test
    public void testSave() throws Exception {
        Kind kind = new Kind();
        kind.setName("junit");
        kind.setType(2);
        service.save(kind);
        service.save(kind);
        Assert.assertEquals(new Integer(14),kind.getId());
    }

    @Test
    public void testList() throws Exception {
        List<Kind> list = service.list();
        System.out.println(list);
        Assert.assertTrue(list.size() > 1);
    }

    @Test
    public void testUpdate() throws Exception {
        Kind k = new Kind();
        k.setId(11);
        k.setName("test");
        Assert.assertEquals(true, service.update(k));
    }

    @Test
    public void testGetKind() throws Exception {
        Assert.assertEquals("战役与战争",service.getKind(3).getName());
    }

    @Test
    public void testDelete() throws Exception {
        Assert.assertEquals(1,service.delete(12));
    }
}