package com.dimxnux.task.makeupxml.sax;

import java.time.LocalDate;

public class SiteMap {

    private String location;
    private LocalDate lastModification;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getLastModification() {
        return lastModification;
    }

    public void setLastModification(LocalDate lastModification) {
        this.lastModification = lastModification;
    }

}
