package com.cg.mp.dto;

import java.sql.Date;

public class ArtistMasterDTO {
	private int artistId;
	private String artistName;
	private char artistType;
	private Date artistBornDate;
	private Date artistDiedDate;
	private int createdBy;
	private Date createdOn;
	private int updatedBy;
	private Date updatedOn;
	private int artistDelFlag;
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public char getArtistType() {
		return artistType;
	}
	public void setArtistType(char artistType) {
		this.artistType = artistType;
	}
	public Date getArtistBornDate() {
		return artistBornDate;
	}
	public void setArtistBornDate(Date artistBornDate) {
		this.artistBornDate = artistBornDate;
	}
	public Date getArtistDiedDate() {
		return artistDiedDate;
	}
	public void setArtistDiedDate(Date artistDiedDate) {
		this.artistDiedDate = artistDiedDate;
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
	public int getArtistDelFlag() {
		return artistDelFlag;
	}
	public void setArtistDelFlag(int artistDelFlag) {
		this.artistDelFlag = artistDelFlag;
	}

}
