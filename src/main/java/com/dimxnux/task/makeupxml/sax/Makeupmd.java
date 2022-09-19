package com.dimxnux.task.makeupxml.sax;

import java.util.ArrayList;
import java.util.List;

public class Makeupmd {

    private List<SiteMap> siteMaps;

    public List<SiteMap> getSiteMaps() {
        return siteMaps;
    }

    public void setSiteMaps(List<SiteMap> siteMaps) {
        this.siteMaps = siteMaps;
    }

    public List<String> getAllLocations() {
        List<String> locations = new ArrayList<>();
        for (SiteMap siteMap : siteMaps) {
            locations.add(siteMap.getLocation());
        }

        return locations;
    }

}
