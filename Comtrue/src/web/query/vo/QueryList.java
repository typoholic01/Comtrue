package web.query.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("QueryList")
public class QueryList implements Serializable {
	private static final long serialVersionUID = -2619339902153486228L;
	
	private String column;					//컬럼
	private String scending;				//오름/내림차순
	private String query;					//검색어
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getScending() {
		return scending;
	}
	public void setScending(String scending) {
		this.scending = scending;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	@Override
	public String toString() {
		return "QueryList [column=" + column + ", scending=" + scending + ", query=" + query + "]";
	}
	
	
	
}
