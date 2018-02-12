package com.hxkj.xhupubmed.core.utils;

import java.util.List;

import com.hxkj.xhupubmed.entity.Chat;
import com.hxkj.xhupubmed.entity.Classroom;
import com.hxkj.xhupubmed.entity.College;
import com.hxkj.xhupubmed.entity.DataSharing;
import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.entity.FollowPost;
import com.hxkj.xhupubmed.entity.Friend;
import com.hxkj.xhupubmed.entity.GlobalTable;
import com.hxkj.xhupubmed.entity.Images;
import com.hxkj.xhupubmed.entity.InformationPush;
import com.hxkj.xhupubmed.entity.IntelligentMessage;
import com.hxkj.xhupubmed.entity.KeyLog;
import com.hxkj.xhupubmed.entity.LearnPlan;
import com.hxkj.xhupubmed.entity.Major;
import com.hxkj.xhupubmed.entity.Oppointment;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.entity.Replies;
import com.hxkj.xhupubmed.entity.SchoolInformation;
import com.hxkj.xhupubmed.entity.SchoolProfile;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.impl.GlobalTableService;

/** 
 * ClassName:CuidUtils
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午3:41:50 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class CuidUtils {

	private static GlobalTableService globalTableService;
	
	static{
		globalTableService = (GlobalTableService) SpringContextUtils.getBean("globalTableService");
	}
	
	/**
	 * 
	* @Function: 
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:00:17
	* @Since JDK 1.8
	 */
	public static void setCuid(Chat b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("CHAT");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setChatCuid("CHAT"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置Chat表的CUID List
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:03:36
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Chat> bs,String notes,Chat b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("CHAT");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setChatCuid("CHAT"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function:  设置Classroom的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:05:04
	* @Since JDK 1.8
	 */
	public static void setCuid(Classroom b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("CLASSROOM");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setClassroomCuid("CLASSROOM"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置Classroom的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:05:24
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Classroom> bs,String notes,Classroom b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("CLASSROOM");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setClassroomCuid("CLASSROOM"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置college的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:19:11
	* @Since JDK 1.8
	 */
	public static void setCuid(College b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("COLLEGE");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setCollegeCuid("COLLEGE"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置college的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:19:22
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<College> bs,String notes,College b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("COLLEGE");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setCollegeCuid("COLLEGE"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置follow表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:19:44
	* @Since JDK 1.8
	 */
	public static void setCuid(Follow b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("FOLLOW");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setFollowCuid("FOLLOW"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function:  设置follow表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:20:01
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Follow> bs,String notes,Follow b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("FOLLOW");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setFollowCuid("FOLLOW"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	
	public static void setCuid(FollowPost b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("FOLLOWPOST");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
	}
	
	public static void setCuidList(List<FollowPost> bs,String notes,FollowPost b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("FOLLOWPOST");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
		}
	}
	
	/**
	 * 
	* @Function: 设置friend的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:20:30
	* @Since JDK 1.8
	 */
	public static void setCuid(Friend b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("FRIEND");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setFriendCuid("FRIEND"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	
	/**
	 * 
	* @Function: 设置friend表的CUID list
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:20:43
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Friend> bs,String notes,Friend b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("FRIEND");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setFriendCuid("FRIEND"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置Images表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:21:02
	* @Since JDK 1.8
	 */
	public static void setCuid(Images b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("IMAGES");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setImagesCuid("IMAGES"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function:  设置Images表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:21:16
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Images> bs,String notes,Images b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("IMAGES");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setImagesCuid("IMAGES"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置InformationPush表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:21:41
	* @Since JDK 1.8
	 */
	public static void setCuid(InformationPush b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("INFORMATION_PUSH");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setInformationPushCuid("INFORMATIONPUSH"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置InformationPush表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:21:56
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<InformationPush> bs,String notes,InformationPush b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("INFORMATION_PUSH");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setInformationPushCuid("INFORMATIONPUSH"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置IntelligentMessage表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:22:10
	* @Since JDK 1.8
	 */
	public static void setCuid(IntelligentMessage b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("INTELLIGENT_MESSAGE");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setIntelligentMessageCuid("INTELLIGENTMESSAGE"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function:  设置IntelligentMessage表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:22:23
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<IntelligentMessage> bs,String notes,IntelligentMessage b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("INTELLIGENT_MESSAGE");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setIntelligentMessageCuid("INTELLIGENTMESSAGE"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置KeyLog表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:22:35
	* @Since JDK 1.8
	 */
	public static void setCuid(KeyLog b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("KEY_LOG");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setKeyLogCuid("KEYLOG"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置KeyLog表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:22:49
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<KeyLog> bs,String notes,KeyLog b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("KEY_LOG");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setKeyLogCuid("KEYLOG"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置LearnPlan表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:23:10
	* @Since JDK 1.8
	 */
	public static void setCuid(LearnPlan b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("LEARN_PLAN");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setLearnPlanCuid("LEARNPLAN"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置LearnPlan表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:23:25
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<LearnPlan> bs,String notes,LearnPlan b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("LEARN_PLAN");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setLearnPlanCuid("LEARNPLAN"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置Major表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:23:38
	* @Since JDK 1.8
	 */
	public static void setCuid(Major b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("MAJOR");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setMajorCuid("MAJOR"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	
	/**
	 * 
	* @Function: 设置Major表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:23:50
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Major> bs,String notes,Major b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("MAJOR");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setMajorCuid("MAJOR"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置Oppointment表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:24:40
	* @Since JDK 1.8
	 */
	public static void setCuid(Oppointment b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("OPPOINTMENT");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setOppointmentCuid("OPPOINTMENT"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置Oppointment表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:24:52
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Oppointment> bs,String notes,Oppointment b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("OPPOINTMENT");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setOppointmentCuid("OPPOINTMENT"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置Post表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:25:05
	* @Since JDK 1.8
	 */
	public static void setCuid(Post b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("POST");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setPostCuid("POST"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置Post表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:25:18
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Post> bs,String notes,Post b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("POST");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setPostCuid("POST"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置Replies表的CUID 
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:25:32
	* @Since JDK 1.8
	 */
	public static void setCuid(Replies b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("REPLIES");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setRepliesCuid("REPLIES"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置Replies表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:25:44
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<Replies> bs,String notes,Replies b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("REPLIES");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setRepliesCuid("REPLIES"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	/**
	 * 
	* @Function: 设置SysUser表的CUID
	* @Title: setCuid 
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:26:04
	* @Since JDK 1.8
	 */
	public static void setCuid(SysUser b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("SYS_USER");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setSysUserCuid("SYSUSER"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	/**
	 * 
	* @Function: 设置SysUser表的CUID LIST
	* @Title: setCuidList 
	* @param @param bs
	* @param @param notes
	* @param @param b
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 下午4:26:16
	* @Since JDK 1.8
	 */
	public static void setCuidList(List<SysUser> bs,String notes,SysUser b) throws Exception{
		for(int i = 0;i<bs.size();i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("SYS_USER");
			globalTable.setGlobalTableNotes(notes);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			globalTableService.doInsert(globalTable);
			bs.get(i).setSysUserCuid("SYSUSER"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
		}
	}
	
	//新增表
	
	/**
	 * 数据共享主键插入
	* @Function: 
	* @Title: setCuid  
	* @param b
	* @param notes
	* @throws Exception   
	* void    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月17日 下午3:18:33
	* @Since JDK 1.8
	 */
	public static void setCuid(DataSharing b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("DATA_SHARING");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setDataSharingCuid("DATA_SHARING"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	
	/**
	 * 学校数据主键插入
	* @Function: 
	* @Title: setCuid  
	* @param b
	* @param notes
	* @throws Exception   
	* void    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月17日 下午3:18:33
	* @Since JDK 1.8
	 */
	public static void setCuid(SchoolInformation b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("SCHOOL_INFORMATION");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setSchoolInformationCuid("SCHOOL_INFORMATION"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
	
	/**
	 * 学校简介主键插入
	* @Function: 
	* @Title: setCuid  
	* @param b
	* @param notes
	* @throws Exception   
	* void    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月17日 下午3:18:33
	* @Since JDK 1.8
	 */
	public static void setCuid(SchoolProfile b,String notes) throws Exception{
		GlobalTable globalTable = new GlobalTable();
		globalTable.setGlobalTableTableName("SCHOOL_PROFILE");
		globalTable.setGlobalTableNotes(notes);
		globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
		globalTableService.doInsert(globalTable);
		b.setSchoolProfileCuid("SCHOOL_PROFILE"+TimeUtils.getCuidHeadTime()+"0"+globalTable.getGlobalTableCuid());
	}
}
