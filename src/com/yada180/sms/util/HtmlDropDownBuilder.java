package com.yada180.sms.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.yada180.sms.domain.Farm;

public class HtmlDropDownBuilder {

	public void refresh(HttpSession session) {
	   	List<Farm> list = new ArrayList<Farm>();
    	list.add(new Farm(new Long(1),"BOYNTON BEACH"));
    	list.add(new Farm(new Long(2),"FORT LAUDERDALE"));
    	list.add(new Farm(new Long(3),"OKEECHOBEE"));
    	list.add(new Farm(new Long(4),"WOMEN'S HOME"));
    	session.setAttribute("ddl_farms", list);
	}
}
