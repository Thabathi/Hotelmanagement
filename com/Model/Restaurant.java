package com.Model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String buffet;
    private List<Menu> vegMenu = new ArrayList<>();
    private List<Menu> nonVegMenu = new ArrayList<>();

    public Restaurant(String name, String buffet, List<Menu> vegMenu, List<Menu> nonVegMenu) {
        this.name = name;
        this.buffet = buffet;
        this.vegMenu = vegMenu;
        this.nonVegMenu = nonVegMenu;
    }

    public String getName() {
        return name;
    }

    public String getBuffet() {
        return buffet;
    }

    public List<Menu> getVegMenu() {
        return vegMenu;
    }

    public List<Menu> getNonVegMenu() {
        return nonVegMenu;
    }
}
