package br.com.totalvoice;

import java.util.Map;

public interface RequestInterface {

    /**
     *
     * @param path
     */
    public void setPath(Path path);

    /**
     *
     * @return List
     */
    public Path getPath();

    /**
     * @return String
     */
    public String getPathString();

    /**
     *
     * @param query
     */
    public void setQuery(QueryString query);

    /**
     *
     * @return Map
     */
    public QueryString getQuery();

    /**
     *
     * @return String
     */
    public String getQueryString();

    /**
     *
     * @param data
     */
    public void setData(Map<String, ?> data);

    /**
     *
     * @return Map
     */
    public Map<String, ?> getData();
}
