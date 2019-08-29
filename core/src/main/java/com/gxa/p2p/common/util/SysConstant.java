package com.gxa.p2p.common.util;

import java.math.BigDecimal;

/**
 * 系统中的常量
 * 
 * @author novo
 * 
 */
public class SysConstant {
	/**
	 * 发送手机验证码的时间间隔
	 */
	public static final long SEND_VERIFYCODE_INTERVAL  =  30 ; //秒

	/**
	 * 手机验证码的有效时间
	 */
	public static final long VERIFYCODE_VALID_TIME  =  1800000 ; //秒


	/**
	 * 定义系统级别的0
	 */
	public static final BigDecimal ZERO = new BigDecimal("0.0000");
	/**
	 * 定义存储精度
	 */
	public static final int STORE_SCALE = 4;
	/**
	 * 定义运算精度
	 */
	public static final int OPERATION_SCALE = 8;
	/**
	 * 定义显示精度
	 */
	public static final int DISPLAY_SCALE = 2;
	//最低授权分
	public static final int CREDIT_BORROW_SCORE =30;

	/**
	 * 定义初始授信额度
	 */
	public static final BigDecimal INIT_BORROW_LIMIT = new BigDecimal(
			"5000.0000");


	public static final long EMAIL_VALID_DAY = 100;

	//最小投标金额
	public static  final BigDecimal MIN_BID_AMOUNT=new BigDecimal(50);
	public static final int RETURN_TYPE_MONTH_INTEREST_PRINCIPAL = 10;
	public static final byte RETURN_TYPE_MONTH_INTEREST = 1;
	public static final byte BIDREQUEST_STATE_PUBLISH_PENDING =0 ;
	public static final byte BIDREQUEST_STATE_BIDDING = 1;
	public static final byte BIDREQUEST_STATE_UNDO = 2;
	public static final byte BIDREQUEST_STATE_BIDDING_OVERDUE =3 ;
	public static final byte BIDREQUEST_STATE_APPROVE_PENDING_1 =4 ;
	public static final byte BIDREQUEST_STATE_APPROVE_PENDING_2 = 5;
	public static final byte BIDREQUEST_STATE_REJECTED = 6;
	public static final byte BIDREQUEST_STATE_PAYING_BACK = 7;
	public static final byte BIDREQUEST_STATE_COMPLETE_PAY_BACK = 8;
	public static final byte BIDREQUEST_STATE_PAY_BACK_OVERDUE = 9;
	public static final byte BIDREQUEST_STATE_PUBLISH_REFUSE = 10;
}
