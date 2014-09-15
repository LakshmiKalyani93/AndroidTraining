package com.pcs.helper;

import java.util.ArrayList;


public class GetDetails {

	UserDetails userobj;

	public ArrayList<UserDetails> userMethod{

		ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
		userobj = new UserDetails();

		userobj.setCustomername("kalyani");
		userobj.setCustomerid("pcs232");
		userobj.setAccountnumber("12345");
		userobj.setEmail("kalyani@pcs.com");
		userList.add(userobj);

		userobj = new UserDetails();
		userobj.setCustomername("anitha");
		userobj.setCustomerid("pcs233");
		userobj.setAccountnumber("24536");
		userobj.setEmail("anitha@pcs.com");
		userList.add(userobj);

		userobj = new UserDetails();
		userobj.setCustomername("harish");
		userobj.setCustomerid("pcs234");
		userobj.setAccountnumber("126845");
		userobj.setEmail("harish@pcs.com");
		userList.add(userobj);

		userobj = new UserDetails();
		userobj.setCustomername("dharma");
		userobj.setCustomerid("pcs235");
		userobj.setAccountnumber("1245345");
		userobj.setEmail("dharma@pcs.com");
		userList.add(userobj);

		return  userList;

	}
}
