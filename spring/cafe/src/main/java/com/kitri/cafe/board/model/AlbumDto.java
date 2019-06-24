package com.kitri.cafe.board.model;

public class AlbumDto extends BoardDto{
	private int aseq;
	private String saveolder;
	private String originalpicture;
	private String savepicture;
	private int picturemode;
	public int getAseq() {
		return aseq;
	}
	public void setAseq(int aseq) {
		this.aseq = aseq;
	}
	public String getSaveolder() {
		return saveolder;
	}
	public void setSaveolder(String saveolder) {
		this.saveolder = saveolder;
	}
	public String getOriginalpicture() {
		return originalpicture;
	}
	public void setOriginalpicture(String originalpicture) {
		this.originalpicture = originalpicture;
	}
	public String getSavepicture() {
		return savepicture;
	}
	public void setSavepicture(String savepicture) {
		this.savepicture = savepicture;
	}
	public int getPicturemode() {
		return picturemode;
	}
	public void setPicturemode(int picturemode) {
		this.picturemode = picturemode;
	}
	
}
