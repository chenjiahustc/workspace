package cn.pluto.www.dao;

import java.util.List;

public class OrMappingClass {
	private String name = "";
	private String table = "";
	private String id = "";
	private List<OrMappingProperty> properties = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<OrMappingProperty> getProperties() {
		return properties;
	}
	public void setProperties(List<OrMappingProperty> properties) {
		this.properties = properties;
	}
}
