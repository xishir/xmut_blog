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
    
    public void createTag(Map<String, Object> reqMap) {
    	tagmapper.createtag(reqMap);
    }
    
    public void  deleteTag(TagInfo taginfo) {
    	tagmapper.deleteTag(taginfo);
    }
    public void updataTag(String tag,String id) {
    	tagmapper.updataTag(tag,id);
    }
    public ArrayList<TagInfo> getSort(){
		return tagmapper.getSort();  	
    }
	
}
