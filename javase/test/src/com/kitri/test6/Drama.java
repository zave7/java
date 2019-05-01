package com.kitri.test6;

public class Drama extends TVProgram{
	private String director;
	private String actor;
	private String actress;
	
	public Drama(String director, String actor, String actress) {
		this("", "", director, actor, actress);
	}
	public Drama(String title, String broadcast, String director, String actor, String actress) {
		super(title, broadcast);
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}
	protected String getDirector() {
		return director;
	}
	protected void setDirector(String director) {
		this.director = director;
	}
	protected String getActor() {
		return actor;
	}
	protected void setActor(String actor) {
		this.actor = actor;
	}
	protected String getActress() {
		return actress;
	}
	protected void setActress(String actress) {
		this.actress = actress;
	}
	@Override
	public String toString() {
		return super.toString() + "\n\t- 감독 : " + director +ifActorExist(actor) + ifActressExist(actress);
	}
	private String ifActorExist(String actor) {
		return actor.isEmpty() ? "" : "\n\t- 남자배우 : " + actor;
	}
	private String ifActressExist(String actress) {
		return actress.isEmpty() ? "" : "\n\t- 여자배우 : " + actress;
	}
	
}
