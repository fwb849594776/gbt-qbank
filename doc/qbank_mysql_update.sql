ALTER TABLE exercise
  ADD COLUMN
  chapter              varchar(50) comment '所属课本章节';

ALTER TABLE exercise
  ADD COLUMN cert_level           int comment '所属证书等级：1-一级, 2-二级， 3-三级';
