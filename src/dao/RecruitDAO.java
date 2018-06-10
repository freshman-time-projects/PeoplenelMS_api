package dao;

import java.util.List;
import entity.Recruit;
public interface RecruitDAO {
	public boolean saveRecruit(Recruit recruit);
	public boolean deleteRecruit(Recruit recruit);
	public boolean UpdateRecruit(Recruit recruit);
	public List<Recruit> getAllRecruit();
	public List<Recruit> getPartRecruit(String data);
	public Recruit getRecruit(Recruit recruit);
}
