package StudyEnglish.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="contentstory")
public class Contentstory implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcontentstory;
	private String name;
	private String content;
	private int idpart1;
	@Override
	public String toString() {
		return "Contentstory [idcontentstory=" + idcontentstory + ", name=" + name + ", content=" + content
				+ ", idpart1=" + idpart1 + "]";
	}
	public Contentstory() {
		
	}
	public Contentstory(String name, String content, int idpart1) {
		super();
		this.name = name;
		this.content = content;
		this.idpart1 = idpart1;
	}
	public int getIdcontentstory() {
		return idcontentstory;
	}
	public void setIdcontentstory(int idcontentstory) {
		this.idcontentstory = idcontentstory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdpart1() {
		return idpart1;
	}
	public void setIdpart1(int idpart1) {
		this.idpart1 = idpart1;
	}
}
