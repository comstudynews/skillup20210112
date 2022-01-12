package org.comstudy21.member.controller;

import java.util.List;

import org.comstudy21.member.model.MemberDTO;
import org.comstudy21.member.view.MemberView;

public class ListController extends Controller {

	@Override
	public MemberView hadleRequest() {
		List<MemberDTO> memList = memDao.selectAll();
		request.put("memList", memList);
		
		return list;
	}

}
