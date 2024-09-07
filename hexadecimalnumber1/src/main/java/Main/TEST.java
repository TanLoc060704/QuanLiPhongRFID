/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.math.BigInteger;

/**
 *
 * @author rfid
 */
public class TEST {
    public static void main(String[] args) {

        TEST test = new TEST();
        String upc = test.formatUpc("190517215391"); 
        BigInteger serial = convertStringToBigInteger("240824000001");
        String He = "48";
        String Fi = "1";
        String Par = "5";
        int qty = 10;
//        System.out.println(upc);
        for(int i = 1; i<qty+1;i++){
            test.converUpcToEpc(upc,serial,He,Fi,Par);
            serial = serial.add(BigInteger.ONE);
        }

    }
    String formatUpc (String UPC){
        return String.format("%14s", UPC).replace(" ","0");
    }
    
    public void converUpcToEpc(String chuoiUpc, BigInteger serial, String He, String Fi, String Par){
        int lengthUpc = chuoiUpc.length();
//        System.out.println(lengthUpc);
        String UpcRemoveCheckDigit = chuoiUpc.substring(0,lengthUpc - 1);
        
        String Indicator ="";
        String GS1CompanyPrefix ="";
        String ItemReferenceNumber ="";
        
        switch (Integer.parseInt(Par)) {
            case 0:
                Indicator = UpcRemoveCheckDigit.substring(0,1);
                GS1CompanyPrefix = UpcRemoveCheckDigit.substring(1,13);
                ItemReferenceNumber = UpcRemoveCheckDigit.substring(13);
                System.out.println(Indicator);
                System.out.println(GS1CompanyPrefix);
                System.out.println(ItemReferenceNumber);
                
                break;
            case 1:
                Indicator = UpcRemoveCheckDigit.substring(0,1);
                GS1CompanyPrefix = UpcRemoveCheckDigit.substring(1,12);
                ItemReferenceNumber = UpcRemoveCheckDigit.substring(12);
                System.out.println(Indicator);
                System.out.println(GS1CompanyPrefix);
                System.out.println(ItemReferenceNumber);
                break;
            case 2:
                Indicator = UpcRemoveCheckDigit.substring(0,1);
                GS1CompanyPrefix = UpcRemoveCheckDigit.substring(1,11);
                ItemReferenceNumber = UpcRemoveCheckDigit.substring(11);
                System.out.println(Indicator);
                System.out.println(GS1CompanyPrefix);
                System.out.println(ItemReferenceNumber);
                break;
            case 3:
                Indicator = UpcRemoveCheckDigit.substring(0,1);
                GS1CompanyPrefix = UpcRemoveCheckDigit.substring(1,10);
                ItemReferenceNumber = UpcRemoveCheckDigit.substring(10);
                System.out.println(Indicator);
                System.out.println(GS1CompanyPrefix);
                System.out.println(ItemReferenceNumber);
                break;
            case 4:
                Indicator = UpcRemoveCheckDigit.substring(0,1);
                GS1CompanyPrefix = UpcRemoveCheckDigit.substring(1,9);
                ItemReferenceNumber = UpcRemoveCheckDigit.substring(9);
                System.out.println(Indicator);
                System.out.println(GS1CompanyPrefix);
                System.out.println(ItemReferenceNumber);
                break;
            case 5:
                Indicator = UpcRemoveCheckDigit.substring(0,1);
                GS1CompanyPrefix = UpcRemoveCheckDigit.substring(1,8);
                ItemReferenceNumber = UpcRemoveCheckDigit.substring(8);
                System.out.println(Indicator);
                System.out.println(GS1CompanyPrefix);
                System.out.println(ItemReferenceNumber);
                break;
            case 6:
                Indicator = UpcRemoveCheckDigit.substring(0,1);
                GS1CompanyPrefix = UpcRemoveCheckDigit.substring(1,7);
                ItemReferenceNumber = UpcRemoveCheckDigit.substring(7);
                System.out.println(Indicator);
                System.out.println(GS1CompanyPrefix);
                System.out.println(ItemReferenceNumber);
                break;
            default:
                System.out.println("Invalid partition value.");
                return;
        }
        
       
        
        String GS1CompanyPrefixCuted = GS1CompanyPrefix;
        String IndicatorAndItemReferenceNumber = Indicator+ItemReferenceNumber;
        BigInteger serialNumber = serial;
        String Header = He;
        String Filter = Fi;
        String Partition = Par;
        
//        System.out.println(Indicator+"---"+GS1CompanyPrefix+"---"+ItemReferenceNumber);
        
//        System.out.println(GS1CompanyPrefixCuted);
//        System.out.println(IndicatorAndItemReferenceNumber);
//        System.out.println(serialNumber);
//        System.out.println(Header);
//        System.out.println(Filter);
//        System.out.println(Partition);
//        
        
        
        // Chuyển các phần thành nhị phân
        String binaryHeader = String.format("%8s", new BigInteger(Header).toString(2)).replace(" ", "0");
        String binaryFilter = String.format("%3s", new BigInteger(Filter).toString(2)).replace(" ", "0");
        String binaryPartition = String.format("%3s", new BigInteger(Partition).toString(2)).replace(" ", "0");
        String binarySerialNumber = String.format("%38s", new BigInteger(convertBigIntegerToString(serialNumber)).toString(2)).replace(" ", "0");
        
        String binaryCompany;
        String binaryItem;
        switch (Integer.parseInt(Par)) {
            case 0:
                binaryCompany = String.format("%40s", new BigInteger(GS1CompanyPrefixCuted).toString(2)).replace(" ", "0");
                binaryItem = String.format("%4s", new BigInteger(IndicatorAndItemReferenceNumber).toString(2)).replace(" ", "0");
                break;
            case 1:
                binaryCompany = String.format("%37s", new BigInteger(GS1CompanyPrefixCuted).toString(2)).replace(" ", "0");
                binaryItem = String.format("%7s", new BigInteger(IndicatorAndItemReferenceNumber).toString(2)).replace(" ", "0");
                break;
            case 2:
                binaryCompany = String.format("%34s", new BigInteger(GS1CompanyPrefixCuted).toString(2)).replace(" ", "0");
                binaryItem = String.format("%10s", new BigInteger(IndicatorAndItemReferenceNumber).toString(2)).replace(" ", "0");
                break;
            case 3:
                binaryCompany = String.format("%30s", new BigInteger(GS1CompanyPrefixCuted).toString(2)).replace(" ", "0");
                binaryItem = String.format("%14s", new BigInteger(IndicatorAndItemReferenceNumber).toString(2)).replace(" ", "0");
                break;
            case 4:
                binaryCompany = String.format("%27s", new BigInteger(GS1CompanyPrefixCuted).toString(2)).replace(" ", "0");
                binaryItem = String.format("%17s", new BigInteger(IndicatorAndItemReferenceNumber).toString(2)).replace(" ", "0");
                break;
            case 5:
                binaryCompany = String.format("%24s", new BigInteger(GS1CompanyPrefixCuted).toString(2)).replace(" ", "0");
                binaryItem = String.format("%20s", new BigInteger(IndicatorAndItemReferenceNumber).toString(2)).replace(" ", "0");
                break;
            case 6:
                binaryCompany = String.format("%20s", new BigInteger(GS1CompanyPrefixCuted).toString(2)).replace(" ", "0");
                binaryItem = String.format("%24s", new BigInteger(IndicatorAndItemReferenceNumber).toString(2)).replace(" ", "0");
                break;
            default:
                System.out.println("Invalid partition value.");
                return;
        }

//        System.out.println("Binary GS1 Company Prefix: " + binaryCompany);
//        System.out.println("Binary Item Reference Number: " + binaryItem);
//        System.out.println("Binary Serial Number: " + binarySerialNumber);
//        System.out.println("Binary Header: " + binaryHeader);
//        System.out.println("Binary Filter: " + binaryFilter);
//        System.out.println("Binary Partition: " + binaryPartition);
    
        String binaryEPC = binaryHeader + binaryFilter + binaryPartition + binaryCompany + binaryItem + binarySerialNumber;
        System.out.println(binaryToHex(binaryEPC));
//        System.out.println(binaryToHex(binaryCompany));
//        System.out.println(binaryToHex(binaryItem));
        
    }
    
    private String binaryToHex(String binaryString) {
        // Đảm bảo độ dài của chuỗi nhị phân là bội số của 4
        int length = binaryString.length();
        int paddingLength = (4 - (length % 4)) % 4;
        String paddedBinary = "0".repeat(paddingLength) + binaryString;

        // Chia chuỗi nhị phân thành các khối 4 bit
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < paddedBinary.length(); i += 4) {
            String fourBits = paddedBinary.substring(i, i + 4);
            // Chuyển 4 bit thành ký tự hexadecimal
            hexString.append(Integer.toHexString(Integer.parseInt(fourBits, 2)).toUpperCase());
        }
        return hexString.toString();
    }
    
    
     public static BigInteger convertStringToBigInteger(String numberStr) {
        // Xử lý ngoại lệ nếu chuỗi không phải là số hợp lệ
        try {
            return new BigInteger(numberStr);
        } catch (NumberFormatException e) {
            System.out.println("Chuỗi không hợp lệ: " + numberStr);
            return BigInteger.ZERO; // Trả về 0 nếu có lỗi
        }
    }

    // Hàm chuyển từ BigInteger sang chuỗi số (String)
    public static String convertBigIntegerToString(BigInteger number) {
        return number.toString(); // Chuyển đổi BigInteger thành chuỗi
    }
}
