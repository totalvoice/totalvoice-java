package br.com.totalvoice;

import java.util.Map;

public class Request implements RequestInterface {

    private Path path;
    private QueryString query;

    @Override
    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public Path getPath() {
        return path;
    }

    @Override
    public String getPathString() {
        if(path == null) {
            return "";
        }
        return path.getPathString();
    }

    @Override
    public void setQuery(QueryString query) {
        this.query = query;
    }

    @Override
    public QueryString getQuery() {
        return query;
    }

    @Override
    public String getQueryString() {

        if(query == null || query.isEmpty()) {
            return "";
        }
        return query.build();
    }

    @Override
    public String getURL() {
        return (getPathString() + getQueryString()).trim();
    }
}
