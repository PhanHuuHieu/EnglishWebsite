package StudyEnglish.controller;

import java.net.URISyntaxException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.node.ObjectNode;

import StudyEnglish.model.Audio;
import StudyEnglish.model.Contentstory;
import StudyEnglish.model.Mytopic;
import StudyEnglish.model.Myvocabulary;
import StudyEnglish.model.Part1;
import StudyEnglish.model.Proccess;
import StudyEnglish.model.Typeword;
import StudyEnglish.model.Unit;
import StudyEnglish.model.Users;
import StudyEnglish.model.Vocabulary;
import StudyEnglish.service.ServiceAll;


@Controller
public class MainController {
	@Autowired
	private ServiceAll sv;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONTypeword")
	@ResponseBody
	public List<Typeword> JSONTypeword() {
		List<Typeword> list=new ArrayList<Typeword>();
		list=sv.findAllTypeWord();
	    return list;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONUnit")
	@ResponseBody
	public List<Unit> JSONUnit() {
		List<Unit> list=new ArrayList<Unit>();
		list=sv.findAllUnit();
	    return list;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONUsers")
	@ResponseBody
	public List<Users> JSONUsers() {
		List<Users> list=new ArrayList<Users>();
		list=sv.findAllUsers();
	    return list;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONVocabulary")//Load vocabulary part 2
	@ResponseBody
	public List<Vocabulary> JSONVocabulary() {
		List<Vocabulary> list=new ArrayList<Vocabulary>();
		List<Vocabulary> listVocaPart2=new ArrayList<Vocabulary>();
		list=sv.findAllVocabulary();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getIdpart1()==2)
			{
				listVocaPart2.add(list.get(i));
			}
		}
		Collections.sort(listVocaPart2, new Vocabulary());
	    return listVocaPart2;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONAudio")
	@ResponseBody
	public List<Audio> JSONAudio() {
		List<Audio> list=new ArrayList<Audio>();
		list=sv.findAllAudio();
	    return list;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONContentstory")
	@ResponseBody
	public List<Contentstory> JSONContentstory() {
		List<Contentstory> list=new ArrayList<Contentstory>();
		list=sv.findAllContentstory();
	    return list;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONMytopic")
	@ResponseBody
	public List<Mytopic> JSONMytopic() {
		List<Mytopic> list=new ArrayList<Mytopic>();
		list=sv.findAllMytopic();
	    return list;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONMyvocabulary")
	@ResponseBody
	public List<Myvocabulary> JSONMyvocabulary() {
		List<Myvocabulary> list=new ArrayList<Myvocabulary>();
		list=sv.findAllMyvocabulary();
	    return list;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONPart1")
	@ResponseBody
	public List<Part1> JSONPart1() {
		List<Part1> list=new ArrayList<Part1>();
		list=sv.findAllPart1();
	    return list;
	}
	//@CrossOrigin(origins = "http://localhost:3000")
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
	//@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/SaveMyTopic")
	@ResponseBody
	public void saveMyTopic(@RequestBody JSONObject MyTopicObj) {
		JSONObject json = new JSONObject(MyTopicObj);
		String subject = json.get("subject").toString();
        String content = json.get("content").toString();
        int idunit= Integer.parseInt(json.get("idunit").toString()) ;
        int idusers=Integer.parseInt(json.get("idusers").toString()) ;
        Mytopic mytopic=new Mytopic(subject,content,idunit,idusers);
        sv.saveMyTopic(mytopic);
	}
	//@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/DeleteMyTopic")
	@ResponseBody
	public void deleteMyTopic(int id) {
		sv.DeleteMyTopic(id);
	}
	//@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	@PostMapping("/DeleteMyVocabulary")
	public void deleteMyVocabulary(int id) {
		sv.DeleteMyTopic(id);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/SaveMyVocabulary")
	@ResponseBody
	public void saveMyVOcabulary(@RequestBody JSONObject MyVocaObj)
	{
		JSONObject json = new JSONObject(MyVocaObj);
		String image = json.get("image").toString();
        String voca = json.get("voca").toString();
        String spelling= json.get("spelling").toString();
        int idtypeword=Integer.parseInt(json.get("idtypeword").toString()) ;
        String meaning= json.get("meaning").toString();
        String example1= json.get("example1").toString();
        String example2= json.get("example2").toString();
        int idunit= Integer.parseInt(json.get("idunit").toString()) ;
        int idpart1= Integer.parseInt(json.get("idpart1").toString()) ;
        String contentsoundsame=json.get("contentsoundsame").toString();
        int idusers= Integer.parseInt(json.get("idusers").toString()) ;
        Myvocabulary myvocabulary=new Myvocabulary(image,voca,spelling,idtypeword,
        		meaning,example1,example2,idunit,idpart1,contentsoundsame,idusers);
        sv.saveMyVocabulary(myvocabulary);
	}
	    	    
}