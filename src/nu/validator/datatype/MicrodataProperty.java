/*
 * Copyright (c) 2011 Mozilla Foundation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package nu.validator.datatype;

import org.relaxng.datatype.DatatypeException;

/**
 * This datatype shall accept absolute URLs or any string that does not contain
 * '.' or ':' characters.
 */
public class MicrodataProperty extends Iri {

    /**
     * The singleton instance.
     */
    public static final MicrodataProperty THE_INSTANCE = new MicrodataProperty();

    protected MicrodataProperty() {
        super();
    }

    @Override
    public String getName() {
        return "microdata property";
    }

    @Override
    public void checkValid(CharSequence literal) throws DatatypeException {
        int len = literal.length();
        for (int i = 0; i < len; i++) {
            char c = literal.charAt(i);
            if (c == '.' || c == ':') {
                super.checkValid(literal);
                break;
            }
        }
    }
}
