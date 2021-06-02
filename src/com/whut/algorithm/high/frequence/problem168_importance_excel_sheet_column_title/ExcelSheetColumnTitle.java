package com.whut.algorithm.high.frequence.problem168_importance_excel_sheet_column_title;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/22 19:45
 * @desription
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while (columnNumber != 0) {
            //因为 Excel 取值范围为 1~26，故可将 26 进制 逻辑上的 个位、十位、百位…均减 1 映射到 0~25 即可
            columnNumber--;
            sb.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

    }
}
