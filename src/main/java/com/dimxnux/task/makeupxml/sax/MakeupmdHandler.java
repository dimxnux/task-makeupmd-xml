package com.dimxnux.task.makeupxml.sax;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MakeupmdHandler extends DefaultHandler {

    private Makeupmd website;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }



}
