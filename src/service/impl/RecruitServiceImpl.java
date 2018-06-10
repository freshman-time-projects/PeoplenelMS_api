package service.impl;
import java.util.List;

import service.RecruitService;
import dao.RecruitDAO;
import entity.Recruit;
public class RecruitServiceImpl implements RecruitService {
	private RecruitDAO recruitDAO;
	public RecruitDAO getRecruitDAO() {
		return recruitDAO;
	}

	public void setRecruitDAO(RecruitDAO recruitDAO) {
		this.recruitDAO = recruitDAO;
	}

	@Override
	public boolean saveRecruit(Recruit recruit) {
		if(recruitDAO.saveRecruit(recruit))
		    return true;
		return false;
	}
	@Override
	public boolean deleteRecruit(Recruit recruit) {
		if(recruitDAO.deleteRecruit(recruit))
			return true;
		return false;
	}

	@Override
	public boolean updateRecruit(Recruit recruit) {
		if(recruitDAO.UpdateRecruit(recruit))
			return true;
		return false;
	}

	public List<Recruit> getAllRecruit() {
		
		return null;
	}

	@Override
	public List<Recruit> getPartRecruit() {

		return null;
	}

	@Override
	public Recruit getRecruit() {

		
		return null;
	}
}
