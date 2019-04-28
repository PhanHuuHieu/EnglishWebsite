package StudyEnglish.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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


@RestController
public class MainController {
	@Autowired
	private ServiceAll sv;
	
	@GetMapping("/JSONProccess")
	public HashMap<String, Object> JSONProccess() {
		HashMap<String, Object> map = new HashMap<>();
		List<Proccess> listPr=new ArrayList<Proccess>();
		listPr=sv.findAllProccess();
		for(int i=0;i<listPr.size();i++)
		{
			map.put("listProccess"+i, listPr.get(i));
		}
	    return map;
	}
	
	@GetMapping("/JSONSoundsame")
	public HashMap<String, Object> JSONSoundSame() {
		HashMap<String, Object> map = new HashMap<>();
		List<Soundsame> listSs=new ArrayList<Soundsame>();
		listSs=sv.findAllSoundSame();
		for(int i=0;i<listSs.size();i++)
		{
			map.put("listSoundSame"+i, listSs.get(i));
		}
	    return map;
	}
	
	@GetMapping("/JSONTypeword")
	public HashMap<String, Object> JSONTypeword() {
		HashMap<String, Object> map = new HashMap<>();
		List<Typeword> list=new ArrayList<Typeword>();
		list=sv.findAllTypeWord();
		for(int i=0;i<list.size();i++)
		{
			map.put("listTypeword"+i, list.get(i));
		}
	    return map;
	}
	
	@GetMapping("/JSONUnit")
	public HashMap<String, Object> JSONUnit() {
		HashMap<String, Object> map = new HashMap<>();
		List<Unit> list=new ArrayList<Unit>();
		list=sv.findAllUnit();
		for(int i=0;i<list.size();i++)
		{
			map.put("listUnit"+i, list.get(i));
		}
	    return map;
	}
	
	@GetMapping("/JSONUsers")
	public HashMap<String, Object> JSONUsers() {
		HashMap<String, Object> map = new HashMap<>();
		List<Users> list=new ArrayList<Users>();
		list=sv.findAllUsers();
		for(int i=0;i<list.size();i++)
		{
			map.put("listUsers"+i, list.get(i));
		}
	    return map;
	}
	
	@GetMapping("/JSONVocabulary")
	public HashMap<String, Object> JSONVocabulary() {
		HashMap<String, Object> map = new HashMap<>();
		List<Vocabulary> list=new ArrayList<Vocabulary>();
		list=sv.findAllVocabulary();
		for(int i=0;i<list.size();i++)
		{
			map.put("listVocabulary"+i, list.get(i));
		}
	    return map;
	}
	@GetMapping("/JSONAudio")
	public HashMap<String, Object> JSONAudio() {
		HashMap<String, Object> map = new HashMap<>();
		List<Audio> list=new ArrayList<Audio>();
		list=sv.findAllAudio();
		for(int i=0;i<list.size();i++)
		{
			map.put("listAudio"+i, list.get(i));
		}
	    return map;
	}
	@GetMapping("/JSONContentstory")
	public HashMap<String, Object> JSONContentstory() {
		HashMap<String, Object> map = new HashMap<>();
		List<Contentstory> list=new ArrayList<Contentstory>();
		list=sv.findAllContentstory();
		for(int i=0;i<list.size();i++)
		{
			map.put("listContentstory"+i, list.get(i));
		}
	    return map;
	}
	@GetMapping("/JSONMytopic")
	public HashMap<String, Object> JSONMytopic() {
		HashMap<String, Object> map = new HashMap<>();
		List<Mytopic> list=new ArrayList<Mytopic>();
		list=sv.findAllMytopic();
		for(int i=0;i<list.size();i++)
		{
			map.put("listMytopic"+i, list.get(i));
		}
	    return map;
	}
	@GetMapping("/JSONMyvocabulary")
	public HashMap<String, Object> JSONMyvocabulary() {
		HashMap<String, Object> map = new HashMap<>();
		List<Myvocabulary> list=new ArrayList<Myvocabulary>();
		list=sv.findAllMyvocabulary();
		for(int i=0;i<list.size();i++)
		{
			map.put("listMytopic"+i, list.get(i));
		}
	    return map;
	}
	@GetMapping("/JSONPart1")
	public HashMap<String, Object> JSONPart1() {
		HashMap<String, Object> map = new HashMap<>();
		List<Part1> list=new ArrayList<Part1>();
		list=sv.findAllPart1();
		for(int i=0;i<list.size();i++)
		{
			map.put("listMytopic"+i, list.get(i));
		}
	    return map;
	}
}