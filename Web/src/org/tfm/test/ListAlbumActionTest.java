package org.tfm.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tfm.struts.ListAlbumAction;

public class ListAlbumActionTest {
    ListAlbumAction action;
    @Before
    public void setUp() throws Exception {
        action = (ListAlbumAction) new ClassPathXmlApplicationContext("spring-config.xml").getBean("list-album");
    }

    @Test
    public void testExecute() throws Exception {
        action.execute();
        Assert.assertEquals("",action.getList());
    }
    @Test
    public void testExecuteWithKind() throws Exception {
        action.setKind(2);
        action.execute();
        Assert.assertEquals("",action.getList());
    }
}