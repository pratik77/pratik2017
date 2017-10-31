package com.cg.mp.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class SongMasterDTO 
{

	private int songId;
	private String songName;
	private Timestamp songDuration;
	private int createdBy;
	private Date createdOn;
	private int updatedBy;
	private Date updatedOn;
	private int songDelFlag;
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public Timestamp getSongDuration() {
		return songDuration;
	}
	public void setSongDuration(Timestamp songDuration) {
		this.songDuration = songDuration;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public int getSongDelFlag() {
		return songDelFlag;
	}
	public void setSongDelFlag(int songDelFlag) {
		this.songDelFlag = songDelFlag;
	}
	
}
