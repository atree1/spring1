package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.Board;
import org.zerock.domain.PageParam;

public interface BoardMapper {

	
	public List<Board> getList(PageParam pageParam);
	
	
	public int insert(Board board);
	
	
	public int count(PageParam PageParam);
	
	
	public Board get(PageParam param);
	
	
	public int delete(PageParam param);
	
	
	public int update(Board board);
	
	public List<Board> search(PageParam pageParam);
}
