package org.comstudy21.member.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MemberDAO {
	private static Vector<MemberDTO> memList = new Vector<MemberDTO>();
	private static int sequence = 1;
	static {
		memList.add(new MemberDTO(sequence++, "홍길동", "hong@a.com", "010-1111-1111"));
		memList.add(new MemberDTO(sequence++, "이순신", "lee@a.com", "010-2222-2222"));
		memList.add(new MemberDTO(sequence++, "일지매", "il@a.com", "010-3333-3333"));
		memList.add(new MemberDTO(sequence++, "이순신", "lee2@a.com", "010-3333-3434"));
	}
	
	public List<MemberDTO> selectAll() {
		memList = (Vector<MemberDTO>)fileLoad();
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
	
	File file = new File("member.dat");
	public List<MemberDTO> fileLoad() {
		List<MemberDTO> list = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			list = (List<MemberDTO>)ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ois != null)
				try {
					ois.close();
					fis.close();
				} catch (IOException e) {}
		}
		
		memList = (Vector<MemberDTO>) list;
		return list;
	}
	
	public boolean fileSave(List<MemberDTO> list) {
		// memList저장하기
		FileWriter fw = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		boolean b = false;
		try {
			 fos = new FileOutputStream(file);
			 oos = new ObjectOutputStream(fos);
			 oos.writeObject(memList);
			 b = true;
		} catch (IOException e) {
			
		} finally {
			try {
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch (IOException e) { }
		}
		
		return b;
	}

	public void insert(MemberDTO memberDTO) {
		memberDTO.setIdx(sequence++);
		memList.add(memberDTO);
		
		if(fileSave(memList)) {
			System.out.println(">>> 파일 저장 완료!");
		} else {
			System.out.println(">>> 파일 쓰기 오류!");
		}
	}
}
