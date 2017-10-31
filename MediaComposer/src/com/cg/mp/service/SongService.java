package com.cg.mp.service;

import com.cg.mp.dao.ComposerDAO;
import com.cg.mp.dao.IComposerDAO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.exception.SongException;

public class SongService implements ISongService {
	IComposerDAO composerDAO=null	;
	public SongService() {
		// TODO Auto-generated constructor stub
		composerDAO=new ComposerDAO();
	}

	@Override
	public String checkLogin(int userId, String password) throws SongException {
		// TODO Auto-generated method stub
		return composerDAO.checkLogin(userId,password);
	}

	@Override
	public void addComposer(ComposerMasterDTO composerMasterDTO, int userId) throws SongException {
		// TODO Auto-generated method stub
		composerDAO.addComposer(composerMasterDTO,userId);
	}

	@Override
	public ComposerMasterDTO getComposerById(int composerId) throws SongException {
		// TODO Auto-generated method stub
		return composerDAO.getComposerById(composerId);
	}

	@Override
	public void editComposerDetails(ComposerMasterDTO composerMasterDTOEdit,int choice6,int userId) throws SongException {
		// TODO Auto-generated method stub
		composerDAO.editComposerDetails(composerMasterDTOEdit,choice6,userId);
	}

}
