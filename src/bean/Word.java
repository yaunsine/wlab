package bean;


public class Word {
	private Word word;
	private String wtext,sentence,wtime,meaning="";
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	private int id = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Word() {
		// TODO Auto-generated constructor stub
	}
	public Word getGood() {
		return word;
	}
	public void setGood(Word word) {
		this.word = word;
	}
	public String getWtext() {
		return wtext;
	}
	public String getWtime() {
		return wtime;
	}
	public void setWtime(String wtime) {
		this.wtime = wtime;
	}
	public void setWtext(String wtext) {
		this.wtext = wtext;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
}
