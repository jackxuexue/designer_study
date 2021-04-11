package com.jackxue.chain;

import java.util.ArrayList;
import java.util.List;

public class Sample01Main {
    public static void main(String[] args) {
        Msg msg = new Msg("你好，欢迎！<script> jackxue.com, 现在都是996！");
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
        //两个链条可以串起来
        FilterChain fc2 = new FilterChain();
        fc2.addFilter(new URLFilter());
        fc.addFilter(fc2);
        fc.doFilter(msg);
        System.out.println(msg.str);
    }
}
class Msg{
    String str;

    public Msg(String str) {
        this.str = str;
    }
}
interface  Filter{
    boolean doFilter(Msg msg);
}

class FilterChain implements Filter{

    List<Filter> filterList = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        filterList.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filterList) {
            if(!filter.doFilter(msg)) return false;
        }
        return true;
    }
}

class HTMLFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        msg.str = msg.str.replace("<", "[");
        msg.str = msg.str.replace(">", "]");
        return true;
    }
}

class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        msg.str = msg.str.replace("996", "955");
        return true;
    }
}

class URLFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        msg.str = msg.str.replace("jackxue.com", "http://www.jackxue.com");
        return true;
    }
}