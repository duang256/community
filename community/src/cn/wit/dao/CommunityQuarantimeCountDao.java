package cn.wit.dao;

import java.util.List;

import cn.wit.pojo.CommunityInfo;

public interface CommunityQuarantimeCountDao {
	int[] selectCountOfQuarantime(CommunityInfo communityInfo);
}
