package com.example.demo.service;


import com.example.demo.dao.CollectionInfo;
import com.example.demo.entity.Book;
import com.example.demo.entity.Collection;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServer {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    CollectionMapper collectionMapper;

    /**
     * 通过title获得书信息
     * @param title
     * @return
     */
    public Book getBookByTitle(String title) {
        return bookMapper.getBookByTitle(title);
    }


    /**
     * 添加收藏夹信息
     * @param username 用户名
     * @param title 书标题
     */
    public void setCollection(String username,String title){
        Collection collection = new Collection(username,title);
        collectionMapper.insertCollection(collection);
    }

    /**
     * 通过用户名查询用户收藏夹
     * @param username
     * @return
     */
    public List<CollectionInfo> getCollectionByUsername(String username) {
        return collectionMapper.getCollectionByUsername(username);
    }

}
