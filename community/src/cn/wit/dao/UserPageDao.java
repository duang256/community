package cn.wit.dao;

import java.util.List;

import cn.wit.common.PageInfo;
import cn.wit.pojo.User;

public interface UserPageDao {
	//���������û���Ϣ��ҳ��ѯ
	List<User> selectUserPageByCommunityId(int communityid,PageInfo pi);
	int allUsercount(int communityid);
	
	//�������и����û���ҳ��ѯ
	List<User> selectQuarantineUserPageByCommunityId(int communityid,PageInfo pi);
	int quarantineUsercount(int communityid);
	
	//����������������δ����û���ҳ��ѯ
	List<User> selectVaccineUserPageByCommunityId(int communityid,PageInfo pi);
	int vaccineUsercount(int communityid);
}
