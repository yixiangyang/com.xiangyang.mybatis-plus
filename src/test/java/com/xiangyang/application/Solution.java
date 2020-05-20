package com.xiangyang.application;

import com.xiangyang.model.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println(complement+"这个是i"+i);
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public void findRepeatNumber(int[] nums) {
        Set<String > h = new HashSet(Arrays.asList(nums));
        String[] strs = h.toArray(new String[h.size()]);
        System.out.println(h.toString());

        for (String kk :strs){
            System.out.println(kk);
        }
    }

    public static void main(String[] args) {
        StringUtils.isEmpty("aa");
        System.out.println(ObjectUtils.isEmpty(new User()));
        List<String> list = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list));
    }

}
