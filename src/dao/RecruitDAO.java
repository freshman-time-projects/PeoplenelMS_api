package dao;

import java.util.List;
import entity.Recruit;
public interface RecruitDAO {
	public void saveRecruit(Recruit recruit);
	public Integer deleteRecruit(Recruit recruit);
	public Integer UpdateRecruit(Recruit recruit);
	public List<Recruit> getAllRecruit();
	public List<Recruit> getPartRecruit();
	public Recruit getRecruit();
}
