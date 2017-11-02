package web.db.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Member")
public class Member implements Serializable {
	private static final long serialVersionUID = -7935894412001241428L;
	
	private int memberNo;
	private String name;
	private String phone;
	private String rank;
	private String email;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", name=" + name + ", phone=" + phone + ", rank=" + rank + ", email="
				+ email + "]";
	}
	
	

}