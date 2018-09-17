-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.54 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 正在导出表  day1804_manpower.t_dept 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_dept` DISABLE KEYS */;
REPLACE INTO `t_dept` (`dId`, `dName`, `dDes`) VALUES
	(1, '开发', '男生多'),
	(3, '测试', '女生多');
/*!40000 ALTER TABLE `t_dept` ENABLE KEYS */;

-- 正在导出表  day1804_manpower.t_download 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_download` DISABLE KEYS */;
REPLACE INTO `t_download` (`downloadId`, `downloadTittle`, `downloadDes`, `downloadFile`, `downloadCreateTime`, `userId`) VALUES
	(15, 'title4341q', '测试', '', '2018-09-09', 9),
	(16, '文档上传', '测试测试', 'D:\\java\\tools\\apache-tomcat-9.0.10\\webapps\\wtpwebapps\\1804_Manpower\\upload\\英文.txt', '2018-09-10', 9);
/*!40000 ALTER TABLE `t_download` ENABLE KEYS */;

-- 正在导出表  day1804_manpower.t_emp 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `t_emp` DISABLE KEYS */;
REPLACE INTO `t_emp` (`empId`, `empName`, `gender`, `telNum`, `email`, `staffName`, `empEdu`, `cardNum`, `deptName`, `empAddress`, `empCreateTime`, `staffId`, `phone`, `political`, `qq`, `ems`, `birth`, `volk`, `major`, `habiit`, `remark`, `dId`) VALUES
	(1, 'tom', '男', '18408250060', '1318680455@qq.com', 'testjob', '本科', '513911199544553636', 'develop1', 'chengdu', '2018-09-09', 4, '010-66778899', 'worker', '1318680455', '621300', '2018-09-01', 'han', 'math', 'football', 'boy', 1),
	(2, 'mary', '女', '18408250060', '1318680455@qq.com', 'design', '专科', '513911199544553636', 'develop1', 'chengdu', '2018-09-09', 3, '010-66778899', 'worker', '1318680455', '621300', '2018-08-28', 'han', 'math', 'football', 'boy', 1),
	(3, 'jack', '女', '18408250060', '1318680455@qq.com', 'design', '硕士', '513911199544553636', 'test', 'chengdu', '2018-09-09', 3, '010-66778899', 'worker', '1318680455', '621300', '2018-09-12', 'han', 'math', 'football', 'boy', 3),
	(4, 'jack', '女', '18408250060', '1318584@qq.com', 'design', '博士', '523855199511223636', 'test', 'chengdu', '2018-09-09', 3, '010-66778899', 'worker', '1318680455', '621300', '2018-09-07', 'han', 'math', 'football', 'boy', 3),
	(5, 'tom2', '男', '18408250060', '1318584@qq.com', 'design', '博士后', '513622199511556376', 'develop1', 'chengdu', '2018-09-09', 3, '010-66778899', 'worker', '1318680455', '621300', '2018-09-07', 'han', 'math', 'football', 'boy', 1);
/*!40000 ALTER TABLE `t_emp` ENABLE KEYS */;

-- 正在导出表  day1804_manpower.t_notice 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_notice` DISABLE KEYS */;
REPLACE INTO `t_notice` (`noticeId`, `noticeTitle`, `noticeContent`, `noticeUser`, `userId`, `noticeTime`) VALUES
	(1, '放假公告', '放假三天1', 'tom', 10, '2018-09-06'),
	(2, 'notice2', 'notice content', 'tom', 9, '2018-09-06'),
	(8, 'notice3', 'notice context3', 'tom', 9, '2018-09-07');
/*!40000 ALTER TABLE `t_notice` ENABLE KEYS */;

-- 正在导出表  day1804_manpower.t_staff 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_staff` DISABLE KEYS */;
REPLACE INTO `t_staff` (`staffId`, `staffName`, `staffDes`) VALUES
	(2, '开发', '累得要死'),
	(3, '测试', '重复性工作'),
	(4, '需求', '每天写文档');
/*!40000 ALTER TABLE `t_staff` ENABLE KEYS */;

-- 正在导出表  day1804_manpower.t_user 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
REPLACE INTO `t_user` (`userId`, `userName`, `password`, `createTime`, `empName`, `state`, `empId`) VALUES
	(8, '小强', '123456', '2018-09-10', 'jackLogin', 2, 3),
	(9, 'tom', '123456', '2018-09-06', 'tom', 1, 1),
	(10, '玫瑰', '123456', '2018-09-09', 'mary', 1, 2);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
