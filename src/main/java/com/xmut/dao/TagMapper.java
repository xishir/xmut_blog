package com.xmut.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xmut.pojo.TagInfo;

public interface TagMapper {
	
	@Insert("INSERT INTO blog.k_tag VALUES (#{id},#{tag})")
    void createtag(Map<String, Object> reqMap);
	
	@Delete("DELETE FROM blog.k_tag WHERE id = #{id} or tag=#{tag}")
    void deleteTag(TagInfo taginfo);
	
	@Select("select distinct(tag) FROM blog.k_tag ")
    ArrayList<TagInfo> getSort();
	
	@Update("UPDATE blog.k_tag SET tag = #{tag} WHERE id = #{id}")
    void updataTag(@Param("tag") String tag,@Param("id") String id);

}
