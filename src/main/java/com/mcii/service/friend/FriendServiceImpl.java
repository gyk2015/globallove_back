package com.mcii.service.friend;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.Email;
import com.mcii.entity.Friend;
import com.mcii.repository.friend.FriendDao;
import com.mcii.tools.EqualUtil;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class FriendServiceImpl implements FriendService{
	@Autowired 
	FriendDao friendDao;
	
	@Override
	public Friend get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Friend entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Friend entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Friend entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFollow(Account account, Account baccount) {
		Friend friend = isFollow(account,baccount);
		if(friend == null) {
			friend = new Friend();
			friend.setAid(account);
			friend.setBid(baccount);
			friend.setStatus(0);
			friendDao.save(friend);
			System.out.println("不存在");
		}else {
			friend.setStatus(1);
			friendDao.update(friend);
		}
	}

	@Override
	public Friend isFollow(Account account, Account baccount) {
		String hql = "from Friend where aid=?0 and bid=?1 and status=0";
		Query<Friend> query = friendDao.queryByHql(hql);
		query.setParameter(0, baccount);
		query.setParameter(1, account);
		return query.uniqueResult();
	}

	@Override
	public Friend hasFollow(Account account, Account baccount) {
		String hql = "from Friend where (aid=?0 and bid=?1) or (aid=?2 and bid=?3)";
		Query<Friend> query = friendDao.queryByHql(hql);
		query.setParameter(0, account);
		query.setParameter(1, baccount);
		query.setParameter(2, baccount);
		query.setParameter(3, account);
		return query.uniqueResult();
	}

	@Override
	public void removeFollow(Account account, Account baccount) {
		String hql = "from Friend where (aid=?0 and bid=?1) or (aid=?2 and bid=?3)";
		Query<Friend> query = friendDao.queryByHql(hql);
		query.setParameter(0, account);
		query.setParameter(1, baccount);
		query.setParameter(2, baccount);
		query.setParameter(3, account);
		Friend friend = query.uniqueResult();
		if(EqualUtil.equals(friend.getAid(), account)) {
			if(friend.getStatus() == 1) {
				friend.setAid(baccount);
				friend.setBid(account);
				friend.setStatus(0);
			}else{
				friend.setAid(null);
				friend.setBid(null);
				friend.setStatus(0);
				System.out.println("我被吊");
			}
		}else {
			if(friend.getStatus() == 1) {
				friend.setStatus(0);
			}else {
				
			}
		}
		friendDao.update(friend);
	}

	@Override
	public PageRecord getFollow(Integer page,
			Integer pageSize,Account account) {
		String hql = "from Friend where aid=?0 or (bid=?1 and status=1))";
		Query<Friend> query = friendDao.queryByHql(hql);
		query.setParameter(0, account);
		query.setParameter(1, account);
		return Tool.pageList(page,pageSize,query);	
	}

	@Override
	public PageRecord getFan(Integer page, Integer pageSize, Account account) {
		String hql = "from Friend where (aid=?0 and status=1) or bid=?1";
		Query<Friend> query = friendDao.queryByHql(hql);
		query.setParameter(0, account);
		query.setParameter(1, account);
		return Tool.pageList(page,pageSize,query);	
	}

}
