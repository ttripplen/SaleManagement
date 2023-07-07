/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class Validation {
    public static boolean testCode(String code) {
        //regex: kiểu quy định String - regular expression 
        String regex = "^(HR)\\d{5}$"; //
        Pattern pattern = Pattern.compile(regex); //Tạo mẫu từ việc compile regex
        //Kiểm tra coi pattern có match với name không
        Matcher matcher = pattern.matcher(code); //matcher là object chứa kq 
        return matcher.matches(); //Trả kết quả 
    }
}
