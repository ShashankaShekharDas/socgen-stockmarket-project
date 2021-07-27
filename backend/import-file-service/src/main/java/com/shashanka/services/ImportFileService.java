package com.shashanka.services;

import com.shashanka.entities.Company;
import com.shashanka.entities.Stock;
import com.shashanka.entities.StockExchange;
import com.shashanka.repositories.CompanyRepository;
import com.shashanka.repositories.StockExchangeRepository;
import com.shashanka.repositories.StockRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class ImportFileService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    StockExchangeRepository stockExchangeRepository;

    public ResponseEntity addCompanyStock(Integer companyCode, String stockExchange, List<Double> price, List<LocalDateTime> dateTime){

        Optional<Company> company = companyRepository.findById(companyCode);
        if(company.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with code "+String.valueOf(companyCode)+" doesn't exist. Verify and try again");

        String companyName = company.get().getName();

        System.out.println(stockExchange);
        stockExchange = stockExchange.toLowerCase(Locale.ROOT);
        Optional<StockExchange> exchangeRow = stockExchangeRepository.findById(stockExchange);

        if(exchangeRow.isEmpty())return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exchange with name "+stockExchange+" doesn't exist. Verify and try again");

        int count = 0;
        for (int i = 0; i < dateTime.size();i++) {
            try {
                stockRepository.save(new Stock(companyCode,exchangeRow.get(),company.get(),price.get(i),dateTime.get(i)));
                count ++;
            } catch (Exception e) {

            }
        }

        return ResponseEntity.ok("Added "+count+" rows to the table");
    }

    public boolean verify_columns(XSSFSheet sheet)
    {
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();
        return row.getCell(0).toString().equals("Company Code") && row.getCell(1).toString().equals("Stock Exchange") && row.getCell(2).toString().equals("Price Per Share(in Rs)") && row.getCell(3).toString().strip().equals("Date") && row.getCell(4).toString().equals("Time");
    }

    public ResponseEntity addFileService(MultipartFile file) throws IOException {
       /*
            * Checks to be performed
            * Wrong file
            * Missing values
            * Excel sheet in wrong format or wrong excel sheet
        */


        XSSFWorkbook stockDetails = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = stockDetails.getSheetAt(0);

        if(!verify_columns(sheet))
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Invalid data/column format in sheet");

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        int companyCode = 0;
        String stockExchange = "";
        List<Double> price = new ArrayList<Double>();
        List<LocalDate> dates = new ArrayList<>();
        List<String> times = new ArrayList<String>();

        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            while (cellIterator.hasNext()){
                i += 1;
                Cell cell = cellIterator.next();
                try {

                    switch (i) {
                        case 2:
                            stockExchange = cell.getStringCellValue();
                            break;
                        case 3:
                            price.add(cell.getNumericCellValue());
                            break;
                        case 4:
                            String date = row.getCell(3).toString();
                            DateFormat format = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
                            Date date1 = format.parse(date);

                            dates.add(LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault()));
                            break;
                        case 5:
                            times.add(cell.getStringCellValue().strip());
                            break;
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        rowIterator = sheet.iterator();
        rowIterator.next();
        Row row = rowIterator.next();
        companyCode = Integer.valueOf(row.getCell(0).toString().replace((char) 160,' ').strip());
        List<LocalDateTime> priceDateTime = new ArrayList<>();
        for (int i = 0;i<dates.size();i++)
            priceDateTime.add(LocalDateTime.parse(dates.get(i).toString()+"T"+times.get(i).toString()));

        return addCompanyStock(companyCode,stockExchange,price,priceDateTime);
    }
}
