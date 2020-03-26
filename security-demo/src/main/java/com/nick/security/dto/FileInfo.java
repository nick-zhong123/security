package com.nick.security.dto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author weizhong
 * @date 2020/3/26 9:51 AM
 * @package com.nick.security.dto
 * @description
 *
 */
@Data
@Builder
public class FileInfo {

    private String pathInfo;

    public FileInfo(String pathInfo) {
        this.pathInfo = pathInfo;
    }

}
