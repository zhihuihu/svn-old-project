package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:GlobalTable
 * Function:   全局表
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:44:25 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class GlobalTable implements Serializable {

	private static final long serialVersionUID = 4737984627431663174L;

	//全局表CUID
	private int globalTableCuid;

	//全局表所创建ID表名称
    private String globalTableTableName;

    //全局表提示
    private String globalTableNotes;

    //全局表创建时间
    private String globalTableCreateTime;

	public int getGlobalTableCuid() {
		return globalTableCuid;
	}

	public void setGlobalTableCuid(int globalTableCuid) {
		this.globalTableCuid = globalTableCuid;
	}

	public String getGlobalTableTableName() {
		return globalTableTableName;
	}

	public void setGlobalTableTableName(String globalTableTableName) {
		this.globalTableTableName = globalTableTableName;
	}

	public String getGlobalTableNotes() {
		return globalTableNotes;
	}

	public void setGlobalTableNotes(String globalTableNotes) {
		this.globalTableNotes = globalTableNotes;
	}

	public String getGlobalTableCreateTime() {
		return globalTableCreateTime;
	}

	public void setGlobalTableCreateTime(String globalTableCreateTime) {
		this.globalTableCreateTime = globalTableCreateTime;
	}
    
    
}
