package com.hai.component;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by as on 2017/3/1.
 */
@Embeddable
public class Project {

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    @Column(name = "project_name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return name != null ? name.equals(project.name) : project.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
