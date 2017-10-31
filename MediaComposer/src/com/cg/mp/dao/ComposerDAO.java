package com.cg.mp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.exception.SongException;
import com.cg.mp.utility.DBUtil;

public class ComposerDAO implements IComposerDAO {

	public ComposerDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String checkLogin(int userId, String password) throws SongException {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement pstStudent=null;
		String message="invalid";		
		String sql=new String("SELECT user_flag FROM User_Master where user_id="+userId+" AND user_password='"+password+"'");
		
		try
		{
		connection=DBUtil.createConnection();
		Statement stmt = connection.createStatement ();
		ResultSet rset = stmt.executeQuery (sql);
		rset.next();
		int checkFlag=rset.getInt(1);
		if(checkFlag==1)
			message="admin";
		else if(checkFlag==2)
			message="user";
		else message="invalid";
		}catch(SQLException se)
		{
			throw new SongException("Problem in checking login.");
		}finally
		{
			try
			{
				DBUtil.closeConnection();
			}catch(SQLException se)
			{
				throw new SongException("Problems in closing connection.",se);
			}
		}
		
		
		
		return message;
	}

	@Override
	public void addComposer(ComposerMasterDTO composerMasterDTO, int userId) throws SongException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pst=null;		
		String sql=new String("INSERT INTO composer_master VALUES (composer_master_seq.nextval,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?)");
		
		try
		{
		connection=DBUtil.createConnection();
		pst = connection.prepareStatement (sql);
		pst.setString(1,composerMasterDTO.getComposerName());
		pst.setDate(2,composerMasterDTO.getComposerBornDate());
		pst.setDate(3,composerMasterDTO.getComposerDiedDate());
		pst.setString(4,composerMasterDTO.getComposerCaeipiNumber());
		pst.setString(5,composerMasterDTO.getComposerMusicSocId());
		pst.setInt(6,userId);
		pst.setInt(7,userId);
		pst.setInt(8,composerMasterDTO.getComposerDelFlag());
		int status=0;
		status=pst.executeUpdate();
		}catch(SQLException se)
		{
			throw new SongException(se.getMessage()+"Problem in inserting composer details.",se);
		}finally
		{
			try
			{
				DBUtil.closeConnection();
			}catch(SQLException se)
			{
				throw new SongException("Problems in closing connection.",se);
			}
		}
		
		
		
	
	}

	@Override
	public ComposerMasterDTO getComposerById(int composerId) throws SongException {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement stmt=null;		
		String sql=new String("SELECT * FROM composer_master where composer_id="+composerId);
		ComposerMasterDTO composerMasterDTO=new ComposerMasterDTO();
		
		try
		{
		connection=DBUtil.createConnection();
		stmt = connection.createStatement();
		ResultSet rset = stmt.executeQuery (sql);
		while(rset.next())
		{
			
			composerMasterDTO.setComposerId(composerId);
			composerMasterDTO.setComposerName(rset.getString(2));
			composerMasterDTO.setComposerBornDate(rset.getDate(3));
			composerMasterDTO.setComposerDiedDate(rset.getDate(4));
			composerMasterDTO.setComposerCaeipiNumber(rset.getString(5));
			composerMasterDTO.setComposerMusicSocId(rset.getString(6));
			composerMasterDTO.setCreatedBy(rset.getInt(7));
			composerMasterDTO.setCreatedOn(rset.getDate(8));
			composerMasterDTO.setUpdatedBy(rset.getInt(9));
			composerMasterDTO.setUpdatedOn(rset.getDate(10));
			composerMasterDTO.setComposerDelFlag(rset.getInt(11));
		}
		
		}catch(SQLException se)
		{
			throw new SongException(se.getMessage()+"Problem in checking login.");
		}finally
		{
			try
			{
				DBUtil.closeConnection();
			}catch(SQLException se)
			{
				throw new SongException("Problems in closing connection.",se);
			}
		}
		

		return composerMasterDTO;
		
	}

	@Override
	public void editComposerDetails(ComposerMasterDTO composerMasterDTOEdit,int choice6,int userId) throws SongException {
		// TODO Auto-generated method stub
		switch(choice6)
		{
		case 1:
			Connection connection=null;
			Statement stmt=null;
			Statement stmt1=null;
			String date=new String("SELECT to_char(to_date('"+composerMasterDTOEdit.getComposerDiedDate()+"','yyyy-mm-dd'),'dd-mon-yyyy') FROM DUAL");
			
			try
			{
			connection=DBUtil.createConnection();
			stmt = connection.createStatement();
			stmt1 = connection.createStatement();
			ResultSet rset = stmt.executeQuery (date);
			rset.next();
			
			date=rset.getString(1);
			String sql=new String("UPDATE composer_master SET composer_dieddate='"+date
			+"',updated_on=sysdate,updated_by="+userId +" WHERE composer_id="+composerMasterDTOEdit.getComposerId());
			int check=stmt1.executeUpdate(sql);
			
			}catch(SQLException se)
			{
				throw new SongException(se.getMessage()+" and Problem in updation.");
			}finally
			{
				try
				{
					DBUtil.closeConnection();
				}catch(SQLException se)
				{
					throw new SongException("Problems in closing connection.",se);
				}
			}
			break;
		}
		
	}

}
