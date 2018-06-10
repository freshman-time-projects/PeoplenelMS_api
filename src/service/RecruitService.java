package service;

import java.util.List;

import entity.Recruit;
public interface RecruitService {
	public boolean saveRecruit(Recruit recruit);
	public boolean deleteRecruit(Recruit recruit);
	public boolean updateRecruit(Recruit recruit);
	public List<Recruit> getAllRecruit();
	public List<Recruit> getPartRecruit();
	public Recruit getRecruit();
}
