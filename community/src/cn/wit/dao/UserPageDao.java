package cn.wit.dao;

import java.util.List;

import cn.wit.common.PageInfo;
import cn.wit.pojo.User;

public interface UserPageDao {
	// 社区所有用户信息分页查询
	List<User> selectUserPageByCommunityId(int communityid, PageInfo pi);
	int allUsercount(int communityid);

	// 社区所有居家隔离用户分页查询
	List<User> selectHomeQuarantineUserPageByCommunityId(int communityid, PageInfo pi);
	int homeQuarantineUsercount(int communityid);

	// 社区所有集中隔离用户分页查询
	List<User> selectConcentrationQuarantineUserPageByCommunityId(int communityid, PageInfo pi);
	int concentrationQuarantineUsercount(int communityid);

	// 社区所有三针疫苗未完成用户分页查询
	List<User> selectVaccineUserPageByCommunityId(int communityid, PageInfo pi);
	int vaccineUsercount(int communityid);

	// 社区所有用户疫苗信息分页查询
	List<User> selAllVaccineUserPageByCommunityId(int communityid, PageInfo pi);
	int allVaccineUsercount(int communityid);
}
