package com.three.coinexchange.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tony on 2016/8/23.
 */
public class LoginUserUtil {

    /**
     * 从cookie中获取userId
     * @param request
     * @return
     */
    public static Long releaseUserIdFromCookie(HttpServletRequest request) {
        String userIdString = CookieUtil.getCookieValue(request, "userId");
        System.out.println(userIdString+"---------------");
        if (StringUtils.isBlank(userIdString)) {
            return 0L;
        }
        Long userId = UserIDBase64.decoderUserID(userIdString);
        return userId;
    }
}
