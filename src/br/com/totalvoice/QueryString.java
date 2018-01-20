package br.com.totalvoice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class QueryString {

    private Map<String, Object> query;

    public QueryString() {
        query = new HashMap();
    }

    /**
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        query.put(key, value);
    }

    /**
     * @return Boolean
     */
    public boolean isEmpty() {
        return query.isEmpty();
    }

    /**
     * @return String
     */
    public String build() {
        String queryString = "";
        try {
            int i = 0;
            for (Map.Entry<String, Object> entry : query.entrySet()) {

                String s = i == 0 ? "?" : "&";
                queryString += s + entry.getKey() + "=" + URLEncoder.encode(entry.getValue().toString(), "UTF-8");
                i++;
            }
        }catch(UnsupportedEncodingException e) {}
        return queryString;
    }
}
