package org.comstudy21.member.controller;

import static org.comstudy21.member.resource.R.*;
import org.comstudy21.member.view.MemberView;

public class DispatcherController {
	private static MemberView view = null;
	private static Controller ctrl = null;
	
	public static void run() {
		//view = new InputController().hadleRequest();
		//view = new MenuController().hadleRequest();
		
		ctrl = ctrlMapper.get(no);
		view = ctrl.hadleRequest();
		mainActivity.setContentView(view);
		
		run(); // 재귀호출
	}
}
