class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res= new int[2];
        HashMap<Integer, Integer> store= new HashMap<>(numbers.length);
        for(int i=0; i< numbers.length; i++){
            store.put(numbers[i], i+1);
        }
        for(int i=0; i< numbers.length; i++){
            int secondValue= target-numbers[i];
            if(store.containsKey(secondValue)){
                res[0]=i+1;
                res[1]=store.get(secondValue);
                return res;
            }
        }
        return res;

    }
}
