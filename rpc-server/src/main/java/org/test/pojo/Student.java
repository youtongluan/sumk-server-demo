package org.test.pojo;

import java.util.Date;

import org.yx.annotation.db.Column;
import org.yx.annotation.db.ColumnType;
import org.yx.annotation.db.SoftDelete;
import org.yx.annotation.db.Table;
import org.yx.util.SumkDate;

@Table
@SoftDelete(value = "enable", columnType = Byte.class)
public class Student {

	@Column(columnType = ColumnType.ID_BOTH)
	private Long id;
	private String name;
	private Integer age;
	private Date lastUpdate;

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DemoUser [id=" + id + ", name=" + name + ", age=" + age + ", lastUpdate="
				+ (lastUpdate==null ? "null" : SumkDate.of(lastUpdate)).toString() + "]";
	}
}
