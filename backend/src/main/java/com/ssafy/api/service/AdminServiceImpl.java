package com.ssafy.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.AdminRegisterUpdateReq;
import com.ssafy.api.request.NotifyRegisterReq;
import com.ssafy.api.response.DetailsCodeRes;
import com.ssafy.db.entity.CommonCode;
import com.ssafy.db.entity.DetailsCode;
import com.ssafy.db.entity.Notify;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.CommonCodeRepository;
import com.ssafy.db.repository.DetailsCodeRepository;
import com.ssafy.db.repository.NotifyRepository;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

import lombok.RequiredArgsConstructor;

/**
 * 관리자 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("adminService")
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	CommonCodeRepository commonCodeRepository;

	@Autowired
	DetailsCodeRepository detailsCodeRepository;

	@Autowired
	NotifyRepository notifyRepository;

	@Autowired
	UserRepositorySupport userRepositorySupport;

	@Override
	@Transactional
	public User updateUserByKakaoIdnum(AdminRegisterUpdateReq adminRegisterUpdateReq) {
		User user = userRepository.findById(adminRegisterUpdateReq.getId()).get();

		if (user.getId() == null) {
			return null;
		}
		user.setUsercode(adminRegisterUpdateReq.getUsercode());
		return user;
	}

	@Override
	public Optional<List<CommonCode>> getCommonCodeList() {
		List<CommonCode> list = commonCodeRepository.findAll();
		return Optional.ofNullable(list);
	}

	@Override
	public CommonCode createCommonCode(String kind) {
		CommonCode commonCode = new CommonCode();
		commonCode.setKind(kind);
		return commonCodeRepository.save(commonCode);
	}

	@Override
	@Transactional
	public CommonCode updateCommonCodeById(Long id, String kind) {
		try {
			CommonCode commonCode = commonCodeRepository.findById(id).get();
			commonCode.setKind(kind);
			return commonCode;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteCommonCodeById(Long id) {
		commonCodeRepository.deleteById(id);
	}

	@Override
	public List<DetailsCodeRes> getDetailsCodeById(Long id) {
		CommonCode commonCode = new CommonCode();
		commonCode.setId(id);
		Optional<List<DetailsCode>> details = detailsCodeRepository.findByCommonCode(commonCode);
		List<DetailsCodeRes> list = new ArrayList<DetailsCodeRes>();
		for (DetailsCode detailsCode : details.get()) {
			DetailsCodeRes res = new DetailsCodeRes();
			res.setId(detailsCode.getId());
			res.setName(detailsCode.getName());
			res.setType(detailsCode.getCommonCode().getId());
			list.add(res);
		}
		return list;
	}

	@Override
	public DetailsCode createDetailsCode(String name, Long type) {
		DetailsCode detailsCode = new DetailsCode();
		CommonCode commonCode = new CommonCode();
		commonCode.setId(type);
		detailsCode.setName(name);
		detailsCode.setCommonCode(commonCode);
		return detailsCodeRepository.save(detailsCode);
	}

	@Override
	@Transactional
	public DetailsCode updateDetailsCodeById(Long id, String name) {
		try {
			DetailsCode detailsCode = detailsCodeRepository.findById(id).get();
			detailsCode.setName(name);
			return detailsCode;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteDetailsCodeById(Long id) {
		detailsCodeRepository.deleteById(id);
	}

	@Override
	public Notify createNotify(NotifyRegisterReq notifyRegisterReq) {
		Optional<User> user = userRepository.findById(notifyRegisterReq.getUserId());
		if (user.isPresent()) {
			Notify notify = new Notify();
			notify.setUser(user.get());
			notify.setNotifyDate(notifyRegisterReq.getNotifyDate());
			notify.setReason(notifyRegisterReq.getReason());
			notify.setHandling(notifyRegisterReq.getHandling());
			return notifyRepository.save(notify);
		}
		return null;
	}

}
