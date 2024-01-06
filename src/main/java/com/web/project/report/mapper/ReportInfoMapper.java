package com.web.project.report.mapper;

import java.util.List;

import com.web.project.report.vo.ReportUserInfoVO;

public interface ReportInfoMapper {
	List<ReportUserInfoVO> getReportInfo();
	int insertReportInfo(ReportUserInfoVO report);
	int updateReportInfoStatus(ReportUserInfoVO report);
}
