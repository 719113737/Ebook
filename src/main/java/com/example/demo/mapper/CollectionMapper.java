package com.example.demo.mapper;

import com.example.demo.dao.CollectionInfo;
import com.example.demo.entity.Collection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface CollectionMapper {

    /**
     * 添加收藏夹
     * @param collection 收藏信息
     * @return
     */
    @Insert("insert into collection values(#{username},#{title});")
    int insertCollection(Collection collection);

    /**
     * 通过用户名获取收藏信息
     * @param username 用户名
     * @return
     */
    @Select("select collecton.username,collection.title,imagePath from collection" +
            "left join book on book.title = collection.title" +
            "where collection.username = #{username};")
    List<CollectionInfo> getCollectionByUsername(@Param("username")String username);

}
