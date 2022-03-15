package cn.wit.dao;

import java.util.List;

import cn.wit.common.PageInfo;
import cn.wit.pojo.User;

public interface UserPageDao {
	// ���������û���Ϣ��ҳ��ѯ
	List<User> selectUserPageByCommunityId(int communityid, PageInfo pi);
	int allUsercount(int communityid);

	// �������оӼҸ����û���ҳ��ѯ
	List<User> selectHomeQuarantineUserPageByCommunityId(int communityid, PageInfo pi);
	int homeQuarantineUsercount(int communityid);

	// �������м��и����û���ҳ��ѯ
	List<User> selectConcentrationQuarantineUserPageByCommunityId(int communityid, PageInfo pi);
	int concentrationQuarantineUsercount(int communityid);

	// ����������������δ����û���ҳ��ѯ
	List<User> selectVaccineUserPageByCommunityId(int communityid, PageInfo pi);
	int vaccineUsercount(int communityid);

	// ���������û�������Ϣ��ҳ��ѯ
	List<User> selAllVaccineUserPageByCommunityId(int communityid, PageInfo pi);
	int allVaccineUsercount(int communityid);
}
