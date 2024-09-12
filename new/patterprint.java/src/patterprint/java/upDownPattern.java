package patterprint.java;

import java.util.HashMap;
import java.util.LinkedList;

public class upDownPattern {
	public static void main(String[] args) {
		boolean isUp=true;
		int value=0,inc=1,rowStart=0,n=20;
		for(int i=0;i<n;i++) {
			if(i%2==1) {
				isUp=false;
				rowStart+=(2*i);
			}else {
				isUp=true;
				rowStart++;
			}
			inc=1;
			System.out.print(rowStart+"  ");
			value=rowStart;
			for(int j=0;j<n-1;j++) {
				if(isUp==true) {
					value+=(2*i)+1;
				}else {
					value+=(2*j)+2;
				}
				if(j>=n-i-1) {
					value-=inc;
					inc+=2;
				}
				System.out.print(value+"   ");
				isUp=!isUp;
			}
			System.out.println();
		}
	}

}




//class mycom implements Comparator<Map.Entry<Integer,Integer>>{
//    public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b){
//        if(a.getValue()<b.getValue()){
//            return 1;
//        }return -1;
//    }
//}
//class Solution {
//    public int findDuplicate(int[] nums) {
//        HashMap<Integer,Integer> map=new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            int cur =nums[i];
//            if(map.containsKey(cur)){
//                map.put(cur,map.get(cur)+1);
//            }else{
//                map.put(cur,1);
//            }
//        }
//        List<Map.Entry<Integer,Integer>> l=new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
//        Collections.sort(l,new mycom());
//        for(Map.Entry<Integer,Integer> a:l){
//            return a.getKey();
//        }
//        // System.out.println(l);
//        return 1;
//    }
//}
