package service;

import java.util.List;

import entity.Recruit;
public interface RecruitService {
	public Integer saveRecruit(Recruit recruit);
	public Integer deleteRecruit(Recruit recruit);
	public Integer updateRecruit(Recruit recruit);
	public List<Recruit> getAllRecruit();
	public List<Recruit> getPartRecruit();
	public Recruit getRecruit();
}
