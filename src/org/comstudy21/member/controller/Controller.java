package org.comstudy21.member.controller;

import org.comstudy21.member.resource.R;
import org.comstudy21.member.view.MemberView;

public abstract class Controller extends R {
	public abstract MemberView hadleRequest();
}
