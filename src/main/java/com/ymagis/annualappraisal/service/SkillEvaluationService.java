package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.Skill;
import com.ymagis.annualappraisal.model.SkillEvaluation;
import com.ymagis.annualappraisal.model.SkillLevel;
import com.ymagis.annualappraisal.model.beans.SkillBean;
import com.ymagis.annualappraisal.model.beans.SkillLevelBean;
import com.ymagis.annualappraisal.repository.SkillEvaluationRepository;
import com.ymagis.annualappraisal.repository.SkillRepository;

@Service(value = "skillEvaluationService")
public class SkillEvaluationService {

	private static Logger logger = Logger.getLogger(SkillEvaluationService.class.getName());

	@Autowired
	private SkillEvaluationRepository repository;

	@Autowired
	private SkillRepository skillRepository;

	public List<SkillEvaluation> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public SkillEvaluation save(SkillEvaluation skillEvaluation) {
		try {
			repository.save(skillEvaluation);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return skillEvaluation;
	}

	public List<SkillEvaluation> saveAll(List<SkillEvaluation> skillEvaluations, Long appraisalId, String type) {
		try {
			List<SkillEvaluation> lastEvaluations = repository.namedFindAllSkillEvaluationsByAnnualAppraisalAndType(
					appraisalId, type);
			if(null != lastEvaluations && !lastEvaluations.isEmpty()) {
				repository.deleteAll(lastEvaluations);
			}
			if(null != skillEvaluations && !skillEvaluations.isEmpty()) {
				repository.saveAll(skillEvaluations);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return skillEvaluations;
	}

	public SkillEvaluation get(Long id) {
		try {
			Optional<SkillEvaluation> item = repository.findById(id);
			if (item.isPresent()) {
				return item.get();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	public List<SkillBean> getByAppraisalAndType(Long id, String type) {
		List<SkillBean> list = new ArrayList<>();
		try {
			List<Skill> skills = skillRepository.findByType(type);
			if (null != skills && !skills.isEmpty()) {
				List<SkillEvaluation> evaluations = repository.namedFindAllSkillEvaluationsByAnnualAppraisalAndType(id, type);
				Map<Long, Long> mapEval = getMap(evaluations);
				for (Skill skill : skills) {
					SkillBean bean = new SkillBean(skill.getId(), skill.getCode(), skill.getLabel(), skill.getType(),
							null);
					List<SkillLevel> levels = skill.getSkillLevels();
					if (null != levels && !levels.isEmpty()) {
						List<SkillLevelBean> levelBeans = new ArrayList<>();
						for (SkillLevel level : levels) {
							SkillLevelBean levelBean = new SkillLevelBean(level.getId(), level.getRanking(),
									level.getMeaning(), false, null);
							if (mapEval.containsKey(skill.getId())
									&& level.getId().equals(mapEval.get(skill.getId()))) {
								levelBean.setChecked(true);
							}
							levelBeans.add(levelBean);
						}
						bean.setSkillLevelBeans(levelBeans);
					}
					list.add(bean);
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return list;
	}

	public void delete(Long id) {
		try {
			Optional<SkillEvaluation> item = repository.findById(id);
			if (item.isPresent()) {
				repository.deleteById(id);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	private Map<Long, Long> getMap(List<SkillEvaluation> evaluations) {
		Map<Long, Long> map = new HashMap<>();
		if (null != evaluations && !evaluations.isEmpty()) {
			for (SkillEvaluation elt : evaluations) {
				map.put(elt.getSkillLevel().getSkill().getId(), elt.getSkillLevel().getId());
			}
		}
		return map;
	}
}
