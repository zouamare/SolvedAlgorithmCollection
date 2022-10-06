package coding_test.Algo2022년_10월.day05;

import java.util.*;

class PG_전화번호목록 {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> prefixMap = new HashMap<>();
        boolean[] lenArr = new boolean[21];
        for(int i = 0, size = phone_book.length; i < size; i++){    // N만큼 돌면서 길이 check, map
            if(!lenArr[phone_book[i].length()])  lenArr[phone_book[i].length()] = true;
            prefixMap.put(phone_book[i], i);
        }

        for(int i = 0, size = phone_book.length; i < size; i++){    // N + N * K <= N^2
            for(int j = 1; j < 21; j++){  // K <= N
                if(!lenArr[j] || phone_book[i].length() < j)    continue;
                int val = prefixMap.getOrDefault(phone_book[i].substring(0, j), -1);
                if(val != i && val != -1)    return false;
            }
        }

        return true;
    }
}