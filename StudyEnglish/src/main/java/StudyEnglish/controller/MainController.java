package StudyEnglish.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import StudyEnglish.model.Audio;
import StudyEnglish.model.Contentstory;
import StudyEnglish.model.Mytopic;
import StudyEnglish.model.Myvocabulary;
import StudyEnglish.model.Part1;
import StudyEnglish.model.Proccess;
import StudyEnglish.model.Soundsame;
import StudyEnglish.model.Typeword;
import StudyEnglish.model.Unit;
import StudyEnglish.model.Users;
import StudyEnglish.model.Vocabulary;
import StudyEnglish.service.ServiceAll;


@Controller
public class MainController {
	@Autowired
	private ServiceAll sv;
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONSoundsame")
	@ResponseBody
	public List<Soundsame> JSONSoundSame() {
		List<Soundsame> listSs=new ArrayList<Soundsame>();
		listSs=sv.findAllSoundSame();
	    return listSs;
	}
	
	@GetMapping("/JSONTypeword")
	@ResponseBody
	public List<Typeword> JSONTypeword() {
		List<Typeword> list=new ArrayList<Typeword>();
		list=sv.findAllTypeWord();
	    return list;
	}
	
	@GetMapping("/JSONUnit")
	@ResponseBody
	public List<Unit> JSONUnit() {
		List<Unit> list=new ArrayList<Unit>();
		list=sv.findAllUnit();
	    return list;
	}
	
	@GetMapping("/JSONUsers")
	@ResponseBody
	public List<Users> JSONUsers() {
		List<Users> list=new ArrayList<Users>();
		list=sv.findAllUsers();
	    return list;
	}
	
	@GetMapping("/JSONVocabulary")
	@ResponseBody
	public List<Vocabulary> JSONVocabulary() {
		List<Vocabulary> list=new ArrayList<Vocabulary>();
		list=sv.findAllVocabulary();
		Collections.sort(list, new Vocabulary());
	    return list;
	}
	@GetMapping("/JSONAudio")
	@ResponseBody
	public List<Audio> JSONAudio() {
		List<Audio> list=new ArrayList<Audio>();
		list=sv.findAllAudio();
	    return list;
	}
	@GetMapping("/JSONContentstory")
	@ResponseBody
	public List<Contentstory> JSONContentstory() {
		List<Contentstory> list=new ArrayList<Contentstory>();
		list=sv.findAllContentstory();
	    return list;
	}
	@GetMapping("/JSONMytopic")
	@ResponseBody
	public List<Mytopic> JSONMytopic() {
		List<Mytopic> list=new ArrayList<Mytopic>();
		list=sv.findAllMytopic();
	    return list;
	}
	@GetMapping("/JSONMyvocabulary")
	@ResponseBody
	public List<Myvocabulary> JSONMyvocabulary() {
		List<Myvocabulary> list=new ArrayList<Myvocabulary>();
		list=sv.findAllMyvocabulary();
	    return list;
	}
	@GetMapping("/JSONPart1")
	@ResponseBody
	public List<Part1> JSONPart1() {
		List<Part1> list=new ArrayList<Part1>();
		list=sv.findAllPart1();
	    return list;
	}
	@GetMapping("/JSONContentstoryTextbox")
	@ResponseBody
	public List<Contentstory> TraVe3ChamTrongContent(HttpServletRequest request) {
		List<Contentstory> list=new ArrayList<Contentstory>();
		List<Vocabulary> listVoca=new ArrayList<Vocabulary>();
		
		listVoca=sv.findAllVocabulary();
		list=sv.findAllContentstory();
		String l="";
		String temp="";
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<listVoca.size();j++)
			{
				if(!(list.get(i).getContentenglish().indexOf(listVoca.get(j).getVoca())==-1))
				{
					
					temp="<input name='"+listVoca.get(j).getIdvocabulary()+"'"+"></input>";
					l=list.get(i).getContentenglish().replace(listVoca.get(j).getVoca(),temp);
					list.get(i).setContentenglish(l);			
				}
			}
			
		}
		return list;
	}
}
//	@GetMapping("/JSONContentstory2")
//	@ResponseBody
//	public int TraVeViTriTiengVietTrongContent(HttpServletRequest request) {
//		List<Contentstory> list=new ArrayList<Contentstory>();
//		List<Vocabulary> listVoca=new ArrayList<Vocabulary>();
//		listVoca=sv.findAllVocabulary();
//		list=sv.findAllContentstory();
//		// char character = chuoi.charAt(4);
//		int firstIndex=-2;
//		int lastIndex=-2;
//		int []m;
//		int mIndex=0;
//		String l="";
//		m=new int[100];
//		for(int i=0;i<list.size();i++)
//		{
//			for(int j=0;j<listVoca.size();j++)
//			{
//				if(!(list.get(i).getContent().indexOf(listVoca.get(j).getVoca())==-1))
//				{
//					firstIndex=list.get(i).getContent().indexOf(listVoca.get(j).getVoca());
//					lastIndex=firstIndex+listVoca.get(j).getVoca().length();
//					m[mIndex++]=i;
//					m[mIndex++]=firstIndex;
//					m[mIndex++]=lastIndex;
//				}
//			}
//		}
//		int []arr=new int[mIndex];
//		for(int i=0;i<mIndex;i++)
//		{
//			arr[i]=m[i];
//		}
//	    return arr;
//	}
//	@GetMapping("/JSONContentstory3")
//	public String TraVeViTriTiengAnhTrongContent(HttpServletRequest request) {
//		List<Contentstory> list=new ArrayList<Contentstory>();
//		List<Vocabulary> listVoca=new ArrayList<Vocabulary>();
//		listVoca=sv.findAllVocabulary();
//		list=sv.findAllContentstory();
//		// char character = chuoi.charAt(4);
//		int firstIndex=-2;
//		int lastIndex=-2;
//		int []m;
//		int mIndex=0;
//		String l="";
//		m=new int[100];
//		for(int i=0;i<list.size();i++)
//		{
//			for(int j=0;j<listVoca.size();j++)
//			{
//				if(!(list.get(i).getContentenglish().indexOf(listVoca.get(j).getVoca())==-1))
//				{
//					firstIndex=list.get(i).getContentenglish().indexOf(listVoca.get(j).getVoca());
//					lastIndex=firstIndex+listVoca.get(j).getVoca().length();
//					m[mIndex++]=i;
//					m[mIndex++]=firstIndex;
//					m[mIndex++]=lastIndex;
//				}
//			}
//		}
//		int []arr=new int[mIndex];
//		for(int i=0;i<mIndex;i++)
//		{
//			arr[i]=m[i];
//		}
//		//l=list.get(0).getContentenglish();
//		request.setAttribute("task1",arr);
//	    return "part1";
//	}
//}
//	@GetMapping("/listProduct")
//	@ResponseBody
//	public List<Proccess> JSONProccess() {
//		List<Proccess> listPr=new ArrayList<Proccess>();
//		listPr=sv.findAllProccess();
//		return listPr;
//	}
//	@GetMapping("/JSONSoundsame")
//	public HashMap<String, Object> JSONSoundSame() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Soundsame> listSs=new ArrayList<Soundsame>();
//		listSs=sv.findAllSoundSame();
//		for(int i=0;i<listSs.size();i++)
//		{
//			map.put("listSoundSame"+i, listSs.get(i));
//		}
//	    return map;
//	}
//	
//	@GetMapping("/JSONTypeword")
//	public HashMap<String, Object> JSONTypeword() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Typeword> list=new ArrayList<Typeword>();
//		list=sv.findAllTypeWord();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listTypeword"+i, list.get(i));
//		}
//	    return map;
//	}
//	
//	@GetMapping("/JSONUnit")
//	public HashMap<String, Object> JSONUnit() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Unit> list=new ArrayList<Unit>();
//		list=sv.findAllUnit();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listUnit"+i, list.get(i));
//		}
//	    return map;
//	}
//	
//	@GetMapping("/JSONUsers")
//	public HashMap<String, Object> JSONUsers() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Users> list=new ArrayList<Users>();
//		list=sv.findAllUsers();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listUsers"+i, list.get(i));
//		}
//	    return map;
//	}
//	
//	@GetMapping("/JSONVocabulary")
//	public HashMap<String, Object> JSONVocabulary() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Vocabulary> list=new ArrayList<Vocabulary>();
//		list=sv.findAllVocabulary();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listVocabulary"+i, list.get(i));
//		}
//	    return map;
//	}
//	@GetMapping("/JSONAudio")
//	public HashMap<String, Object> JSONAudio() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Audio> list=new ArrayList<Audio>();
//		list=sv.findAllAudio();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listAudio"+i, list.get(i));
//		}
//	    return map;
//	}
//	@GetMapping("/JSONContentstory")
//	public HashMap<String, Object> JSONContentstory(HttpServletRequest request) {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Contentstory> list=new ArrayList<Contentstory>();
//		list=sv.findAllContentstory();
//		request.setAttribute("listContentstory",list);
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listContentstory"+i, list.get(i));
//		}
//	    return map;
//	}
	
//	@GetMapping("/JSONMytopic")
//	public HashMap<String, Object> JSONMytopic() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Mytopic> list=new ArrayList<Mytopic>();
//		list=sv.findAllMytopic();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listMytopic"+i, list.get(i));
//		}
//	    return map;
//	}
//	@GetMapping("/JSONMyvocabulary")
//	public HashMap<String, Object> JSONMyvocabulary() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Myvocabulary> list=new ArrayList<Myvocabulary>();
//		list=sv.findAllMyvocabulary();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listMytopic"+i, list.get(i));
//		}
//	    return map;
//	}
//	@GetMapping("/JSONPart1")
//	public HashMap<String, Object> JSONPart1() {
//		HashMap<String, Object> map = new HashMap<>();
//		List<Part1> list=new ArrayList<Part1>();
//		list=sv.findAllPart1();
//		for(int i=0;i<list.size();i++)
//		{
//			map.put("listMytopic"+i, list.get(i));
//		}
//	    return map;
//	}
//}