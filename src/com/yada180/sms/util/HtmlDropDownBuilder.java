package com.yada180.sms.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.yada180.sms.domain.DropDownItem;
import com.yada180.sms.domain.Farm;
import com.yada180.sms.domain.State;
import com.yada180.sms.hibernate.dao.MedicalConditionDao;
import com.yada180.sms.hibernate.dao.QuestionDao;
import com.yada180.sms.hibernate.dao.StateDao;

public class HtmlDropDownBuilder {

	public void refresh(HttpSession session) {
	   	List<Farm> list = new ArrayList<Farm>();
    	list.add(new Farm(new Long(1),"BOYNTON BEACH"));
    	list.add(new Farm(new Long(2),"FORT LAUDERDALE"));
    	list.add(new Farm(new Long(3),"OKEECHOBEE"));
    	list.add(new Farm(new Long(4),"WOMEN'S HOME"));
    	session.setAttribute("ddl_farm", list);
    	
        StateDao dao3 = new StateDao();
        List<State> list3 = new ArrayList<State>();
        list3=dao3.listStates();
        session.setAttribute("ddl_state", list3);
        
        QuestionDao dao4 = new QuestionDao();
        List<State> questions = new ArrayList<State>();
        questions=dao4.listQuestions();
        session.setAttribute("questions", questions);
        
        MedicalConditionDao dao5 = new MedicalConditionDao();
        List<State> medicalConditions = new ArrayList<State>();
        medicalConditions=dao5.listMedicalConditions();
        session.setAttribute("medicalConditions", medicalConditions);
        System.out.println ("cond="+medicalConditions.size());
        
		   List<DropDownItem> suffix = new ArrayList<DropDownItem>();
		   suffix.add(new DropDownItem("Jr.","Jr."));
		   suffix.add(new DropDownItem("Sr.","Sr"));
		   suffix.add(new DropDownItem("I","I"));
		   suffix.add(new DropDownItem("II","II"));
		   suffix.add(new DropDownItem("III","III"));
		   session.setAttribute("ddl_suffix", list);
		   
		   List<DropDownItem> programStatus = new ArrayList<DropDownItem>();
	        programStatus.add(new DropDownItem("In Program","In Program"));
	        programStatus.add(new DropDownItem("Walked Off","Walked Off"));
	        programStatus.add(new DropDownItem("Dismissed","Dismissed"));
	        programStatus.add(new DropDownItem("Left Prop./Did Not Graduate","Left Prop./Did Not Graduate"));
	        programStatus.add(new DropDownItem("Left Prop./Graduated","Left Prop./Graduated"));
	        programStatus.add(new DropDownItem("Left Prop./Graduated to SLS","Left Prop./Graduated to SLS"));
	        programStatus.add(new DropDownItem("Left Prop./Graduated to Omega","Left Prop./Graduated to Omega"));
	        programStatus.add(new DropDownItem("Dismissed - Banned 30 days","Dismissed - Banned 30 days"));
	        programStatus.add(new DropDownItem("Dismissed - Banned 60 days","Dismissed - Banned 60 days"));
	        programStatus.add(new DropDownItem("Dismissed - Banned 90 days","Dismissed - Banned 90 days"));
	        programStatus.add(new DropDownItem("Dismissed - Banned Perm.","Dismissed - Banned Perm."));
	        session.setAttribute("ddl_programStatus", list);
	        
	        List<DropDownItem> phase = new ArrayList<DropDownItem>();
	        phase.add(new DropDownItem("Phase I","Phase I"));
	        phase.add(new DropDownItem("SLS","SLS"));
	        phase.add(new DropDownItem("Omega","Omega"));
	        session.setAttribute("ddl_phase", list);
	        
	        List<DropDownItem> passType = new ArrayList<DropDownItem>();
	        passType.add(new DropDownItem("Medical","Medical"));
	        passType.add(new DropDownItem("Probation/Court","Probation/Court"));
	        passType.add(new DropDownItem("8 Hours","8 Hours"));
	        passType.add(new DropDownItem("3 Days","3 Days"));
	        passType.add(new DropDownItem("Special","Special"));
	        session.setAttribute("ddl_passType", passType);
	        
	        List<DropDownItem> yesNo = new ArrayList<DropDownItem>();
	        yesNo.add(new DropDownItem("YES","YES"));
	        yesNo.add(new DropDownItem("NO","NO"));
	        session.setAttribute("ddl_yesNo", yesNo);
	        
	        List<DropDownItem> military = new ArrayList<DropDownItem>();
	        military.add(new DropDownItem("Air Force","Air Force"));
	        military.add(new DropDownItem("Army","Army"));
	        military.add(new DropDownItem("Army National Guard","Army National Guard"));
	        military.add(new DropDownItem("Coast Guard","Coast Guard"));
	        military.add(new DropDownItem("Marines","Marines"));
	        military.add(new DropDownItem("Navy","Navy"));
	        session.setAttribute("ddl_military", military);
	        
	        List<DropDownItem> eyes = new ArrayList<DropDownItem>();
	        eyes.add(new DropDownItem("All the time","All the time"));
	        eyes.add(new DropDownItem("Occasionally","Occasionally"));
	        eyes.add(new DropDownItem("Reading","Reading"));
	        session.setAttribute("ddl_eyewear", eyes);
	        
	        List<DropDownItem> health = new ArrayList<DropDownItem>();
	        health.add(new DropDownItem("excellent","excellent"));
	        health.add(new DropDownItem("good","good"));
	        health.add(new DropDownItem("fair","fair"));
	        health.add(new DropDownItem("failing","failing"));
	        health.add(new DropDownItem("poor","poor"));
	        session.setAttribute("ddl_health", health);
	        
	        List<DropDownItem> claimStatus = new ArrayList<DropDownItem>();
	        claimStatus.add(new DropDownItem("open","open"));
	        claimStatus.add(new DropDownItem("closed","closed"));
	        session.setAttribute("ddl_claim_status", claimStatus);
	        
	        List<DropDownItem> religion = new ArrayList<DropDownItem>();
	        religion.add(new DropDownItem("Christian","Christian"));
	        religion.add(new DropDownItem("Buddhist","Buddhist"));
	        religion.add(new DropDownItem("Catholic","Catholic"));
	        religion.add(new DropDownItem("Hindu","Hindu"));
	        religion.add(new DropDownItem("Jewish","Jewish"));
	        religion.add(new DropDownItem("New Age","New Age"));
	        religion.add(new DropDownItem("Protestant","Protestant"));
	        religion.add(new DropDownItem("Rastafarian","Rastafarian"));
	        religion.add(new DropDownItem("Santaria","Santaria"));
	        religion.add(new DropDownItem("Other","Other"));
	        session.setAttribute("ddl_religion", religion);
	        
	        List<DropDownItem> ethnicity = new ArrayList<DropDownItem>();
	        ethnicity.add(new DropDownItem("American Indian/Alaskan Native","American Indian/Alaskan Native"));
	        ethnicity.add(new DropDownItem("Asian/Pacific Islander","Asian/Pacific Islander"));
	        ethnicity.add(new DropDownItem("Black, not Hispanic","Black, not Hispanic"));
	        ethnicity.add(new DropDownItem("Hispanic","Hispanic"));
	        ethnicity.add(new DropDownItem("White, not Hispanic","White, not Hispanic"));
	        session.setAttribute("ddl_ethnicity", ethnicity);
	        
	        List<DropDownItem> maritalStatus = new ArrayList<DropDownItem>();
	        maritalStatus.add(new DropDownItem("Never Married","Never Married"));
	        maritalStatus.add(new DropDownItem("Married","Married"));
	        maritalStatus.add(new DropDownItem("Divorced","Divorced"));
	        maritalStatus.add(new DropDownItem("Separated","Separated"));
	        maritalStatus.add(new DropDownItem("Spouse Deceased","Spouse Deceased"));
	        maritalStatus.add(new DropDownItem("Lives with Girlfriend","Lives with Girlfriend"));
	        maritalStatus.add(new DropDownItem("Lives with Boyfriend","Lives with Boyfriend"));
	        maritalStatus.add(new DropDownItem("Remarried","Remarried"));
	        maritalStatus.add(new DropDownItem("Re-divorced","Re-divorced"));
	        session.setAttribute("ddl_maritalstatus", maritalStatus);
	        
	        List<DropDownItem> living = new ArrayList<DropDownItem>();
	        living.add(new DropDownItem("Own Home","Own Home"));
	        living.add(new DropDownItem("Parent's Home","Parent's Home"));
	        living.add(new DropDownItem("Friend's Home","Friend's Home"));
	        living.add(new DropDownItem("Halfway Home","Halfway Home"));
	        living.add(new DropDownItem("Hotel","Hotel"));
	        living.add(new DropDownItem("Rehab Program","Rehab Program"));
	        living.add(new DropDownItem("Vehicle","Vehicle"));
	        living.add(new DropDownItem("On Street","On Street"));
	        living.add(new DropDownItem("Other","Other"));
	        session.setAttribute("ddl_living", living);
	        
	        List<DropDownItem> education = new ArrayList<DropDownItem>();
	        education.add(new DropDownItem("Elementary","Elementary"));
	        education.add(new DropDownItem("High School","High School"));
	        education.add(new DropDownItem("GED","GED"));
	        education.add(new DropDownItem("Bachelor's Degree","Bachelor's Degree"));
	        education.add(new DropDownItem("Master's Degree","Master's Degree"));
	        education.add(new DropDownItem("Doctorate Degree","Doctorate Degree"));
	        education.add(new DropDownItem("Associates Degree","Associates Degree"));
	        education.add(new DropDownItem("Vocational School","Vocational School"));
	        session.setAttribute("ddl_education", education);
	        
	        List<DropDownItem> hairColor = new ArrayList<DropDownItem>();
	        hairColor.add(new DropDownItem("Brown","Brown"));
	        hairColor.add(new DropDownItem("Black","Black"));
	        hairColor.add(new DropDownItem("Blonde","Blonde"));
	        hairColor.add(new DropDownItem("Blonde/Strawberry","Blonde/Strawberry"));
	        hairColor.add(new DropDownItem("Gray or Partially Gray","Gray or Partially Gray"));
	        hairColor.add(new DropDownItem("Partly or Completely Bald","Partly or Completely Bald"));
	        hairColor.add(new DropDownItem("Red/Auburn","Red/Auburn"));
	        hairColor.add(new DropDownItem("Sandy","Sandy"));
	        hairColor.add(new DropDownItem("Salt & Pepper","Salt & Pepper"));
	        hairColor.add(new DropDownItem("Shaved","Shaved"));
	        hairColor.add(new DropDownItem("White","White"));
	        session.setAttribute("ddl_haircolor", hairColor);
	        
	        List<DropDownItem> eyecolor = new ArrayList<DropDownItem>();
	        eyecolor.add(new DropDownItem("Blue","Blue"));
	        eyecolor.add(new DropDownItem("Brown","Brown"));
	        eyecolor.add(new DropDownItem("Green","Green"));
	        eyecolor.add(new DropDownItem("Hazel","Hazel"));
	        eyecolor.add(new DropDownItem("Other","Other"));
	        session.setAttribute("ddl_eyecolor", eyecolor);
	        
	        List<DropDownItem> herniaSide = new ArrayList<DropDownItem>();
	        herniaSide.add(new DropDownItem("RIGHT","RIGHT"));
	        herniaSide.add(new DropDownItem("LEFT","LEFT"));
	        session.setAttribute("ddl_herniaside", herniaSide);
	 
	}
}
