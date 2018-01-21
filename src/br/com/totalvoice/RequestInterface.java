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
     * @return String
     */
    public String getURL();

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
}
