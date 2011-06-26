package com.github.springinaction3.ch02.springidol.matcher;

import static com.google.common.collect.Lists.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class CollectionEquivalentTest {

    @Test
    public void emptiesAreEquivalent() throws Exception {
        CollectionEquivalent isEquivalent = new CollectionEquivalent(arrayList(0));
        assertThat(arrayList(0), isEquivalent);
    }

    @Test
    public void emptyNotEquivalentToSingleton() throws Exception {
        CollectionEquivalent isEquivalent = new CollectionEquivalent(arrayList(1));
        assertThat(isEquivalent.matches(arrayList(0)), is(false));
    }

    private Collection<String> arrayList(int size) {
        Collection<String> c = newArrayList();
        for (int i = 0; i < size; i++) {
            c.add(Integer.toString(i));
        }
        return c;
    }
}
