package br.com.totalvoice;

public interface RequestInterface {

    /**
     *
     * @param path
     */
    public void setPath(Path path);

    /**
     *
     * @return
     */
    public Path getPath();

    /**
     *
     * @return
     */
    public String getPathString();

    /**
     *
     * @return
     */
    public String getURL();

    /**
     *
     * @param query
     */
    public void setQuery(QueryString query);

    /**
     *
     * @return
     */
    public QueryString getQuery();

    /**
     *
     * @return
     */
    public String getQueryString();
}
