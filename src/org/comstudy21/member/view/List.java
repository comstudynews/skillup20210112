package org.comstudy21.member.view;


import org.comstudy21.member.model.MemberDTO;

public class List extends MemberView {
	@Override
	public boolean onCreate() {
		System.out.println(titleList);
		
		// request에서 List를 가져오기
		java.util.List<MemberDTO> memList = (java.util.List<MemberDTO>)request.get("memList");
		for(MemberDTO member : memList) {
			System.out.println(member);
		}
		
		return false;
	}
}
