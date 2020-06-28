/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : shoppingstreet

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-04-16 10:28:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(40) NOT NULL COMMENT '标题',
  `content` varchar(1000) NOT NULL COMMENT '内容',
  `createTime` varchar(10) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__SS___C63B5EE724927208` (`id`),
  UNIQUE KEY `UQ__SS___C12AD09D276EDEB3` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=704 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('531', '会员特惠月开始了', '会员特惠月开始了,亲们赶快下单啊,不到剁手誓不罢休啊,不到离婚誓不清空购物车啊。更多优惠，尽在易买网。', '2010-12-22');
INSERT INTO `news` VALUES ('597', '迎双旦促销大酬宾', '迎双旦促销大酬宾', '2010-12-24');
INSERT INTO `news` VALUES ('649', '加入会员，赢千万大礼包', '加入会员，赢千万大礼包', '2010-12-22');
INSERT INTO `news` VALUES ('650', '新年不夜天，通宵也是开张了', '新年不夜天，通宵也是开张了', '2011-05-22');
INSERT INTO `news` VALUES ('651', '积分兑换开始了', '积分兑换开始了', '2010-12-22');
INSERT INTO `news` VALUES ('653', '团购阿迪1折起', '团购阿迪1折起', '2010-12-22');
INSERT INTO `news` VALUES ('664', '最新酷睿笔记本', 'IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。', '2013-08-05');
INSERT INTO `news` VALUES ('675', 'aa', '012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789', '2013-08-14');
INSERT INTO `news` VALUES ('676', 'ResultR', 'ResultResultResultResultResu', '2016-03-28');
INSERT INTO `news` VALUES ('677', '会员特惠月开始了1', '会员特惠月开始了', '2010-12-22');
INSERT INTO `news` VALUES ('678', '迎双旦促销大酬宾2', '迎双旦促销大酬宾', '2010-12-24');
INSERT INTO `news` VALUES ('679', '加入会员，赢千万大礼包3', '加入会员，赢千万大礼包', '2010-12-22');
INSERT INTO `news` VALUES ('680', '新年不夜天，通宵也是开张了4', '新年不夜天，通宵也是开张了', '2011-05-22');
INSERT INTO `news` VALUES ('681', '积分兑换开始了5', '积分兑换开始了', '2010-12-22');
INSERT INTO `news` VALUES ('682', '团购阿迪1折起6', '团购阿迪1折起', '2010-12-22');
INSERT INTO `news` VALUES ('683', '最新酷睿笔记本7', 'IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。', '2013-08-05');
INSERT INTO `news` VALUES ('684', 'aa8', '012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789', '2013-08-14');
INSERT INTO `news` VALUES ('685', 'ResultR9', 'ResultResultResultResultResu', '2016-03-28');
INSERT INTO `news` VALUES ('686', '会员特惠月开始了11', '会员特惠月开始了', '2010-12-22');
INSERT INTO `news` VALUES ('687', '迎双旦促销大酬宾21', '迎双旦促销大酬宾', '2010-12-24');
INSERT INTO `news` VALUES ('688', '加入会员，赢千万大礼包31', '加入会员，赢千万大礼包', '2010-12-22');
INSERT INTO `news` VALUES ('689', '新年不夜天，通宵也是开张了41', '新年不夜天，通宵也是开张了', '2011-05-22');
INSERT INTO `news` VALUES ('690', '积分兑换开始了51', '积分兑换开始了', '2010-12-22');
INSERT INTO `news` VALUES ('691', '团购阿迪1折起61', '团购阿迪1折起', '2010-12-22');
INSERT INTO `news` VALUES ('692', '最新酷睿笔记本71', 'IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。', '2013-08-05');
INSERT INTO `news` VALUES ('693', 'aa81', '012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789', '2013-08-14');
INSERT INTO `news` VALUES ('694', 'ResultR91', 'ResultResultResultResultResu', '2016-03-28');
INSERT INTO `news` VALUES ('695', '会员特惠月开始了111', '会员特惠月开始了', '2010-12-22');
INSERT INTO `news` VALUES ('696', '迎双旦促销大酬宾211', '迎双旦促销大酬宾', '2010-12-24');
INSERT INTO `news` VALUES ('697', '加入会员，赢千万大礼包311', '加入会员，赢千万大礼包', '2010-12-22');
INSERT INTO `news` VALUES ('698', '新年不夜天，通宵也是开张了411', '新年不夜天，通宵也是开张了', '2011-05-22');
INSERT INTO `news` VALUES ('699', '积分兑换开始了511', '积分兑换开始了', '2010-12-22');
INSERT INTO `news` VALUES ('700', '团购阿迪1折起611', '团购阿迪1折起', '2010-12-22');
INSERT INTO `news` VALUES ('701', '最新酷睿笔记本711', 'IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。', '2013-08-05');
INSERT INTO `news` VALUES ('702', 'aa811', '012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789', '2013-08-14');
INSERT INTO `news` VALUES ('703', 'ResultR911', 'ResultResultResultResultResu', '2016-03-28');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(255) DEFAULT NULL COMMENT '用户主键',
  `loginName` varchar(255) DEFAULT NULL,
  `userAddress` varchar(255) DEFAULT NULL COMMENT '用户地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `cost` float DEFAULT NULL COMMENT '总消费',
  `serialNumber` varchar(255) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '18', 'shangzezhong', '北京市花园路小区', '2016-06-02 14:51:46', '1721', '60B7487F47F9434EAA5FD1D9E22CB06C');
INSERT INTO `order` VALUES ('2', '18', 'shangzezhong', '北京市海淀区成府路', '2016-06-02 14:52:49', '8596', '8EF5E1557D55413781658A65FC301B8A');
INSERT INTO `order` VALUES ('3', '2', 'admin', '北京市海淀区大有庄', '2016-06-03 11:41:09', '456', '51718726C1274CC59504AB4E6FD64BA0');
INSERT INTO `order` VALUES ('6', '21', 'fsfsfsf', '用户地址', '2018-02-16 17:23:55', '2074', '1354C1BDC92F4F7B95FDD0F582ECED04');
INSERT INTO `order` VALUES ('7', '21', 'fsfsfsf', '用户地址', '2018-02-16 17:29:46', '2381', '347340782FF844F8BDDB03B3E4FCB770');
INSERT INTO `order` VALUES ('8', '21', 'fsfsfsf', '用户地址', '2018-02-16 17:31:59', '2074', '08BEA7CA9C5041C899A5CC73721A8048');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderId` int(10) NOT NULL COMMENT '订单主键',
  `productId` int(10) NOT NULL COMMENT '商品主键',
  `quantity` int(10) NOT NULL COMMENT '数量',
  `cost` float NOT NULL COMMENT '消费',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__SS___66E1BD8E2F10007B` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '1', '733', '5', '760');
INSERT INTO `order_detail` VALUES ('2', '1', '734', '4', '608');
INSERT INTO `order_detail` VALUES ('3', '1', '735', '1', '152');
INSERT INTO `order_detail` VALUES ('4', '1', '738', '1', '45');
INSERT INTO `order_detail` VALUES ('5', '1', '739', '1', '156');
INSERT INTO `order_detail` VALUES ('6', '2', '755', '1', '8596');
INSERT INTO `order_detail` VALUES ('7', '3', '733', '1', '152');
INSERT INTO `order_detail` VALUES ('8', '3', '734', '1', '152');
INSERT INTO `order_detail` VALUES ('9', '3', '735', '1', '152');
INSERT INTO `order_detail` VALUES ('12', '6', '744', '2', '589');
INSERT INTO `order_detail` VALUES ('13', '6', '747', '1', '896');
INSERT INTO `order_detail` VALUES ('14', '7', '744', '1', '589');
INSERT INTO `order_detail` VALUES ('15', '7', '747', '2', '896');
INSERT INTO `order_detail` VALUES ('16', '8', '744', '2', '589');
INSERT INTO `order_detail` VALUES ('17', '8', '747', '1', '896');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `price` float NOT NULL COMMENT '价格',
  `stock` int(10) NOT NULL COMMENT '库存',
  `categoryLevel1Id` int(10) DEFAULT NULL COMMENT '分类1',
  `categoryLevel2Id` int(10) DEFAULT NULL COMMENT '分类2',
  `categoryLevel3Id` int(10) DEFAULT NULL COMMENT '分类3',
  `fileName` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1：删除 0：未删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__SS___94F6E55132E0915F` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=771 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('733', '香奈儿', '订单', '152', '94', '548', '654', '655', '27A1789ED5764D82A5506DF3DC3933F9.jpg', '0');
INSERT INTO `product` VALUES ('734', '洗面奶', '', '152', '995', '548', '654', '655', 'D6C9BD438C5643D6B1A6C52E5426FE22.jpg', '0');
INSERT INTO `product` VALUES ('735', '啫喱水', '', '152', '998', '548', '654', '655', '1A836D2B3A3348DDAB19807E6CEA8028.jpg', '0');
INSERT INTO `product` VALUES ('736', '香水5852', '', '152', '1000', '548', '654', '655', '4D9499BAD92A42D291094E797BA2EA3F.jpg', '0');
INSERT INTO `product` VALUES ('737', '香水', '', '152', '111', '548', '654', '655', 'A9924F9DB68B4DF99FDBF05902075AF0.jpg', '0');
INSERT INTO `product` VALUES ('738', '润肤露', '', '45', '109', '548', '654', '655', '3B059EDB5237407980458CE9EA9D3204.jpg', '0');
INSERT INTO `product` VALUES ('739', '洁面装', '', '156', '99', '548', '654', '655', 'A62C6DF55116440CA3DE9DB37901ED4F.jpg', '0');
INSERT INTO `product` VALUES ('740', '电饭锅', '', '158', '100', '628', '656', '659', '40C3B76BA31246618E3CFC8723D33517.jpg', '0');
INSERT INTO `product` VALUES ('741', '婴儿喂奶装', '', '569', '100', '632', '637', '653', '401004B3D47C4C6FB1BC5EF19C21FC77.jpg', '0');
INSERT INTO `product` VALUES ('742', '坚果套餐', '', '158', '1000', '660', '661', '662', 'E03D74145A034F6D909879829CB99D80.jpg', '0');
INSERT INTO `product` VALUES ('743', '超甜蜜崭', '', '589', '1000', '660', '661', '663', '7121E55099FC477680B1229205CE3D29.jpg', '0');
INSERT INTO `product` VALUES ('744', '华为2566', '', '589', '1000', '670', '671', '672', 'hw1.jpg', '0');
INSERT INTO `product` VALUES ('745', '荣耀3C', '', '589', '100', '670', '671', '672', 'F3921E12552A4D0AA3F75467B146A959.jpg', '0');
INSERT INTO `product` VALUES ('746', '小米手环', '', '963', '100', '670', '674', '675', '72F75A371B0B4C26A7F72FAAEF96FC68.jpg', '0');
INSERT INTO `product` VALUES ('747', '华为2265', '', '896', '1000', '670', '671', '673', 'hw1.jpg', '0');
INSERT INTO `product` VALUES ('748', '越南坚果', '', '520', '1000', '660', '661', '662', 'CBC98D3C9E544830821632F5C313D93E.jpg', '0');
INSERT INTO `product` VALUES ('749', '日本进口马桶', '', '5866', '100', '628', '657', '0', 'A5AF40825E6940B2A59A040100E181A8.jpg', '0');
INSERT INTO `product` VALUES ('750', '联想Y系列', '', '569', '1000', '670', '690', '691', '956DB0BEC41B41B8A06C05C950130E23.jpg', '0');
INSERT INTO `product` VALUES ('751', '脑白金1号', '', '589', '1000', '676', '677', '680', '66E96AF9E9714A5C9EA901811173D662.jpg', '0');
INSERT INTO `product` VALUES ('752', '莫里斯按', '', '589', '1000', '676', '678', '0', 'A7436BC607E74C81B392DCFE69D4AEAB.jpg', '0');
INSERT INTO `product` VALUES ('753', '三鹿好奶粉', '', '859', '100', '676', '679', '0', '3C465E7B8A324A8DA2A2EEE202E36166.jpg', '0');
INSERT INTO `product` VALUES ('754', '儿童牛奶', '', '5896', '100', '676', '679', '0', 'D1AC9AE71ED348FA8D880FD4279D3422.jpg', '0');
INSERT INTO `product` VALUES ('755', '软沙发', '', '8596', '99', '628', '696', '0', 'ED7921DE40FC47E18365754709A21194.jpg', '0');
INSERT INTO `product` VALUES ('756', '收纳盒', '', '5966', '100', '628', '696', '0', 'DB86CA25CA4F4B4AA906F46BE542C6A6.jpg', '0');
INSERT INTO `product` VALUES ('757', '洗衣液', '', '58', '1000', '628', '696', '0', 'E6CCDC343ACC471C908E9748776C6421.jpg', '0');
INSERT INTO `product` VALUES ('758', '红短沙发', '', '596', '123', '628', '696', '0', 'BD5C77465DC2466BBCE7F95FB9764392.jpg', '0');
INSERT INTO `product` VALUES ('759', '新西兰奶粉', '', '5896', '100', '676', '679', '0', '9ED375098D42497B8FC33167E06D0EE8.jpg', '0');
INSERT INTO `product` VALUES ('760', '婴儿车', '', '11000', '100', '681', '682', '687', '1DBC0930641D43C29D74A9E1B40FEEBB.jpg', '0');
INSERT INTO `product` VALUES ('761', '夏款婴儿车', '', '963', '100', '681', '682', '688', '16290C4DBEAC4F00A636667019621468.jpg', '0');
INSERT INTO `product` VALUES ('762', '抗压旅行箱', '', '569', '1000', '681', '683', '685', '272CC434BE7A4469AB0E7882BD1A85FF.jpg', '0');
INSERT INTO `product` VALUES ('763', '透明手提箱', '', '8596', '1000', '681', '683', '684', 'EAA8E66259BF4239B4A2237B62520EF1.jpg', '0');
INSERT INTO `product` VALUES ('764', '婴儿果粉', '', '5896', '1000', '660', '661', '662', '08BE30BF7B5F4930B0093D8CC4056057.jpg', '0');
INSERT INTO `product` VALUES ('765', '椰子粉', '', '5963', '1000', '660', '661', '662', '9C006B8BD1AD45398F474A8471ADC50B.jpg', '0');
INSERT INTO `product` VALUES ('766', '坚果蛋糕', '', '200', '100', '660', '661', '663', '2E5A16E21E0640E0BAE03E9B995DCD28.jpg', '0');
INSERT INTO `product` VALUES ('767', '编制手提箱', '', '5896', '1000', '681', '682', '688', '2E1D2A5E65A94FEEA17C72E47C530057.jpg', '0');
INSERT INTO `product` VALUES ('768', '纸箱', '', '5896', '100', '681', '682', '687', '443E5A4122064209AFE89250179A2FF0.jpg', '0');
INSERT INTO `product` VALUES ('769', '健胃液', '', '152', '1000', '676', '679', '0', '30B5547CD7384DAA8A2F4F4D8C0BBF89.jpg', '0');
INSERT INTO `product` VALUES ('770', '联想NTC', '', '8596', '100', '670', '671', '673', '48BC371A85A548B7A7589E3F542D911D.jpg', '0');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `parentId` int(10) NOT NULL COMMENT '父级目录id',
  `type` int(11) DEFAULT NULL COMMENT '级别(1:一级 2：二级 3：三级)',
  `iconClass` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__SS___9EC2A4E236B12243` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('548', '化妆品', '0', '1', '');
INSERT INTO `product_category` VALUES ('628', '家用商品', '0', '1', '');
INSERT INTO `product_category` VALUES ('654', '面部护理', '548', '2', '');
INSERT INTO `product_category` VALUES ('655', '少女派', '654', '3', '');
INSERT INTO `product_category` VALUES ('656', '餐具', '628', '2', '');
INSERT INTO `product_category` VALUES ('657', '卫具', '628', '2', '');
INSERT INTO `product_category` VALUES ('658', '叉子', '656', '3', '');
INSERT INTO `product_category` VALUES ('659', '锅', '656', '3', '');
INSERT INTO `product_category` VALUES ('660', '进口食品,生鲜', '0', '1', '');
INSERT INTO `product_category` VALUES ('661', '零食/糖果/巧克力', '660', '2', '');
INSERT INTO `product_category` VALUES ('662', '坚果', '661', '3', '');
INSERT INTO `product_category` VALUES ('663', '蜜饯', '661', '3', '');
INSERT INTO `product_category` VALUES ('669', '孕期教育', '546', '3', '');
INSERT INTO `product_category` VALUES ('670', '电子商品', '0', '1', '');
INSERT INTO `product_category` VALUES ('671', '手机', '670', '2', '');
INSERT INTO `product_category` VALUES ('672', '华为手机', '671', '3', '');
INSERT INTO `product_category` VALUES ('673', '联想手机', '671', '3', '');
INSERT INTO `product_category` VALUES ('674', '手环', '670', '2', '');
INSERT INTO `product_category` VALUES ('675', '小米手环', '674', '3', '');
INSERT INTO `product_category` VALUES ('676', '保健食品', '0', '1', '');
INSERT INTO `product_category` VALUES ('677', '老年保健品', '676', '2', '');
INSERT INTO `product_category` VALUES ('678', '中年营养品', '676', '2', '');
INSERT INTO `product_category` VALUES ('679', '儿童保健品', '676', '2', '');
INSERT INTO `product_category` VALUES ('680', '脑白金', '677', '3', '');
INSERT INTO `product_category` VALUES ('681', '箱包', '0', '1', '');
INSERT INTO `product_category` VALUES ('682', '旅行箱', '681', '2', '');
INSERT INTO `product_category` VALUES ('683', '手提箱', '681', '2', '');
INSERT INTO `product_category` VALUES ('684', '大型', '683', '3', '');
INSERT INTO `product_category` VALUES ('685', '小型', '683', '3', '');
INSERT INTO `product_category` VALUES ('686', '中型', '683', '3', '');
INSERT INTO `product_category` VALUES ('687', '大型', '682', '3', '');
INSERT INTO `product_category` VALUES ('688', '中型', '682', '3', '');
INSERT INTO `product_category` VALUES ('689', '小型', '682', '3', '');
INSERT INTO `product_category` VALUES ('690', '电脑', '670', '2', '');
INSERT INTO `product_category` VALUES ('691', '联想电脑', '690', '3', '');
INSERT INTO `product_category` VALUES ('692', '刀叉', '656', '3', null);
INSERT INTO `product_category` VALUES ('693', '碗筷', '656', '3', null);
INSERT INTO `product_category` VALUES ('696', '客厅专用', '628', '2', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` varchar(255) NOT NULL COMMENT '登录名',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `sex` int(2) DEFAULT '1' COMMENT '性别(1:男 0：女)',
  `identityCode` varchar(60) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `type` int(2) DEFAULT '0' COMMENT '类型（1：后台 0:前台）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__SS___C96109CC3A81B327` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'admin', '系统管理员', 'e10adc3949ba59abbe56e057f20f883e', '1', '130406198302141869', 'hello11@bdqn.com', '1583233515', '1');
INSERT INTO `user` VALUES ('10', 'cgn', '程广宁', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '1044732267@qq.com', '13366055011', '0');
INSERT INTO `user` VALUES ('11', 'hyl', '韩语良', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225198874584539', '1044732267@qq.com', '13366055010', '0');
INSERT INTO `user` VALUES ('12', 'ck', '陈康', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '1044732267@qq.com', '13366055010', '0');
INSERT INTO `user` VALUES ('13', 'kys', '康有沈', 'e10adc3949ba59abbe56e057f20f883e', '1', '1402251985512541525', '1044732267@qq.com', '13366055010', '0');
INSERT INTO `user` VALUES ('14', 'sb', '沈白', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225158987854589', '1044732267@qq.com', '13366055010', '0');
INSERT INTO `user` VALUES ('15', 'lb', '李白', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '10447322658@qq.com', '1336998554', '0');
INSERT INTO `user` VALUES ('16', 'lgw', '李高伟', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '1011322658@qq.com', '1336998554', '0');
INSERT INTO `user` VALUES ('18', 'shangzezhong', '尚泽忠', '4297f44b13955235245b2497399d7a93', '1', '140225198810013745', '1044888844@qq.com', '13366528458', '0');
INSERT INTO `user` VALUES ('19', 'liguangliang', '李光亮', '25f9e794323b453885f5181f1b624d0b', '1', '140225198841547785', '1047777@qq.com', '13366055048', '0');
INSERT INTO `user` VALUES ('20', 'szz', '李光亮', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225198810013748', '1044732267@qq.com', '13366555010', '1');
INSERT INTO `user` VALUES ('21', 'fsfsfsf', null, '123', '1', null, 'a1a1@163.com', '2242424', '0');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userId` int(255) DEFAULT NULL COMMENT '用户主键',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `isDefault` int(2) DEFAULT '0' COMMENT '是否是默认地址（1:是 0否）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES ('11', '2', '北京市海淀区大有庄', null, '0', '朋友家');
INSERT INTO `user_address` VALUES ('12', '2', '北京市海淀区大有庄', null, '0', '女朋友公司');
INSERT INTO `user_address` VALUES ('13', '9', '北京市西直门大桥芬兰国际大厦', null, '0', '女朋友地址');
INSERT INTO `user_address` VALUES ('14', '18', '北京市花园路小区', null, '0', '家里');
INSERT INTO `user_address` VALUES ('15', '18', '北京市海淀区成府路', null, '0', '公司');
