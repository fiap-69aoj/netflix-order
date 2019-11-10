package com.netflix.order.dto;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 10/11/2019 11:07
 */
public class Greeting {

    private String msg;
    private String name;

    public String getMsg () {
        return msg;
    }

    public void setMsg (final String msg) {
        this.msg = msg;
    }

    public String getName () {
        return name;
    }

    public void setName (final String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        final StringBuilder builder = new StringBuilder()//
                .append("Greeting [")//
                .append("msg=\"")//
                .append(msg).append("\"")//
                .append(",name=\"")//
                .append(name).append("\"")//
                .append("]");
        return builder.toString();
    }
}
