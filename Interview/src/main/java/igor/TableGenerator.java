package igor;

import java.util.*;

/**
 * @author Igor Artimenko
 * 
 * This class was created based on https://stackoverflow.com/questions/2745206/output-in-a-table-format-in-javas-system-out post.
 * 
 * Original TableGenerator did not work properly with nulls
 * Current version properly shows even when some fields in certain rows are null.
 *  
 */
public class TableGenerator {

    private int PADDING_SIZE = 1;
    private String NEW_LINE = "\n";
    private String TABLE_JOINT_SYMBOL = "+";
    private String TABLE_V_SPLIT_SYMBOL = "|";
    private String TABLE_H_SPLIT_SYMBOL = "-";

    public String generateTable(List<String> headersList, List<List<String>> rowsList,int... overRiddenHeaderHeight)
    {
        StringBuilder stringBuilder = new StringBuilder();

        int rowHeight = overRiddenHeaderHeight.length > 0 ? overRiddenHeaderHeight[0] : 1; 

        Map<Integer,Integer> columnMaxWidthMapping = getMaximumWidhtofTable(headersList, rowsList);

        stringBuilder.append(NEW_LINE);
        stringBuilder.append(NEW_LINE);
        createRowLine(stringBuilder, headersList.size(), columnMaxWidthMapping);
        stringBuilder.append(NEW_LINE);


        for (int headerIndex = 0; headerIndex < headersList.size(); headerIndex++) {
            fillCell(stringBuilder, headersList.get(headerIndex), headerIndex, columnMaxWidthMapping);
        }

        stringBuilder.append(NEW_LINE);

        createRowLine(stringBuilder, headersList.size(), columnMaxWidthMapping);


        for (List<String> row : rowsList) {

            for (int i = 0; i < rowHeight; i++) {
                stringBuilder.append(NEW_LINE);
            }

            for (int cellIndex = 0; cellIndex < row.size(); cellIndex++) {
                fillCell(stringBuilder, row.get(cellIndex), cellIndex, columnMaxWidthMapping);
            }

        }

        stringBuilder.append(NEW_LINE);
        createRowLine(stringBuilder, headersList.size(), columnMaxWidthMapping);
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(NEW_LINE);

        return stringBuilder.toString();
    }

    private void fillSpace(StringBuilder stringBuilder, int length)
    {
        for (int i = 0; i < length; i++) {
            stringBuilder.append(" ");
        }
    }

    private void createRowLine(StringBuilder stringBuilder,int headersListSize, Map<Integer,Integer> columnMaxWidthMapping)
    {
        for (int i = 0; i < headersListSize; i++) {
            if(i == 0)
            {
                stringBuilder.append(TABLE_JOINT_SYMBOL);   
            }

            for (int j = 0; j < columnMaxWidthMapping.get(i) + PADDING_SIZE * 2 ; j++) {
                stringBuilder.append(TABLE_H_SPLIT_SYMBOL);
            }
            stringBuilder.append(TABLE_JOINT_SYMBOL);
        }
    }


    private Map<Integer,Integer> getMaximumWidhtofTable(List<String> headersList, List<List<String>> rowsList)
    {
        Map<Integer,Integer> columnMaxWidthMapping = new HashMap<>();

        for (int columnIndex = 0; columnIndex < headersList.size(); columnIndex++) {
            columnMaxWidthMapping.put(columnIndex, 0);
        }

        for (int columnIndex = 0; columnIndex < headersList.size(); columnIndex++) {

            if(headersList.get(columnIndex).length() > columnMaxWidthMapping.get(columnIndex))
            {
                columnMaxWidthMapping.put(columnIndex, headersList.get(columnIndex).length());
            }
        }


        for (List<String> row : rowsList) {

            for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                if( row.get(columnIndex) != null && row.get(columnIndex).length() > columnMaxWidthMapping.get(columnIndex))
                {
                    columnMaxWidthMapping.put(columnIndex, row.get(columnIndex).length());
                }
            }
        }

        for (int columnIndex = 0; columnIndex < headersList.size(); columnIndex++) {

            if(columnMaxWidthMapping.get(columnIndex) % 2 != 0)
            {
                columnMaxWidthMapping.put(columnIndex, columnMaxWidthMapping.get(columnIndex) + 1);
            }
        }


        return columnMaxWidthMapping;
    }

    private int getOptimumCellPadding(int cellIndex,int datalength,Map<Integer,Integer> columnMaxWidthMapping,int cellPaddingSize)
    {
        if(datalength % 2 != 0)
        {
            datalength++;
        }

        if(datalength < columnMaxWidthMapping.get(cellIndex))
        {
            cellPaddingSize = cellPaddingSize + (columnMaxWidthMapping.get(cellIndex) - datalength) / 2;
        }

        return cellPaddingSize;
    }

    private void fillCell(StringBuilder stringBuilder,String cell,int cellIndex,Map<Integer,Integer> columnMaxWidthMapping)
    {
    	if( cell != null ){
    		
            int cellPaddingSize = getOptimumCellPadding(cellIndex, cell.length(), columnMaxWidthMapping, PADDING_SIZE);

            if(cellIndex == 0)
            {
                stringBuilder.append(TABLE_V_SPLIT_SYMBOL); 
            }

            fillSpace(stringBuilder, cellPaddingSize);
            stringBuilder.append(cell);
            if(cell.length() % 2 != 0)
            {
                stringBuilder.append(" ");
            }

            fillSpace(stringBuilder, cellPaddingSize);

            stringBuilder.append(TABLE_V_SPLIT_SYMBOL);     		
    	}
    	else // null values 
    	{
            int cellPaddingSize = getOptimumCellPadding(cellIndex, 4, columnMaxWidthMapping, PADDING_SIZE);

            if(cellIndex == 0)
            {
                stringBuilder.append(TABLE_V_SPLIT_SYMBOL); 
            }

            fillSpace(stringBuilder, cellPaddingSize);            
            stringBuilder.append(cell);
            
            fillSpace(stringBuilder, cellPaddingSize);

            stringBuilder.append(TABLE_V_SPLIT_SYMBOL);  
    		
    	}

    }

    public static void main(String[] args) {
        TableGenerator tableGenerator = new TableGenerator();

        List<String> headersList = new ArrayList<>(); 
        headersList.add("Id");
        headersList.add("F-Name");
        headersList.add("L-Name");
        headersList.add("Email");

        List<List<String>> rowsList = new ArrayList<>();

        Random rnd = new Random(12345);

        for (int i = 0; i < 5; i++) {
            List<String> row = new ArrayList<>(); 
            row.add(UUID.randomUUID().toString().substring(0,rnd.nextInt(15)));
            row.add(UUID.randomUUID().toString().substring(0,rnd.nextInt(15)));
            row.add(UUID.randomUUID().toString().substring(0,rnd.nextInt(15)));
            row.add(UUID.randomUUID().toString().substring(0,rnd.nextInt(15)));

            rowsList.add(row);
        }

        System.out.println(tableGenerator.generateTable(headersList, rowsList));
    }
}