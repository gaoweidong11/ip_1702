DROP TABLE IF EXISTS db_exam.ip;
CREATE TABLE db_exam.ip (
  id  INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  min VARCHAR(255) COMMENT '起始 IP 地址',
  max VARCHAR(255) COMMENT '终止 IP 地址',
  geo VARCHAR(255) COMMENT '地理位置'
);
#
# SELECT count(*)
# FROM db_1702.ip;  -- 输出数据的个数
#
# SELECT *
# FROM db_1702.ip;  -- 显示所有的数据