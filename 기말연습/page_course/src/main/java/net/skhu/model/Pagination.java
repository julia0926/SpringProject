package net.skhu.model;

import lombok.Data;

@Data
public class Pagination {
    int pg = 1;        // 현재 페이지. 디폴트 값은 1
    int sz = 10;       // 페이지 당 레코드 수. 디폴트 값은 15
    int recordCount;   // 전체 레코드 수
    int di = 0;        // departmentId

    public String getQueryString() {
        return String.format("pg=%d&sz=%d&di=%d", pg, sz, di);    }
}

