package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.Board;
import org.zerock.domain.PageParam;

public interface BoardMapper {

	@Select("select * from tbl_board order by bno desc limit #{skip}, 10")
	public List<Board> getList(PageParam pageParam);
	
	@Insert("insert into tbl_board(title,content,writer) " + 
			"values (#{title},#{content},#{writer})")
	public int insert(Board board);
}
