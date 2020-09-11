package com.vicente.vicentedemo.common;

import lombok.Data;

@Data
public class Pages {

    private int page;//第几页
    private int size;//每页显示几条内容
    private String sortColumn; //排序字段
    private String direction; //排序方式


}
