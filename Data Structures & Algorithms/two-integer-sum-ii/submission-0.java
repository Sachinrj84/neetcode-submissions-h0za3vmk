class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res= new int[2];
        for (int i=0; i< numbers.length-1; i++){
            int j=i+1;
            while(j<numbers.length){
                if(numbers[i]+numbers[j]==target){
                    res[0]=i+1;
                    res[1]=j+1;
                    return res;
                }
                j++;
            }
        }
        return res;
    }
}
