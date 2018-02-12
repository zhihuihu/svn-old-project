package com.hxkj.totop.dao;

import com.hxkj.totop.entity.IndexPage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/25.
 */
@Repository
public interface IIndexPageDao extends IBaseDao<IndexPage> {

    public List<Map<String,Object>> selectechcaheList() throws Exception;
}
