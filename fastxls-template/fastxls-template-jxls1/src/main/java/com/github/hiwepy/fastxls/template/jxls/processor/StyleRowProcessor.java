package com.github.hiwepy.fastxls.template.jxls.processor;

import java.util.Map;

import net.sf.jxls.processor.RowProcessor;
import net.sf.jxls.transformer.Row;
import net.sf.jxls.transformer.RowCollection;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class StyleRowProcessor implements RowProcessor {

    String collectionName;
    String styleCellLabel = "customRow";

    public StyleRowProcessor(String collectionName) {
        this.collectionName = collectionName;
    }

    public void processRow(Row row, Map namedCells) {
        // check if processed row has a parent row
        if( row.getParentRow()!=null ){
            // Processed row has parent row. It means we are processing some collection item
            RowCollection rowCollection = row.getParentRow().getRowCollectionByCollectionName( collectionName );
            if( rowCollection.getIterateObject() instanceof Object){
               /* Employee employee = (Employee) rowCollection.getIterateObject();
                if( employee.getPayment().doubleValue() >= 2000 ){
                    if( namedCells.containsKey( styleCellLabel ) ){
                        Cell customCell = (Cell) namedCells.get( styleCellLabel );
                        for (int i = 0; i < row.getCells().size(); i++) {
                            Cell cell = (Cell) row.getCells().get(i);
                            HSSFCell hssfCell = cell.getHssfCell();
                            if( hssfCell!=null ){
                                copyStyle( row.getHssfWorkbook(), customCell.getHssfCell(), hssfCell );
                            }
                        }
                    }
                }*/
            }
        }
    }

    private void copyStyle(HSSFWorkbook workbook, HSSFCell fromCell, HSSFCell toCell){
        HSSFCellStyle toStyle = toCell.getCellStyle();
        HSSFCellStyle fromStyle = fromCell.getCellStyle();
        if( fromStyle.getDataFormat() == toStyle.getDataFormat() ){
            toCell.setCellStyle( fromStyle );
        }else{
            HSSFCellStyle newStyle = workbook.createCellStyle();
            newStyle.setAlignment( toStyle.getAlignment() );
            newStyle.setBorderBottom( toStyle.getBorderBottom() );
            newStyle.setBorderLeft( toStyle.getBorderLeft() );
            newStyle.setBorderRight( toStyle.getBorderRight() );
            newStyle.setBorderTop( toStyle.getBorderTop() );
            newStyle.setBottomBorderColor( toStyle.getBottomBorderColor() );
            newStyle.setDataFormat( toStyle.getDataFormat() );
            newStyle.setFillBackgroundColor( fromStyle.getFillBackgroundColor() );
            newStyle.setFillForegroundColor( fromStyle.getFillForegroundColor() );
            newStyle.setFillPattern( fromStyle.getFillPattern() );
            newStyle.setFont( workbook.getFontAt( fromStyle.getFontIndexAsInt() ) );
            newStyle.setHidden( toStyle.getHidden() );
            newStyle.setIndention( toStyle.getIndention() );
            newStyle.setLeftBorderColor( toStyle.getLeftBorderColor() );
            newStyle.setLocked( toStyle.getLocked() );
            newStyle.setRightBorderColor( toStyle.getRightBorderColor() );
            newStyle.setTopBorderColor( toStyle.getTopBorderColor() );
            newStyle.setVerticalAlignment( toStyle.getVerticalAlignment() );
            newStyle.setWrapText( toStyle.getWrapText() );
            toCell.setCellStyle( newStyle );
        }
    }
}
     