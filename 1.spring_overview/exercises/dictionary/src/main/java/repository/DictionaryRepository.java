package repository;


import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository implements Repository{
    private static Map<String,String> map;
    static {
        map = new HashMap<>();
        map.put("hello","Xin chào");
        map.put("dictionary","Thư viện");
        map.put("sorry","Xin lỗi");
        map.put("student","Sinh viên");
        map.put("teacher","Giáo Viên");
    }
    @Override
    public String findValue(String string) {
        return map.get(string);
    }
}
