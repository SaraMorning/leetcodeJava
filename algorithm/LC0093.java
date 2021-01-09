package com.algorithm;

import java.util.*;

public class LC0093 {
/*    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.isEmpty() || s.length() < 4) {
            return result;
        }
        this.inputStr = s;
        this.strLen = s.length();
        dfs(0, 0, "", result);
        return result;
    }

    public void dfs(int startPos, int partIndex, String curIp, List<String> result) {
        if (startPos == strLen && partIndex == 4) {
            result.add(curIp.substring(0, curIp.length() - 1));
            return;
        }
        // 剩余过多
        if (strLen - startPos > 3 * (4 - partIndex)) {
            return;
        }
        // 剩余过少
        if (strLen - startPos < (4 - partIndex)) {
            return;
        }
        for (int index = 1; index < 4 && ((startPos+index) <= strLen); ++index) {
            String segment = inputStr.substring(startPos, startPos + index);
            if (isValid(segment)) {
                dfs(startPos + index, partIndex + 1, curIp + segment + ".", result);
            }
        }
    }

    private boolean isValid(String segment) {
        int num = Integer.parseInt(segment);
        int segLen = segment.length();
        if (segLen > 3) {
            return false;
        }
        return segment.charAt(0) == '0' ? (segLen == 1) : (num <= 255);
    }*/

    public List<String> restoreIpAddresses1(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty() || s.length() < 4) {
            return result;
        }
        dfsRestoreIp(0, 0, s, "", result);
        return result;
    }

    private void dfsRestoreIp(int startIndex, int partIndex, String inputStr, String curIpStr, List<String> result) {
        if (startIndex == inputStr.length() && partIndex == 4) {
            result.add(curIpStr.substring(0, curIpStr.length() - 1));
            return;
        }

        // 剩余过多
        if (inputStr.length() - startIndex > (4 - partIndex) * 3) {
            return;
        }

        // 剩余过少
        if (inputStr.length() - startIndex < (4 - partIndex)) {
            return;
        }

        for (int index = 1; index < 4 && ((startIndex+index) <= inputStr.length()); ++index) {
            String curIp = inputStr.substring(startIndex, startIndex + index);
            if (isValidIp(curIp)) {
                dfsRestoreIp(startIndex + index, partIndex + 1, inputStr, curIpStr + curIp + ".", result);
            }
        }
    }

    private boolean isValidIp(String curIp) {
        int ipIntValue = Integer.parseInt(curIp);
        int ipLen = curIp.length();
        if (ipLen > 3) {
            return false;
        }
        return curIp.charAt(0) == '0' ? (ipLen == 1) : (ipLen <= 255);
    }
}
