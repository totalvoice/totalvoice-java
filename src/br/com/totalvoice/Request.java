package br.com.totalvoice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class Request implements RequestInterface {

    private List<?> path;
    private QueryString query;

    @Override
    public void setPath(List<?> paths) {
        path = paths;
    }

    @Override
    public List<?> getPath() {
        return path;
    }

    @Override
    public String getPathString() {
        String spath = "";
        int count = path.size();
        for (int i=0;i<count;i++) {
            spath += "/" + path.get(i);
        }
        return spath;
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

        if(query.isEmpty()) {
            return "";
        }
        return query.build();
    }

    @Override
    public void setData(Map<String, ?> data) {

    }

    @Override
    public Map<String, ?> getData() {
        return null;
    }
}
