package com.pydio.cells.api.ui;

import java.util.Properties;

public class Plugin {

    final private String id;
    final private String name;
    final private String label;
    final private String description;
    final private Properties configs;

    public Plugin(String id, String name, String label, String description, Properties configs) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.description = description;
        this.configs = configs;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Properties getConfigs() {
        return configs;
    }
}
