package model;

/**
 * Created by windows00 on 29/10/2017.
 */

public class Item {
    private String name;

    public Item(){}

    public Item(String name){ this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
