package cn.pluto.www.dao;

public class OrMappingProperty {
	private String name;
	private String column;
	private String type;
	private String lazy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String isLazy() {
		return lazy;
	}
	public void setLazy(String lazy) {
		this.lazy = lazy;
	}
	
}
