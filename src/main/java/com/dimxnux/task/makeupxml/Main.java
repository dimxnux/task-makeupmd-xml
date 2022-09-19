package com.dimxnux.task.makeupxml;

import com.dimxnux.task.makeupxml.sax.MakeupmdHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        String fileToParse = "src/main/resources/makeupmd.xml";

        MakeupmdHandler makeupmdHandler = new MakeupmdHandler();
        saxParser.parse(fileToParse, makeupmdHandler);

        String linksOutFile = "links.txt";
        List<String> locations = makeupmdHandler.getWebsite().getAllLocations();

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(linksOutFile))) {
            for (String loc : locations) {
                writer.append(loc).append('\n');
            }
        }
    }

}
