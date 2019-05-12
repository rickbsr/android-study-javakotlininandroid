package com.rick.kotlininandroid.other.serializable;

import java.io.Serializable;

// 第三點：Java 版本，值物件，實作 Serializable
public class JavaInfo implements Serializable {

    private static final long serialVersionUID = JavaInfo.class.hashCode();

    private String title;
    private String content;

    public JavaInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
