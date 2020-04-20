package com.yingxue.lesson.utils;

import com.github.pagehelper.Page;
import com.yingxue.lesson.vo.resp.PageRespVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 分页相关的工具类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.utils
 * @Version: 0.0.1
 */
public class PageUtil {
    private PageUtil() {
    }

    public static <T> PageRespVO<T> getPageVO(List<T> list) {
        PageRespVO<T> result = new PageRespVO<>();
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            result.setTotalRows(page.getTotal());
            result.setTotalPages(page.getPages());
            result.setPageNum(page.getPageNum());
            result.setCurPageSize(page.size());
            result.setPageSize(page.getPageSize());
            result.setList(page.getResult());
        }
        return result;
    }
}
