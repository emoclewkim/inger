package com.ssafy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.AdminRegisterUpdateReq;
import com.ssafy.db.entity.CommonCode;
import com.ssafy.db.entity.DetailsCode;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.CommonCodeRepository;
import com.ssafy.db.repository.DetailsCodeRepository;
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
	public Optional<List<DetailsCode>> getDetailsCodeById(Long id) {
		CommonCode commonCode = new CommonCode();
		commonCode.setId(id);
		Optional<List<DetailsCode>> list = detailsCodeRepository.findByCommonCode(commonCode);
		return list;
	}

	@Override
	public DetailsCode createDetailsCode(Long id, String name, Long type) {
		if (detailsCodeRepository.findById(id).isPresent()) {
			return null;
		}
		DetailsCode detailsCode = new DetailsCode();
		CommonCode commonCode = new CommonCode();
		commonCode.setId(type);
		detailsCode.setId(id);
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

}
