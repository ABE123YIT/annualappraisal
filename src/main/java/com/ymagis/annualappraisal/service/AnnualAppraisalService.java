package com.ymagis.annualappraisal.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.AnnualAppraisal;
import com.ymagis.annualappraisal.model.AnnualSession;
import com.ymagis.annualappraisal.model.beans.AppraisalBean;
import com.ymagis.annualappraisal.repository.AnnualAppraisalRepository;
import com.ymagis.annualappraisal.repository.AnnualSessionRepository;

@Service(value = "annualAppraisalService")
public class AnnualAppraisalService {

	private static Logger logger = Logger.getLogger(AnnualAppraisalService.class.getName());

	@Autowired
	private AnnualAppraisalRepository repository;

	@Autowired
	private AnnualSessionRepository sessionRepository;

	public List<AnnualAppraisal> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public AnnualAppraisal save(AnnualAppraisal annualAppraisal) {
		try {
			repository.save(annualAppraisal);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return annualAppraisal;
	}

	public AnnualAppraisal get(Long id) {
		try {
			Optional<AnnualAppraisal> item = repository.findById(id);
			if (item.isPresent()) {
				return item.get();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public List<AppraisalBean> getAppraisalsHistory(Long employeeId, String date) {
		List<AppraisalBean> results = new ArrayList<>();
		Map<Long, AnnualAppraisal> map = new HashMap<>();
		try {
			List<AnnualSession> sessions = sessionRepository
					.findByEndDateAfter(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			if (null != sessions && !sessions.isEmpty()) {
				List<AnnualAppraisal> list = repository.namedFindAllAnnualAppraisalsByEmployee(employeeId);
				if (null != list && !list.isEmpty()) {
					for (AnnualAppraisal elt : list) {
						map.put(elt.getAnnualSession().getId(), elt);
					}
				}
				for (AnnualSession obj : sessions) {
					AppraisalBean elt = new AppraisalBean();
					elt.setAnnualSessionId(obj.getId());
					elt.setId(null != map.get(obj.getId()) ? map.get(obj.getId()).getId() : null);
					elt.setSessionLabel(obj.getLabel());
					elt.setSessionEndDate(obj.getEndDate());
					elt.setStatus(null != map.get(obj.getId()) ? map.get(obj.getId()).getStatus() : null);
					elt.setMode((elt.getId() != null) ? "show" : "create");
					elt.setEmployeeId(employeeId);
					results.add(elt);
				}
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return results;
	}
	
	public List<AppraisalBean> getEmployeeAppraisals(Long employeeId) {
		List<AppraisalBean> results = new ArrayList<>();
		try {

			List<AnnualAppraisal> list = repository.namedFindAllAnnualAppraisalsByEmployee(employeeId);
			if (null != list && !list.isEmpty()) {
				for (AnnualAppraisal elt : list) {
					AppraisalBean bean = new AppraisalBean();
					bean.setAnnualSessionId(elt.getAnnualSession().getId());
					bean.setId(elt.getId());
					bean.setSessionLabel(elt.getAnnualSession().getLabel());
					bean.setSessionEndDate(elt.getAnnualSession().getEndDate());
					bean.setStatus(elt.getStatus());
					bean.setEmployeeId(employeeId);
					results.add(bean);
				}
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return results;
	}

	public AnnualAppraisal getByEmployeeAndSession(Long employeeId, Long sessionId) {
		try {
			return repository.namedFindAllAnnualAppraisalsByEmployeeAndAnnualSession(employeeId, sessionId);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

}
