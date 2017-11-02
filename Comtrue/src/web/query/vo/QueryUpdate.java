package web.query.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("QueryUpdate")
public class QueryUpdate implements Serializable {
	private static final long serialVersionUID = -7935894412001241428L;
	
	private int memberNo;
	private int originalMemberNo;
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
	public int getOriginalMemberNo() {
		return originalMemberNo;
	}
	public void setOriginalMemberNo(int originalMemberNo) {
		this.originalMemberNo = originalMemberNo;
	}
	@Override
	public String toString() {
		return "QueryUpdate [memberNo=" + memberNo + ", originalMemberNo=" + originalMemberNo + ", name=" + name
				+ ", phone=" + phone + ", rank=" + rank + ", email=" + email + "]";
	}
	
	

}