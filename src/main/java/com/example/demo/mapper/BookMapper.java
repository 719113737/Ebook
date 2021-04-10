package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 向数据库添加书信息
     * @param book 书
     * @return
     */
    @Insert("insert into book values(#{id},#{title},#{mAbastract},#{category},#{filePath},#{phases},#{imagePath});")
    int insertBook(Book book);

    /**
     * 通过书id寻找书信息
     * @param id
     * @return
     */
    @Select("select * from book where id = #{id};")
    Book getBookById(@Param("id")String id);


    /**
     * 通过title寻找书的信息
     * @param title
     * @return
     */
    @Select("select * from book where title = #{title};")
    Book getBookByTitle(@Param("title")String title);


    /**
     * 返回所有的书
     * @return
     */
    @Select("select * from book")
    List<Book> findAllBooks();

}
