package com.kitri.cafe.board.model;

public class AlbumDto extends BoardDto{
	private int aseq;
	private String saveFolder;
	private String originPicture;
	private String savePicture;
	private int pictureMode;
	public int getAseq() {
		return aseq;
	}
	public void setAseq(int aseq) {
		this.aseq = aseq;
	}
	public String getSaveFolder() {
		return saveFolder;
	}
	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}
	public String getOriginPicture() {
		return originPicture;
	}
	public void setOriginPicture(String originPicture) {
		this.originPicture = originPicture;
	}
	public String getSavePicture() {
		return savePicture;
	}
	public void setSavePicture(String savePicture) {
		this.savePicture = savePicture;
	}
	public int getPictureMode() {
		return pictureMode;
	}
	public void setPictureMode(int pictureMode) {
		this.pictureMode = pictureMode;
	}

}
