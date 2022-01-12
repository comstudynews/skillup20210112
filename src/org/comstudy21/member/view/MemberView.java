package org.comstudy21.member.view;

import org.comstudy21.member.resource.R;

public abstract class MemberView extends R{
	public  void display() {
		
		boolean isMenu = onCreate();
		
		// 모든 뷰가 공통으로 끝날때 실행
		if(!isMenu) {
			no = MENU;
		}
		
		System.out.println("---------------------------");
	}
	public abstract boolean onCreate();
}
