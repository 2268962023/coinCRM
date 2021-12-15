package com.three.coinexchange.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SysMenu implements Serializable {

        private static final long serialVersionUID = -6887932268599679668L;
        /**
         * 菜单编号
         */
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Long id;

        /**
         * 父节点
         */
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Long parentId;

        /**
         * 标题
         */
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String title;

        /**
         * 菜单类型
         */
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String type;

        /**
         * 打 开 类 型
         */
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String openType;

        /**
         * 图标
         */
        private String icon;

        /**
         * 跳转路径
         */
        private String href;

        /**
         * 子菜单
         */
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private List<SysMenu> children = new ArrayList<>();

        public SysMenu() {
        }

        public SysMenu(Long id, Long parentId, String title, String icon,String type, String openType, String href) {
                this.id = id;
                this.parentId = parentId;
                this.title = title;
                this.type = type;
                this.openType = openType;
                this.icon = icon;
                this.href = href;
        }

        public SysMenu(Long id, String title,String icon,String type,String href,List<SysMenu> children) {
                this.id = id;
                this.title = title;
                this.type = type;
                this.icon = icon;
                this.href = href;
                this.children=children;
        }

        public SysMenu(Long id, String title,String icon,String type,String openType,String href) {
                this.id = id;
                this.title = title;
                this.type = type;
                this.icon = icon;
                this.href = href;
                this.openType=openType;
        }

}
