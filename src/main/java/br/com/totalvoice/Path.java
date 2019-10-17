package br.com.totalvoice;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<Object> paths;


    public Path() {
        paths = new ArrayList();
    }

    /**
     *
     * @param value
     */
    public void add(Object value) {
        paths.add(value);
    }

    /**
     *
     * @return
     */
    public String getPathString() {
        String spath = "";
        int count = paths.size();
        for (int i=0;i<count;i++) {
            spath += "/" + paths.get(i);
        }
        return spath;
    }
}
