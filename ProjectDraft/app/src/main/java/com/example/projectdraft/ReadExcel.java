package com.example.projectdraft;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public ArrayList<StudentInfo> read() throws IOException  {

        ArrayList<StudentInfo> studentList = new ArrayList<StudentInfo>();
        File inputWorkbook = new File(inputFile);
        Workbook w;

        try {
            w = Workbook.getWorkbook(inputWorkbook);

            Sheet sheet = w.getSheet(1);

            int sheetNum = w.getNumberOfSheets();
            int sheetRows = sheet.getRows();
            int sheetColumns = sheet.getColumns();

            Log.d("ReadExcel","the num of sheets is " + sheetNum);
            Log.d("ReadExcel","the name of sheet is  " + sheet.getName());
            Log.d("ReadExcel","total rows is " + sheetRows);
            Log.d("ReadExcel","total cols is " + sheetColumns);

            for (int i = 1; i < sheetRows; i++) {
                StudentInfo studentInfo = new StudentInfo();
                studentInfo.setStuInfo(sheet.getCell(0, i).getContents(),
                        sheet.getCell(1, i).getContents(),
                        sheet.getCell(2, i).getContents(),
                        sheet.getCell(3, i).getContents());

                studentList.add(studentInfo);
            }

        } catch (BiffException e) {
            Log.e("ReadExcel", "read error=" + e, e);
        }

        return studentList;
    }

}