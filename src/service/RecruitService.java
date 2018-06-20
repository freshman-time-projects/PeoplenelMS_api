package service;

import java.util.List;

import entity.Recruit;
import entity.User;

public interface RecruitService {
	public boolean saveRecruit(Recruit recruit);

	public boolean deleteRecruit(Recruit recruit);

	public boolean updateRecruit(String[] ids, String userStatus);

	public List<Recruit> getAllRecruit(String userStatus);

	public List<Recruit> getPartRecruit();

	public Recruit getRecruit();
	
	public boolean access(User user);
}
