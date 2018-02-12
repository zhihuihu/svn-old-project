package com.vieagr.distribution.response;

import java.io.InputStream;

import com.vieagr.distribution.response.base.BaseReponse;

/**
 * 送货车辆返回对象
 * @author master
 *
 */
public class SysVehiclesResponse extends BaseReponse {

	private static final long serialVersionUID = -1737958684998116626L;
	/**
	 * 车牌号
	 */
	private String vehiclesPlateNumber;
	/**
	 * 导出的excel输出流
	 */
	private InputStream bidExcelInPutStream;
	
	public InputStream getBidExcelInPutStream() {
		return bidExcelInPutStream;
	}

	public void setBidExcelInPutStream(InputStream bidExcelInPutStream) {
		this.bidExcelInPutStream = bidExcelInPutStream;
	}

	public String getVehiclesPlateNumber() {
		return vehiclesPlateNumber;
	}

	public void setVehiclesPlateNumber(String vehiclesPlateNumber) {
		this.vehiclesPlateNumber = vehiclesPlateNumber;
	}
	
}
