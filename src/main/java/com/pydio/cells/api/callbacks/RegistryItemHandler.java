package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.ui.Plugin;

import java.util.Properties;

public abstract class RegistryItemHandler {

    public void onPref(String name, String value) {
    }

    public void onAction(String action, String read, String write) {
    }

    public void onWorkspace(Properties p) {
    }

    public void onPlugin(Plugin p) {
    }
}
