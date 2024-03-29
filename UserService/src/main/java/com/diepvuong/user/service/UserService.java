package com.diepvuong.user.service;

import com.diepvuong.user.VO.Department;
import com.diepvuong.user.VO.ResponseTemplateVO;
import com.diepvuong.user.entity.User;
import com.diepvuong.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId){
        ResponseTemplateVO vo = new ResponseTemplateVO();

        User user = userRepository.findById(userId).get();
        vo.setUser(user);

        Department department = restTemplate
                .getForObject("http://localhost:9001/api/v1/department/" + user.getDepartmentId(), Department.class);
        vo.setDepartment(department);

        return vo;

    }

}
