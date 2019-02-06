package com.rusili.a0411mapfromscratch.model;

import java.util.List;

public class MuseumWrapper {

    private List<Museum> museums;

    public MuseumWrapper(List<Museum> museums) {
        this.museums = museums;
    }

    public List<Museum> getMuseums() {
        return museums;
    }
}
