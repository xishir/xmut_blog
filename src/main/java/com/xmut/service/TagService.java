package com.xmut.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmut.dao.TagMapper;
import com.xmut.pojo.TagInfo;

@Service
public class TagService {
    @Autowired
	private TagMapper tagmapper;
    
    public void createTag(String tag) {
    	tagmapper.createtag(tag);
    }
    
    public void  deleteTag(TagInfo taginfo) {
    	tagmapper.deleteTag(taginfo);
    }
    public void updataTag(String tag,String id) {
    	tagmapper.updataTag(tag,id);
    }
    public ArrayList<String> getSort(){
		return tagmapper.getSort();  	
    }
    public ArrayList<TagInfo> getSorts(){
		return tagmapper.getSorts();  	
    }
    
    public Integer getTagNum()
    {
    	String num=tagmapper.getTagNum();
    	return Integer.parseInt(num);
    }
	
}
