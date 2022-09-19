package com.dimxnux.task.makeupxml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MakeupmdHandler extends DefaultHandler {

    private static final String SITEMAP = "sitemap";
    public static final String LOCATION = "loc";
    public static final String LAST_MODIFICATION = "lastmod";


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

    @Override
    public void startDocument() throws SAXException {
        website = new Makeupmd();
        website.setSiteMaps(new ArrayList<>());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case SITEMAP:
                website.getSiteMaps().add(new SiteMap());
                break;
            case LOCATION:
            case LAST_MODIFICATION:
                elementValue = new StringBuilder();
                break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case LOCATION:
                latestSiteMap().setLocation(elementValue.toString());
                break;
            case LAST_MODIFICATION:
                latestSiteMap().setLastModification(LocalDate.parse(elementValue.toString()));
                break;
        }

    }

    private SiteMap latestSiteMap() {
        List<SiteMap> siteMaps = website.getSiteMaps();
        return siteMaps.get(siteMaps.size() - 1);
    }

    public Makeupmd getWebsite() {
        return website;
    }

}
