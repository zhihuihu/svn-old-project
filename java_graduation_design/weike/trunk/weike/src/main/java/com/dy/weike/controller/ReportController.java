package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Report;
import com.dy.weike.service.inter.IReportService;

@Controller
@RequestMapping(value="report")
public class ReportController {

	@Resource
	private IReportService iReportService;
	
	/**
	 * 增加一条举报数据
	 * @param request
	 * @param token 服务器认证
	 * @param reportString 传入内容  举报对象的字符串
	 * @return
	 */
	@RequestMapping(value="insert")
	@ResponseBody
	public Object insert(HttpServletRequest request,String token,String reportString){
		Report report = new Report();
		report.setAskId(1);
		report.setReporterId(1);
		report.setReportReason("内容不健康");
		report.setReportTime(TimeUtils.getMySqlFormatTime());
		iReportService.insert(report);
		return report;
	}
	
	/**
	 * 通过主键删除
	 * @param request
	 * @param token
	 * @param reportString
	 * @return
	 */
	@RequestMapping(value="deleteByPrimaryKey")
	@ResponseBody
	public Object deleteByPrimaryKey(HttpServletRequest request,String token,String reportString){
		System.out.println("reportString-----------:"+reportString);
		Report report = new Report();
		report.setReportId(1);
		iReportService.deleteByPrimaryKey(report);
		return report;
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,String token,String reportString){
		Report report = new Report();
		report.setReportId(4);
		report = iReportService.selectByPrimaryKey(report);
		return report;
	}
	
	@RequestMapping(value="updateByPrimaryKeySelective")
	@ResponseBody
	public Object updateByPrimaryKeySelective(HttpServletRequest request,String token,String reportString){
		Report report = new Report();
		report.setAskId(3);
		report.setReporterId(2);
		report.setReportId(3);
		report.setReportReason("内容不健康,就更新你");
		report.setReportTime(TimeUtils.getMySqlFormatTime());
		iReportService.updateByPrimaryKeySelective(report);
		return report;
	}
}
