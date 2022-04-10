package com.jiawa.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.User;
import com.jiawa.wiki.domain.UserExample;
import com.jiawa.wiki.exception.BusinessException;
import com.jiawa.wiki.exception.BusinessExceptionCode;
import com.jiawa.wiki.mapper.UserMapper;
import com.jiawa.wiki.req.UserQueryReq;
import com.jiawa.wiki.req.UserSaveReq;
import com.jiawa.wiki.resp.UserQueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.util.CopyUtil;
import com.jiawa.wiki.util.SnowFlake;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: jie
 * @Date: 2022/1/3 14:02
 * @Description:
 */

@Service
public class UserService {


    @Resource
    private UserMapper userMapper;
    @Resource
    private SnowFlake snowFlake;


    public PageResp<UserQueryResp> list(UserQueryReq req){

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getLoginName())) {
            criteria.andNameLike("%" + req.getLoginName() + "%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<User> userList = userMapper.selectByExample(userExample);

//        List<UserResp> respList = new ArrayList<>();
//        for (User user : userList) {
//            UserResp userResp = new UserResp();
//            BeanUtils.copyProperties(user,userResp);
        /*
        对象复制
         */
//            UserResp userResp = CopyUtil.copy(user, UserResp.class);
//            respList.add(userResp);
//        }

        /*
        列表复制
         */
        List<UserQueryResp> list = CopyUtil.copyList(userList, UserQueryResp.class);
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        PageResp<UserQueryResp> pageResp=new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }
    /*
    保存
     */
    public void save(UserSaveReq req){
        User user=CopyUtil.copy(req,User.class);
        if(ObjectUtils.isEmpty(req.getId())){
//            if (ObjectUtils.isEmpty(selectByLoginName(req.getLoginName())));
            User userDb=selectByLoginName(req.getLoginName());
            if(ObjectUtils.isEmpty(userDb)){
                //新增
                user.setId(snowFlake.nextId());
                userMapper.insert(user);
            } else {
                //用户名已存在
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }

        }else{
            //更新
            user.setLoginName(null);
            user.setPassword(null);
            userMapper.updateByPrimaryKeySelective(user);
        }
    }
    public void delete(Long id){
        userMapper.deleteByPrimaryKey(id);
    }

    public User selectByLoginName(String loginName){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        List<User> userList = userMapper.selectByExample(userExample);
        if(CollectionUtils.isEmpty(userList)){
            return null;
        } else {
            return userList.get(0);
        }
    }
}
