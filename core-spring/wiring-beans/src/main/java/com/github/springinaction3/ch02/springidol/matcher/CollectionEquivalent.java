package com.github.springinaction3.ch02.springidol.matcher;

import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class CollectionEquivalent extends TypeSafeDiagnosingMatcher<Collection<?>> {

    private final Collection<?> expectedCollection;
    
    public CollectionEquivalent(Collection<?> expectedCollection) {
        this.expectedCollection = expectedCollection;
    }

    @Override
    public void describeTo(Description d) {
        if (expectedCollection.isEmpty()) {
            d.appendText("An empty collection");
        } else {
            d.appendText("A Collection containing ")
             .appendValueList("[", ", ", "]", expectedCollection);
        }
    }

    @Override
    protected boolean matchesSafely(Collection<?> collection, Description mismatchDescription) {
        if (expectedCollection == null && collection == null) {
            return true;
        }
        if (expectedCollection.size() != collection.size()) {
            return false;
        }
        for (Object item: collection) {
            if (!expectedCollection.contains(item)) {
                return false;
            }
        }
        return true;
    }


}
