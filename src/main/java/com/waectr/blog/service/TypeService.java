package com.waectr.blog.service;

import com.waectr.blog.service.model.Type;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;

public interface TypeService {

    //保存
    Type saveType(Type type);

    //查询
    Type getType(Long id);

    //获取全部
    List<Type> list();

    Type updateType(Long id,Type type);

    void delete(Long id);

}
