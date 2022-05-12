class Solution {
    public String solution(int a, int b) {
        String[] week = {"THU","FRI","SAT","SUN","MON","TUE","WED"};

        int date = b;

        switch(a){
            case 12:
                date += 30;
            case 11:
                date += 31;
            case 10:
                date += 30;
            case 9:
                date += 31;
            case 8:
                date += 31;
            case 7:
                date += 30;
            case 6:
                date += 31;
            case 5:
                date += 30;
            case 4:
                date += 31;
            case 3:
                date += 29;
            case 2:
                date += 31;
        }

        return week[date%7];
    }
}