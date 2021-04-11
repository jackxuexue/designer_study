package com.jackxue.chain.servlet;

import java.util.ArrayList;
import java.util.List;

public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request("request");
        Response response = new Response("response");
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
        fc.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}
class Request{
    String str;

    public Request(String str) {
        this.str = str;
    }
}
class Response{
    String str;

    public Response(String str) {
        this.str = str;
    }
}
interface Filter{
    void doFilter(Request request, Response response, FilterChain chain);
}
class FilterChain{
    List<Filter> filterList = new ArrayList<>();
    private int index = 0;
    public FilterChain addFilter(Filter filter){
        filterList.add(filter);
        return this;
    }
    public void doFilter(Request request, Response response){
        if(index >= filterList.size()) return;
        Filter filter = filterList.get(index);
        index ++;
        filter.doFilter(request, response, this);
    }
}

class HTMLFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str + " --HTMLFilter";
        chain.doFilter(request, response);
        response.str = response.str + " --HTMLFilter";
    }
}

class SensitiveFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str + " --SensitiveFilter";
        chain.doFilter(request, response);
        response.str = response.str + " --SensitiveFilter";
    }
}
