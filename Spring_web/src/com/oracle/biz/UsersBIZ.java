package com.oracle.biz;

import com.jdbc.util.UsersUtil;
import com.jdbc.util.jdbc_util;
import com.oracle.dao.UserDAO;
import com.oracle.domain.Users;
import com.oracle.md5.MD5_Encoding;

public class UsersBIZ {
	
	public int save(Users users){
		try {
			UserDAO usersDAO = new UserDAO();
			Users usersTemp = usersDAO.findByUserName(users.getUserName());
			if(usersTemp == null){
				usersDAO.save(users);
			}else{
				return UsersUtil.USER_USERNAME_NOT_EMPTY;
			}
			return UsersUtil.USER_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return UsersUtil.USER_ERROR;
		}finally{
			jdbc_util.closeConnection();
		}
		
	}

	/**
	 * 
	 * 登录验证的方法
	 * @param username  用户名
	 * @param userpass  用户密码
	 * @return  如果登陆成功返回用户对象，否则返回null
	 */
	public Users isLogin(String userName,String userPass){
		try {
			UserDAO usersDAO = new UserDAO();
			Users users = usersDAO.findByUserName(userName);
		    if(users!=null){
		    	MD5_Encoding md5 = new MD5_Encoding();
		    	String md5UserPass = md5.getMD5ofStr(userPass);
		    	if(md5UserPass.equals(users.getUserPass())){
		    		return users;
		    	}else{
		    		throw new Exception("密码错误！");
		    	}
		    }else{
		    	throw new Exception("用户名不存在");
		    }
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		} finally{
			jdbc_util.closeConnection();
		}
		
		
	}
}
