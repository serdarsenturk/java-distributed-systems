package com.serdarsenturk;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

class URLBuilder {
    private StringBuilder folders, params;
    private String connType, host;

    void setConnectionType(String conn) {
        connType = conn;
    }

    URLBuilder() {
        folders = new StringBuilder();
        params = new StringBuilder();
    }

    URLBuilder(String host) {
        this();
        this.host = host;
    }

    void addSubfolder(String folder) {
        folders.append("/");
        folders.append(folder);
    }

    void addParameter(String parameter, String value) {
        if (params.toString().length() > 0) {
            params.append("&");
        }
        params.append(parameter);
        params.append("=");
        params.append(value);
    }

    String getURL() throws URISyntaxException, MalformedURLException {
        URI uri = new URI(connType, host, folders.toString(),
                params.toString(), null);
        return uri.toURL().toString();
    }
}