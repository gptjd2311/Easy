package com.easy.test0805.dto;

public class BCommentDto {

	private int  NOTICE_COMMENT_NUM;
	private int  NOTICE_COMMENT_BOARD;
	private String  NOTICE_COMMENT_ID;
	private String  NOTICE_COMMENT_DATE;
	private String  NOTICE_COMMENT_CONTENT;
	private int NOTICE_COMMENT_INDENT;
	private int NOTICE_COMMENT_GROUPID;
	private int NOTICE_COMMENT_STEP; 	

	

	public BCommentDto(int nOTICE_COMMENT_NUM, int nOTICE_COMMENT_BOARD, String nOTICE_COMMENT_ID,
			String nOTICE_COMMENT_DATE, String nOTICE_COMMENT_CONTENT, int nOTICE_COMMENT_INDENT,
			int nOTICE_COMMENT_GROUPID, int nOTICE_COMMENT_STEP) {
		super();
		NOTICE_COMMENT_NUM = nOTICE_COMMENT_NUM;
		NOTICE_COMMENT_BOARD = nOTICE_COMMENT_BOARD;
		NOTICE_COMMENT_ID = nOTICE_COMMENT_ID;
		NOTICE_COMMENT_DATE = nOTICE_COMMENT_DATE;
		NOTICE_COMMENT_CONTENT = nOTICE_COMMENT_CONTENT;
		NOTICE_COMMENT_INDENT = nOTICE_COMMENT_INDENT;
		NOTICE_COMMENT_GROUPID = nOTICE_COMMENT_GROUPID;
		NOTICE_COMMENT_STEP = nOTICE_COMMENT_STEP;
	}
	

	public BCommentDto() {
		// TODO Auto-generated constructor stub
	}

	public int getNOTICE_COMMENT_NUM() {
		return NOTICE_COMMENT_NUM;
	}
	public void setNOTICE_COMMENT_NUM(int nOTICE_COMMENT_NUM) {
		NOTICE_COMMENT_NUM = nOTICE_COMMENT_NUM;
	}
	public int getNOTICE_COMMENT_BOARD() {
		return NOTICE_COMMENT_BOARD;
	}
	public void setNOTICE_COMMENT_BOARD(int nOTICE_COMMENT_BOARD) {
		NOTICE_COMMENT_BOARD = nOTICE_COMMENT_BOARD;
	}
	public String getNOTICE_COMMENT_ID() {
		return NOTICE_COMMENT_ID;
	}
	public void setNOTICE_COMMENT_ID(String nOTICE_COMMENT_ID) {
		NOTICE_COMMENT_ID = nOTICE_COMMENT_ID;
	}
	public String getNOTICE_COMMENT_DATE() {
		return NOTICE_COMMENT_DATE;
	}
	public void setNOTICE_COMMENT_DATE(String nOTICE_COMMENT_DATE) {
		NOTICE_COMMENT_DATE = nOTICE_COMMENT_DATE;
	}
	public String getNOTICE_COMMENT_CONTENT() {
		return NOTICE_COMMENT_CONTENT;
	}
	public void setNOTICE_COMMENT_CONTENT(String nOTICE_COMMENT_CONTENT) {
		NOTICE_COMMENT_CONTENT = nOTICE_COMMENT_CONTENT;
	}
	public int getNOTICE_COMMENT_INDENT() {
		return NOTICE_COMMENT_INDENT;
	}
	public void setNOTICE_COMMENT_INDENT(int nOTICE_COMMENT_INDENT) {
		NOTICE_COMMENT_INDENT = nOTICE_COMMENT_INDENT;
	}
	public int getNOTICE_COMMENT_GROUPID() {
		return NOTICE_COMMENT_GROUPID;
	}
	public void setNOTICE_COMMENT_GROUPID(int nOTICE_COMMENT_GROUPID) {
		NOTICE_COMMENT_GROUPID = nOTICE_COMMENT_GROUPID;
	}
	public int getNOTICE_COMMENT_STEP() {
		return NOTICE_COMMENT_STEP;
	}
	public void setNOTICE_COMMENT_STEP(int nOTICE_COMMENT_STEP) {
		NOTICE_COMMENT_STEP = nOTICE_COMMENT_STEP;
	}

	
	

}
