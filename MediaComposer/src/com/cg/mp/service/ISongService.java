package com.cg.mp.service;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.exception.SongException;

public interface ISongService {
	String checkLogin(int userId, String password)throws SongException;

	void addComposer(ComposerMasterDTO composerMasterDTO, int userId)throws SongException;

	ComposerMasterDTO getComposerById(int composerId) throws SongException;

	void editComposerDetails(ComposerMasterDTO composerMasterDTOEdit, int choice6, int userId)throws SongException;

}
