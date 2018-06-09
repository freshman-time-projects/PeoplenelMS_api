package service;

import java.util.List;
import entity.Recruit;
public interface RecruitService {
	public Integer saveRecruit();
	public Integer deleteRecruit();
	public Integer updateRecruit();
	public List<Recruit> getAllRecruit();
	public List<Recruit> getPartRecruit();
	public Recruit getRecruit();
}
