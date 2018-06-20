package dao;

import java.util.List;

import entity.Recruit;
import entity.User;

public interface RecruitDAO {
	public boolean saveRecruit(Recruit recruit);

	public boolean deleteRecruit(Recruit recruit);

	public boolean UpdateRecruit(String[] ids, String userStatus);

	public List<Recruit> getAllRecruit(String userStatus);

	public List<Recruit> getPartRecruit(String data);

	public Recruit getRecruit(Recruit recruit);

	public Recruit access(User user);

}
