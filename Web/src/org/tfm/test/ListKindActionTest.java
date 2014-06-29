package org.tfm.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tfm.struts.ListKindAction;

public class ListKindActionTest {
    ListKindAction action;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        action = (ListKindAction) ctx.getBean("list-kind");

    }

    @Test
    public void testExecute() throws Exception {
        Assert.assertEquals("",action.execute());
    }

}