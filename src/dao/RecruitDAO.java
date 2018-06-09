package dao;

import java.util.List;
import entity.Recruit;
public interface RecruitDAO {
	public void saveRecruit();
	public Integer deleteRecruit();
	public Integer UpdateRecruit();
	public List<Recruit> getAllRecruit();
	public List<Recruit> getPartRecruit();
	public Recruit getRecruit();
}
