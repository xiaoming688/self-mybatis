package com.myself.v1.mapper;


public interface UserMapper {
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    User selectById(Integer id);

}
