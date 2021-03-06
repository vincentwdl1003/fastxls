package com.github.hiwepy.fastxls.core.model;

/**
 *单元格合并信息
 */
public class MergedRegionModel {

	private int firstRow = 0; 
	private int lastRow = 1; 
	private int firstCol = 0; 
	private int lastCol = 1;
	
	public MergedRegionModel(int firstRow, int lastRow, int firstCol,int lastCol) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.firstCol = firstCol;
		this.lastCol = lastCol;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	public int getFirstCol() {
		return firstCol;
	}
	public void setFirstCol(int firstCol) {
		this.firstCol = firstCol;
	}
	public int getLastCol() {
		return lastCol;
	}
	public void setLastCol(int lastCol) {
		this.lastCol = lastCol;
	} 
	
	
	
}
