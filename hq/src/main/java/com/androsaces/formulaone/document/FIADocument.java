/*
 * Copyright (c) 2020. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.document;

import com.androsaces.buckaroo.annotation.NotNull;

public interface FIADocument<T> {

    T getDocument();

    void setDocument(@NotNull T t);

    FIADocument NULL = new FIADocument() {
        @Override
        public Object getDocument() {
            return null;
        }

        @Override
        public void setDocument(Object o) {

        }
    };
}
