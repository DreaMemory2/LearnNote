package com.crystal.javaweb.bean;

import java.util.Objects;

/**
 * <p>一个普通的java类，这个类可以封装零散的数据</p>
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class Department {
    private final Integer id;
    private final String name;
    private final String location;

    public Department(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
