package com.example.mybatisxmldemo.params;

import lombok.Data;

@Data
public class PageParam {
    private Integer beginLine;
    private Integer pageSize ;
    private Integer currentPage ;
    public int getBeginLine(){ return pageSize *currentPage;}
    public int getPageSize( ){ return 3;}
    public int getCurrentPage(){return 0;}

}
