package com.crystal.javaweb.bean;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class Block {
    private final int id;
    private final String name;

    public Block(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + ". crystal.block." + name;
    }
}
