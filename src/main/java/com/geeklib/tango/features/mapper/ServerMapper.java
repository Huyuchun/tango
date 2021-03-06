package com.geeklib.tango.features.mapper;

import com.geeklib.tango.features.entity.Server;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

public interface ServerMapper {

    @Delete("DELETE FROM server WHERE id = #{id}")
    int deleteByPrimaryKey(Long id);

    @Insert("INSERT INTO server (name, gmt_create, gmt_modified, username, password, address, type, project_id, description) VALUES (#{name},#{gmtCreate},#{gmtModified},#{username},#{password},#{address},#{type},#{projectId},#{description});")
    int insert(Server record);

    int insertSelective(Server record);

    @Select("SELECT\r\n" + 
    		"	s.id,\r\n" + 
    		"	s.`name`,\r\n" + 
    		"	s.gmt_create,\r\n" + 
    		"	s.gmt_modified,\r\n" + 
    		"	s.username,\r\n" + 
    		"	s.`password`,\r\n" + 
    		"	s.address,\r\n" + 
    		"	s.type,\r\n" + 
    		"	s.project_id,\r\n" + 
    		"	s.description,\r\n" + 
    		"	p.id,\r\n" + 
    		"	p.`name` AS projectName\r\n" + 
    		"FROM\r\n" + 
    		"	`server` AS s\r\n" + 
    		"LEFT JOIN project AS p ON s.project_id = p.id")
    List<Server> listServer();

    Server selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);
    
    
}