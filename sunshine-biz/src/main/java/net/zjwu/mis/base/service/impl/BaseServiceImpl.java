/**
 * 
 */
package net.zjwu.mis.base.service.impl;

import java.util.List;

import net.zjwu.mis.base.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Lay
 *
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{
	@Autowired
    protected Mapper<T> mapper;

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int update(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
        }
    public List<T> selectAll() {
        return mapper.selectAll();
        }
}
