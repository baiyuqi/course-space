DROP TABLE IF EXISTS `orm_product`;
DROP TABLE IF EXISTS `orm_product_category`;
CREATE TABLE `orm_product` (
  `id` VARCHAR(64) NOT NULL UNIQUE PRIMARY KEY COMMENT '主键',
  `name` VARCHAR(32) NOT NULL UNIQUE COMMENT '用户名',
  `description` VARCHAR(32)  COMMENT '描述',
  `product_category_id` VARCHAR(32) COMMENT '类型',
  `image_id` VARCHAR(32) UNIQUE COMMENT '图片',
  `available_item_count` INT(11) NOT NULL COMMENT '库存',
  `created_at` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT NOW() COMMENT '上次更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';

CREATE TABLE `orm_product_category` (
  `id` VARCHAR(64) NOT NULL UNIQUE PRIMARY KEY COMMENT '主键',
  `name` VARCHAR(32) NOT NULL UNIQUE COMMENT '用户名',
  `description` VARCHAR(32) COMMENT '描述',
  `created_at` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT NOW() COMMENT '上次更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';
