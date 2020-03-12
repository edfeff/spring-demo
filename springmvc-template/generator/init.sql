CREATE TABLE `sys_dept`
(
    `id`            int(11)      NOT NULL,
    `name`          varchar(255) NOT NULL DEFAULT '',
    `parent_id`     int(11)      NOT NULL DEFAULT '0',
    `level`         varchar(255) NOT NULL DEFAULT '',
    `seq`           int(11)      NOT NULL DEFAULT '0',
    `remark`        varchar(200)          DEFAULT NULL,
    `operator`      varchar(255) NOT NULL DEFAULT '',
    `operator_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operator_ip`   varchar(255) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sys_user`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT,
    `username`     varchar(20) NOT NULL DEFAULT '',
    `telephone`    varchar(20) NOT NULL DEFAULT '',
    `mail`         varchar(20) NOT NULL DEFAULT '',
    `password`     varchar(60) NOT NULL DEFAULT '',
    `dept_id`      int(11)     NOT NULL DEFAULT '0',
    `status`       int(11)     NOT NULL DEFAULT '1' COMMENT '1 正常 0 冻结',
    `remark`       varchar(255)         DEFAULT NULL,
    `operator`     varchar(20) NOT NULL DEFAULT '',
    `operate_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operate_ip`   varchar(20) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sys_role_user`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT,
    `role_id`      int(11)     NOT NULL,
    `user_id`      int(11)     NOT NULL,
    `operator`     varchar(20) NOT NULL DEFAULT '',
    `operate_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operate_ip`   varchar(20) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `sys_acl_module`
(
    `id`            int(11)      NOT NULL,
    `name`          varchar(255) NOT NULL DEFAULT '',
    `parent_id`     int(11)      NOT NULL DEFAULT '0',
    `level`         varchar(255) NOT NULL DEFAULT '',
    `seq`           int(11)      NOT NULL DEFAULT '0',
    `status`        int(11)      NOT NULL DEFAULT '0' comment '1 启用，0 冻结',
    `remark`        varchar(200)          DEFAULT NULL,
    `operator`      varchar(255) NOT NULL DEFAULT '',
    `operator_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operator_ip`   varchar(255) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table `sys_acl`
(
    `id`            int          not null auto_increment primary key,
    `code`          varchar(20)  not null default '',
    `name`          varchar(20)  not null default '',
    `acl_module_id` int(11)      not null default 0,
    `url`           varchar(200) not null default '',
    `type`          int(11)      not null default 0,
    `status`        int(11)      not null default 0 comment '1 enable 0 disabled',
    `seq`           int(11)      not null default 0,
    `remark`        varchar(200)          DEFAULT NULL,
    `operator`      varchar(255) NOT NULL DEFAULT '',
    `operator_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operator_ip`   varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `sys_role`
(
    `id`            int          not null auto_increment primary key,
    `name`          varchar(20)  not null default '',
    `type`          int(11)      not null default 0,
    `status`        int(11)      not null default 1 comment '1 enable 0 disabled',
    `remark`        varchar(200)          DEFAULT NULL,
    `operator`      varchar(255) NOT NULL DEFAULT '',
    `operator_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operator_ip`   varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sys_role_acl`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT,
    `role_id`      int(11)     NOT NULL,
    `acl_id`       int(11)     NOT NULL,
    `operator`     varchar(20) NOT NULL DEFAULT '',
    `operate_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operate_ip`   varchar(20) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `sys_log`
(
    `id`           int(11)     not null auto_increment,
    `type`         int(11)     not null comment '1-部门 2-用户 3-权限模块 4-权限 5-角色 6-角色用户关系 7-角色权限关系  ',
    `target_id`    int(11)     not null,
    `old_value`    text,
    `new_value`    text,
    `operator`     varchar(20) NOT NULL DEFAULT '',
    `operate_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `operate_ip`   varchar(20) NOT NULL DEFAULT '',
    `status`       int(11)     not null default 0,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;