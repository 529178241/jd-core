/*
 * Copyright (c) 2008-2019 Emmanuel Dupuy.
 * This project is distributed under the GPLv3 license.
 * This is a Copyleft license that gives the user the right to use,
 * copy and modify the code freely for non-commercial purposes.
 */

package org.jd.core.v1.model.javasyntax.type;

import org.jd.core.v1.util.DefaultList;

import java.util.Collection;

public class Types<T extends Type> extends DefaultList<T> implements BaseType {
    public Types() {}

    public Types(int capacity) {
        super(capacity);
    }

    public Types(Collection<T> collection) {
        super(collection);
        assert (collection != null) && (collection.size() > 1) : "Uses 'Type' implementation instead";
    }

    @SuppressWarnings("unchecked")
    public Types(T type, T... types) {
        super(type, types);
        assert (types != null) && (types.length > 0) : "Uses 'Type' implementation instead";
    }

    @Override
    public void accept(TypeVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public  T getFirst() {
        return (T)this;
    }
}
