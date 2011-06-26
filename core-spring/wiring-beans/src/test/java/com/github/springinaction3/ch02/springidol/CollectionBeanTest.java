package com.github.springinaction3.ch02.springidol;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {
    
    @Test
    public void testCollectionProperties() throws Exception {    
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("collection.xml");
        CollectionBean cb = context.getBean(CollectionBean.class);
        String[] strings = new String[] { "A", "B", "C" };
        assertArrayEquals(strings, cb.getArrayOfStrings());
        assertEquals(asList(strings), cb.getListOfStrings());
        assertThat(cb.getSetOfStrings(), hasItems(strings));
        assertThat(cb.getSetOfStrings().size(), is(equalTo(strings.length)));
    }
    
}
