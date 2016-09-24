package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements Serializable {

	// Fields

	private Integer gid;
	private String gname;
	private String gdesc;
	private Set<Student> students = new HashSet<Student>();

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** minimal constructor */
	public Grade(String gname) {
		this.gname = gname;
	}
	

	public Grade(String gname, String gdesc) {
		this.gname = gname;
		this.gdesc = gdesc;
	}

	/** full constructor */
	public Grade(Integer gid, String gname, String gdesc, Set<Student> students) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
		this.students = students;
	}

	// Property accessors

	public Integer getGid() {
		return this.gid;
	}



	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return this.gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + ", gdesc=" + gdesc
				+ ", students=" + students + "]";
	}

	

}