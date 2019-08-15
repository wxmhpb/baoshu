import java.util.*;
public class Main{
    public static int callSurvivalNumber(int count){
        if(count<=0){
            throw new IllegalArgumentException("Count must exit");
        }
        boolean []status=new boolean[count];
        for(int i=0;i<status.length;i++){
            status[i]=true;
        }
        int index=-1;  //索引下标
        int counter=0;  //当前退出的人数
        int current=0;  //当前人报的数
        while(counter<status.length-1){
            //index成环
            index=(index+1)%status.length;
            if(!status[index]){  //报数的人依旧参与下次循环
                continue;
            }
            //报数
            current=(current+1)%3;
            if(current==0){
                counter++;
                status[index]=false;
            }
        }
        for(int i=0;i<status.length;i++){
            if(status[i]){
                return i+1;
            }
        }
        throw new RuntimeException("Not found");
    }
    public static void main(String[]args) {
      int ret=callSurvivalNumber(10);
        System.out.println(ret);
        }
    }


