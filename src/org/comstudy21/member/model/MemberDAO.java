package org.comstudy21.member.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MemberDAO {
	private static final Vector<MemberDTO> memList = new Vector<MemberDTO>();
	private static int sequence = 1;
	static {
		memList.add(new MemberDTO(sequence++, "홍길동", "hong@a.com", "010-1111-1111"));
		memList.add(new MemberDTO(sequence++, "이순신", "lee@a.com", "010-2222-2222"));
		memList.add(new MemberDTO(sequence++, "일지매", "il@a.com", "010-3333-3333"));
		memList.add(new MemberDTO(sequence++, "이순신", "lee2@a.com", "010-3333-3434"));
	}
	
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		for(MemberDTO mem : memList) {
			list.add((MemberDTO)mem.clone());
		}
		return list;
	}
	
	public MemberDTO selectOne(MemberDTO dto) {
		MemberDTO member = null;
		int i = memList.indexOf(dto);
		if(i!=-1) {
			member = memList.get(i);
		}
		return member;
	}
	
	public List<MemberDTO> selectByName(String name) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		for(int i=0; i<memList.size(); i++) {
			MemberDTO mem = memList.get(i);
			if(name.equals(mem.getName()) ) {
				list.add((MemberDTO)mem.clone());
			}
		}
		return list;
	}
	
	public boolean delete(MemberDTO dto) {
		return memList.remove(dto);
	}
	
	public MemberDTO update(MemberDTO dto) {
		int i = memList.indexOf(dto);
		if(i!=-1) {
			return memList.set(i, dto);
		} else {
			return null;
		}
	}
	
	public List<MemberDTO> fileLoad() {
		return null;
	}
	
	public boolean fileSave(List<MemberDTO> list) {
		return false;
	}

	public void insert(MemberDTO memberDTO) {
		memberDTO.setIdx(sequence++);
		memList.add(memberDTO);
	}
}
