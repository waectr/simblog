package com.waectr.blog.service.impl;

import com.waectr.blog.dao.TypeDOMapper;
import com.waectr.blog.dataobject.TypeDO;
import com.waectr.blog.service.TypeService;
import com.waectr.blog.service.model.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDOMapper typeDOMapper;

    @Override
    @Transactional
    public Type saveType(Type type) {
        TypeDO typeDO=convertFromModel(type);
        typeDOMapper.insert(typeDO); //调用数据库insert
        int i=typeDO.getId(); 
        TypeDO typeDO1 = typeDOMapper.selectByPrimaryKey(i);
        Type type1 = convertFromDataObject(typeDO1);
        return type1;
    }

    private TypeDO convertFromModel(Type type) {
        if(type==null){
            return null;
        }
        TypeDO typeDO=new TypeDO();
        BeanUtils.copyProperties(type,typeDO);
        if(type.getId()!=null){
            typeDO.setId(new Integer(type.getId().toString()));
        }
        return typeDO;
    }

    private Type convertFromDataObject(TypeDO typeDO){
        if(typeDO==null){
            return null;
        }
        Type type=new Type();
        BeanUtils.copyProperties(typeDO,type);
        type.setId(new Long(typeDO.getId()));
        return type;
    }

    @Override
    public Type getType(Long id) {
        TypeDO typeDO = typeDOMapper.selectByPrimaryKey(new Integer(id.toString()));
        Type type = convertFromDataObject(typeDO);
        return type;
    }

    @Override
    public List<Type> list() {
        List<TypeDO> typeDOList = typeDOMapper.selectAll();
        List<Type> typeList=convertFromDataObject(typeDOList);
        return typeList;
    }

    private List<Type> convertFromDataObject(List<TypeDO> typeDOList) {
        if(typeDOList==null){
            return null;
        }
        List<Type> list=new ArrayList<>();
        for (TypeDO typeDO:typeDOList){
            Type t=new Type();
            BeanUtils.copyProperties(typeDO,t);
            t.setId(typeDO.getId().longValue());
            list.add(t);
        }
        return list;
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        return null;
    }

    @Override
    public void delete(Long id) {
        typeDOMapper.deleteByPrimaryKey(new Integer(id.toString()));
    }
}
