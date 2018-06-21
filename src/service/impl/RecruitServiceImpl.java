package service.impl;

import java.util.List;

import service.RecruitService;
import util.MailUtils;
import dao.RecruitDAO;
import dao.UserDAO;
import entity.Recruit;
import entity.User;

public class RecruitServiceImpl implements RecruitService {
	private RecruitDAO recruitDAO;
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public RecruitDAO getRecruitDAO() {
		return recruitDAO;
	}

	public void setRecruitDAO(RecruitDAO recruitDAO) {
		this.recruitDAO = recruitDAO;
	}

	@Override
	public boolean saveRecruit(Recruit recruit) {
		if (recruitDAO.saveRecruit(recruit))
			return true;
		return false;
	}

	@Override
	public boolean deleteRecruit(Recruit recruit) {
		if (recruitDAO.deleteRecruit(recruit))
			return true;
		return false;
	}

	@Override
	public boolean updateRecruit(String[] ids, String userStatus) {
		if (recruitDAO.UpdateRecruit(ids, userStatus))
			return true;
		return false;
	}

	@Override
	public List<Recruit> getAllRecruit(String userStatus) {
		return recruitDAO.getAllRecruit(userStatus);
	}

	@Override
	public List<Recruit> getPartRecruit() {

		return null;
	}

	@Override
	public Recruit getRecruit() {

		return null;
	}

	@Override
	public boolean access(User user) {
		try {
			System.out.println("userEmial" + user.getEmail() + " " + user.getCode());
			MailUtils.sendMail(user.getEmail(), user.getCode());
//			user.setState("1"); //邮箱不能用时代替
			Recruit recruit = recruitDAO.access(user);
			String ids[] = { recruit.getR_id().toString() };
			return userDAO.UpdateUser(user) && recruitDAO.UpdateRecruit(ids, "2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
